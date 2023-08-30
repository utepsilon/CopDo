package com.core.copdo.services;

import com.core.copdo.models.Response;
import com.core.copdo.models.Todo;
import com.core.copdo.models.User;
import com.core.copdo.repository.UserRepository;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<ResponseEntity<Response>> saveUser(User user) {

        try {
            user.setTodoList(new ArrayList<>());
           Mono<User>  savedUser = userRepository.save(user);
            return Optional.of(new ResponseEntity<>(new Response(HttpStatus.CREATED, savedUser.block(), LocalDateTime.now()), HttpStatus.OK));
        } catch (Exception e) {
            if (e instanceof NullPointerException) {

            }
            if (e instanceof MongoException) {

            }
            if (e instanceof InvalidPropertiesFormatException) {

            }
        }
        return Optional.empty();
    }


    public Optional<ResponseEntity<Response>> getUserDetails(String userId){

        try {

                Mono<User> userMono = userRepository.findById(userId);

                return Optional.of(new ResponseEntity<>(new Response(HttpStatus.CREATED, userMono.block(), LocalDateTime.now()), HttpStatus.OK));
        }
        catch (Exception e){

        }

        return Optional.empty();
    }

    public Optional<ResponseEntity<Response>> updateUserTodos(List<Todo> todoList,String userId){

        try {

            User existingUser = userRepository.findById(userId).block();
            existingUser.setTodoList(todoList);
            userRepository.save(existingUser);

            return Optional.of(new ResponseEntity<>(new Response(HttpStatus.ACCEPTED,existingUser,LocalDateTime.now()),HttpStatus.OK));
        }
        catch (Exception e){

        }

        return Optional.empty();
    }
}
