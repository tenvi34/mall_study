package com.reactstudy.mallapi.service;

import com.reactstudy.mallapi.dto.TodoDTO;

public interface TodoService {
    
    Long register(TodoDTO todoTDO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

}
