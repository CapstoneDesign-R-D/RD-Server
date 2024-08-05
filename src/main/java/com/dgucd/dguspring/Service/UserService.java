package com.dgucd.dguspring.Service;

import com.dgucd.dguspring.DTO.ErrorResponseDTO;
import com.dgucd.dguspring.DTO.RegisterRequestDTO;
import com.dgucd.dguspring.DTO.RegisterResponseDTO;
import com.dgucd.dguspring.Entity.User;
import com.dgucd.dguspring.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    @Transactional
    public RegisterResponseDTO register(RegisterRequestDTO req) {

        Optional<User> optionalUser = userRepository.findByUserEmail(req.getUserEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("이메일이 이미 존재합니다.");
        }

        User user = User.builder()
                .userEmail(req.getUserEmail())
                .userName(req.getUserName())
                .build();

        userRepository.save(user);

        return RegisterResponseDTO.builder()
                .userName(user.getUserName())
                .message("Success")
                .build();
    }
}
