package com.example.outlier.user.dto;


import com.example.outlier.user.enumeration.Role;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    public UserDto(UserDto userDto){
        this.username=userDto.getUsername();
        this.password=userDto.getPassword();
        this.email=userDto.getEmail();
        this.role=userDto.getRole();

    }





    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginDto {
        private String email;
        private String password;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRes {
        String email;
        String jwt;
    }
}
