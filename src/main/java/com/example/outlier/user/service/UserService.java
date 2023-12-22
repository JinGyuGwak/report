package com.example.outlier.user.service;

import com.example.outlier.user.data.UserDto;
import com.example.outlier.user.data.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<UserDto> getUserList(){
        return userDao.getUserList();
    }

    public UserDto insertUser(UserDto user){
        userDao.insertUser(user);
        return user;
    }

    public String deleteUser(long userId) {
        userDao.deleteUser(userId);
        return "삭제완료";
    }
}
