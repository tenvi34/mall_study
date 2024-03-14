package com.reactstudy.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactstudy.mallapi.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
    
    @Autowired
    private TodoRepository todoRepository;

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

    @Test
    public void testRead() {
        Long tno = 33L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

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

    @Test
    public void testDelete() {
        Long tno = 23L;

        todoRepository.deleteById(tno);
    }
}
