package com.example.outlier.user.controller;


import com.example.outlier.user.data.UserDto;
import com.example.outlier.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<UserDto> getUser(){
        return userService.getUserList();
    }
    @PostMapping("")
    public ResponseEntity<UserDto> insertUser(@RequestBody UserDto user){
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
}
