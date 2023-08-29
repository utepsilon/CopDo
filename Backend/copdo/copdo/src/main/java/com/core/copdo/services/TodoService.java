package com.core.copdo.services;

import com.core.copdo.models.Response;
import com.core.copdo.models.Todo;
import com.core.copdo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public ResponseEntity<Response> saveTodo(Todo todo)
    {
        Mono<Todo> savedTodo =  todoRepository.save(todo);

        return  new ResponseEntity<>(new Response(
                HttpStatus.CREATED,
                savedTodo,
                LocalDateTime.now()
        ),HttpStatus.OK);
    }
}
