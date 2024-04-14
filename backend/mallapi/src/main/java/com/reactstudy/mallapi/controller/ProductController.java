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

import org.springframework.web.bind.annotation.PostMapping;
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
    
}
