package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE or UPDATE teacher
    public User saveTeacher(User teacher) {
        return userRepository.save(teacher);
    }

    // READ all teachers
    public Collection<User> getAllTeachers() {
        return userRepository.findAll();
    }

    // DELETE teacher by ID
    public void deleteTeacher(Long id) {
        userRepository.deleteById(id);
    }
}
