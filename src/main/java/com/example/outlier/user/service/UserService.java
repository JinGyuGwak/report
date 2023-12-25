package com.example.outlier.user.service;

import com.example.outlier.common.login.jwt.JwtTokenProvider;
import com.example.outlier.user.dto.UserDto;
import com.example.outlier.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.outlier.common.login.jwt.JwtFilter.AUTHORIZATION_HEADER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserDto> getUserList(){
        return userRepository.getUserList();
    }

    @Transactional
    public UserDto insertUser(UserDto user){
        String encryptPwd;
        try{
            encryptPwd = passwordEncoder.encode(user.getPassword());
        } catch (Exception exception) {
            throw new IllegalArgumentException("비밀번호 암호화에 실패하였습니다.");
        }

        UserDto saveUser =
                UserDto.builder()
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .password(encryptPwd)
                        .role(user.getRole())
                        .build();
        userRepository.insertUser(saveUser);
        return saveUser;
    }

    @Transactional
    public String deleteUser(long userId){
        try {
            userRepository.deleteUser(userId);
            return "삭제완료";
        } catch (Exception e){
            throw new IllegalArgumentException("유저 삭제에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public UserDto getUser(String userEmail) {
        try {
            return userRepository.getUserByEmail(userEmail);
        } catch (Exception e){
            throw new IllegalArgumentException("userEmail을 통한 조회에 실패하였습니다.");
        }
    }

    @Transactional
    public UserDto.LoginRes loginUser(UserDto.LoginDto user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());


        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION_HEADER, "Bearer " + jwt);

        UserDto userDto = userRepository.getUserByEmail(user.getEmail());


        return UserDto.LoginRes.builder()
                .email(user.getEmail())
                .jwt(jwt)
                .build();
    }
}
