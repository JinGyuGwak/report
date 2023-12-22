package com.example.outlier.user.data;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<UserDto> getUserList();
    void insertUser(UserDto userDto);
    void deleteUser(long userId);
}
