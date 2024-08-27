package com.intern.layoutviews.service;

import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
}
