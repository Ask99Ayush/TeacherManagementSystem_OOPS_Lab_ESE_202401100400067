package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    // In-memory storage for teachers
    private final Map<Long, User> teacherStore = new HashMap<>();

    // Auto-increment ID generator
    private final AtomicLong idCounter = new AtomicLong();

    // CREATE / UPDATE
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.incrementAndGet());
        }
        teacherStore.put(user.getId(), user);
        return user;
    }

    // READ ALL
    public Collection<User> findAll() {
        return teacherStore.values();
    }

    // DELETE
    public void deleteById(Long id) {
        teacherStore.remove(id);
    }
}
