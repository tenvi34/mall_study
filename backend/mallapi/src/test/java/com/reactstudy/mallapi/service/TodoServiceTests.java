package com.reactstudy.mallapi.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactstudy.mallapi.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTests {
    
    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                            .title("서비스 테스트")
                            .writer("tester")
                            .dueDate(LocalDate.of(2023,12,31))
                            .build();

        Long tno = todoService.register(todoDTO);

        log.info("TNO: " + tno);
    }
}
