package com.reactstudy.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactstudy.mallapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
