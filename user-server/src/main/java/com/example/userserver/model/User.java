package com.example.userserver.model;

public class User {

    private Long id;

    private String userName;

    private String password;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){}

    public User(Long id){
        this.id = id;
    }

    public User(String userName, Integer age){
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName: " + userName + ";age: " + age;
    }
}
