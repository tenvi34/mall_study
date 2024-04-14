package com.reactstudy.mallapi.service;

import com.reactstudy.mallapi.dto.PageRequestDTO;
import com.reactstudy.mallapi.dto.PageResponseDTO;
import com.reactstudy.mallapi.dto.ProductDTO;

public interface ProductService {
    
    // 서비스 목록
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    // 서비스 등록
    Long register(ProductDTO productDTO);

    // 서비스 조회
    ProductDTO get(Long pno);

    // 서비스 수정
    void modify(ProductDTO productDTO);
    
}
