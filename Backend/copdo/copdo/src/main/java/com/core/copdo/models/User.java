package com.core.copdo.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    private  String userId;

    private String name;

    private String emailId;

    private List<Todo> todoList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public User(String userId, String name, String emailId, List<Todo> todoList) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.todoList = todoList;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", todoList=" + todoList +
                '}';
    }
}
