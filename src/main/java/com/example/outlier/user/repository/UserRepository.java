package com.example.outlier.user.repository;


import com.example.outlier.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    UserDto getUserByEmail(String email);
    UserDto getUser(String username);
    List<UserDto> getUserList();
    void insertUser(UserDto userDto);
    void deleteUser(long userId);

    void updateUser(UserDto userDto);
}
