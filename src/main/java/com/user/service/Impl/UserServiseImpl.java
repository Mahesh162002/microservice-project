package com.user.service.Impl;

import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UesrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiseImpl implements UesrService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        
        //Ganrate unic usdrId
        
        String randamUserId = UUID.randomUUID().toString();
        user.setUserId(randamUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with not found on the server !!"+userId));
    }
}
