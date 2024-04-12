package com.reactstudy.mallapi.service;

import com.reactstudy.mallapi.dto.PageRequestDTO;
import com.reactstudy.mallapi.dto.PageResponseDTO;
import com.reactstudy.mallapi.dto.ProductDTO;

public interface ProductService {
    
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);
    
}
