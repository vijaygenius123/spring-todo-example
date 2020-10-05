package com.vijaygenius123.learning.springtodoexample.controllers;

import com.vijaygenius123.learning.springtodoexample.models.Todo;
import com.vijaygenius123.learning.springtodoexample.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        System.out.println(todo.toString());
        return todoRepository.save(todo);
    }


}
