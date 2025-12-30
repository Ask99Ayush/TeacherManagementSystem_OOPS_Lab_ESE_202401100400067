package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE Teacher
    @PostMapping
    public User addTeacher(@RequestBody User teacher) {
        return userService.saveTeacher(teacher);
    }

    // READ all Teachers
    @GetMapping
    public Collection<User> getAllTeachers() {
        return userService.getAllTeachers();
    }

    // UPDATE Teacher
    @PutMapping("/{id}")
    public User updateTeacher(@PathVariable Long id, @RequestBody User teacher) {
        teacher.setId(id);
        return userService.saveTeacher(teacher);
    }

    // DELETE Teacher
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        userService.deleteTeacher(id);
        return "Teacher deleted successfully";
    }
}
