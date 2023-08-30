package com.core.copdo.controller;

import com.core.copdo.models.Response;
import com.core.copdo.models.Todo;
import com.core.copdo.models.User;
import com.core.copdo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Response> saveUser(@RequestBody User user) {

        return userService.saveUser(user).get();

    }

    @GetMapping("/user/{id}")

    public ResponseEntity<Response> getUserById(@PathVariable String userId) {


        return userService.getUserDetails(userId).get();
    }

    @PutMapping("/user")
    public ResponseEntity<Response> updateUserDetails(@RequestBody List<Todo> todos, @RequestParam("user") String userID) {

        return userService.updateUserTodos(todos, userID).get();
    }
}
