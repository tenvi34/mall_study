package com.reactstudy.mallapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reactstudy.mallapi.dto.PageRequestDTO;
import com.reactstudy.mallapi.dto.PageResponseDTO;
import com.reactstudy.mallapi.dto.ProductDTO;
import com.reactstudy.mallapi.service.ProductService;
import com.reactstudy.mallapi.util.CustomFileUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/products")
public class ProductController {

    private final CustomFileUtil fileUtil;
    private final ProductService productService;

    // 상품 등록
    @PostMapping("/")
    public Map<String, Long> register(ProductDTO productDTO) {

        log.info("register: " + productDTO);

        List<MultipartFile> files = productDTO.getFiles();

        List<String> uploadFileNames = fileUtil.saveFiles(files);

        productDTO.setUploadFileNames(uploadFileNames);

        log.info(uploadFileNames);

        // 서비스 호출
        Long pno = productService.register(productDTO);

        return Map.of("RESULT", pno);
    }

    // 파일 보여주기
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGet(@PathVariable String fileName) {

        return fileUtil.getFile(fileName);

    }

    // 목록
    @GetMapping("/list")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {

        log.info("list...................");

        return productService.getList(pageRequestDTO);
    }

    // 조회
    @GetMapping("/{pno}")
    public ProductDTO read(@PathVariable(name = "pno") Long pno) {

        return productService.get(pno);

    }

    // 수정
    @PutMapping("/{pno}")
    public Map<String, String> modify(@PathVariable(name = "pno") Long pno, ProductDTO productDTO) {

        productDTO.setPno(pno);

        ProductDTO oldProductDTO = productService.get(pno);

        // 기존 파일
        List<String> oldFileNames = oldProductDTO.getUploadFileNames();

        // 새로 업로드
        List<MultipartFile> files = productDTO.getFiles();

        // 새로 업로드 후 만들어진 파일 이름
        List<String> currentUploadFileNames = fileUtil.saveFiles(files);

        // 화면상에서 수정없이 유지된 파일
        List<String> uploadFileNames = productDTO.getUploadFileNames();

        // 유지된 파일 + 새로 업로드 된 파일
        if (currentUploadFileNames != null && currentUploadFileNames.size() > 0) {
            uploadFileNames.addAll(currentUploadFileNames);
        }

        // 수정 실행
        productService.modify(productDTO);

        if (oldFileNames != null && oldFileNames.size() > 0) {

            // 삭제되는 파일 목록 착기
            List<String> removeFiles = oldFileNames.stream().filter(fileName -> uploadFileNames.indexOf(fileName) == -1)
                    .collect(Collectors.toList());

            // 파일 삭제
            fileUtil.deleteFiles(removeFiles);
        }

        return Map.of("RESULT", "SUCCESS");
    }

}
