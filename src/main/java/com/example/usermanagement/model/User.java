package com.example.usermanagement.model;

public class User {

    private Long id;        // Teacher ID
    private String name;    // Teacher Name
    private String subject; // Subject taught

    // No-argument constructor (required by Spring)
    public User() {
    }

    // Parameterized constructor
    public User(Long id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    // Getter & Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

