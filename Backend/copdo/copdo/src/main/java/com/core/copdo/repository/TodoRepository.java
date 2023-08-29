package com.core.copdo.repository;

import com.core.copdo.models.Todo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TodoRepository extends ReactiveMongoRepository<Todo,String> {
}
