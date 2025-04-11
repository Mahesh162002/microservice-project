package com.user.controler;


import com.user.entity.User;

import com.user.service.UesrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UesrService userServise;

    @PostMapping
public ResponseEntity<User> cresteUser(@RequestBody User user){


   User user1= userServise.saveUser(user );
   return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
}

//single user created

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingluser(@PathVariable String userId){
        User user = userServise.getUser(userId);
        return  ResponseEntity.ok(user);
    }
// get Allusers
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> allUser = userServise.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
