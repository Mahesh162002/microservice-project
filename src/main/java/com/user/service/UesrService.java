package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface UesrService {


    //User oprations


    //create

        User saveUser(User user);

// get all users


     List<User> getAllUser();


     // get single userof usesrId

    User getUser(String userId);
}

