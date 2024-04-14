package com.reactstudy.mallapi.service;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactstudy.mallapi.dto.PageRequestDTO;
import com.reactstudy.mallapi.dto.PageResponseDTO;
import com.reactstudy.mallapi.dto.ProductDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void testList() {

        // 1 page, 10 size
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);

        result.getDtoList().forEach(dto -> log.info(dto));
    }

    @Test
    public void testRegister() {

        ProductDTO productDTO = ProductDTO.builder()
                .pname("새 상품")
                .pdesc("신규 상품 설명")
                .price(1000)
                .build();

        productDTO.setUploadFileNames(List.of(UUID.randomUUID() + "_" + "Test1.jpg", UUID.randomUUID() + "_" + "Test2.jpg"));

        productService.register(productDTO);
    }
}
