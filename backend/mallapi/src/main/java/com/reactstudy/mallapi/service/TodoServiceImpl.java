package com.reactstudy.mallapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reactstudy.mallapi.domain.Todo;
import com.reactstudy.mallapi.dto.TodoDTO;
import com.reactstudy.mallapi.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;
    
    @Override
    public Long register(TodoDTO todoDTO) {

        log.info("...............");

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        return savedTodo.getTno();
    }
}
