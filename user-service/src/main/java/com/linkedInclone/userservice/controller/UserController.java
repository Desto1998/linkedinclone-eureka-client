package com.linkedInclone.userservice.controller;

import com.linkedInclone.userservice.model.User;
import com.linkedInclone.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public User login(String email, String password){
        return userService.login(email, password);
    }

    @GetMapping
    public List<User> fetchUsers(){
        return  userService.fetchUsers();
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable int id){
        return userService.fetchUserById(id);
    }

    @PutMapping("/{id}")
    public User fetchUserById(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

//    @PutMapping("last_login/{id}")
//    public User userLastLogin(@PathVariable int id){
//        return userService.updateLastLogin(id);
//    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
