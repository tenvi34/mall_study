package com.reactstudy.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.reactstudy.mallapi.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
    
    @Autowired
    private TodoRepository todoRepository;

    // 생성
    @Test
    public void testInsert() {
        log.info("=============테스트=============");
        
        for (int i = 1; i <= 100; i++) {
            Todo todo = Todo.builder()
            .title("Title: " + i)
            .dueDate(LocalDate.of(2023, 12, 31))
            .writer("User00")
            .build();

            todoRepository.save(todo);
        }
    }

    // 조회
    @Test
    public void testRead() {
        Long tno = 33L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

    // 수정
    @Test
    public void testModify() {
        Long tno = 34L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();
        todo.changeTitle("Modified: " + tno);
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2024,01,01));

        todoRepository.save(todo);
    }

    // 삭제
    @Test
    public void testDelete() {
        Long tno = 23L;

        todoRepository.deleteById(tno);
    }

    // 페이징
    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result.getTotalElements());

        result.getContent().stream().forEach(todo -> log.info(todo));
    }
}
