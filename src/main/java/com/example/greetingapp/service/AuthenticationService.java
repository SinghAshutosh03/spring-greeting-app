//package com.example.greetingapp.service;
//
//import com.example.greetingapp.dto.AuthUserDTO;
//import com.example.greetingapp.model.AuthUser;
//import com.example.greetingapp.repository.AuthUserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//
//    private final AuthUserRepository authUserRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public AuthenticationService(AuthUserRepository authUserRepository) {
//        this.authUserRepository = authUserRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    public String registerUser(AuthUserDTO authUserDTO) {
//        if (authUserRepository.existsByEmail(authUserDTO.getEmail())) {
//            return "Email is already in use.";
//        }
//
//        AuthUser newUser = new AuthUser();
//        newUser.setFirstName(authUserDTO.getFirstName());
//        newUser.setLastName(authUserDTO.getLastName());
//        newUser.setEmail(authUserDTO.getEmail());
//        newUser.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));
//
//        authUserRepository.save(newUser);
//        return "User registered successfully!";
//    }
//}

package com.example.greetingapp.service;

import com.example.greetingapp.dto.AuthUserDTO;
import com.example.greetingapp.model.AuthUser;
import com.example.greetingapp.repository.AuthUserRepository;
import com.example.greetingapp.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final AuthUserRepository authUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthenticationService(AuthUserRepository authUserRepository, JwtUtil jwtUtil) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public String registerUser(AuthUserDTO authUserDTO) {
        if (authUserRepository.existsByEmail(authUserDTO.getEmail())) {
            return "Email is already in use.";
        }

        AuthUser newUser = new AuthUser();
        newUser.setFirstName(authUserDTO.getFirstName());
        newUser.setLastName(authUserDTO.getLastName());
        newUser.setEmail(authUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));

        authUserRepository.save(newUser);
        return "User registered successfully!";
    }

    public String loginUser(String email, String password) {
        Optional<AuthUser> userOptional = authUserRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found!";
        }

        AuthUser user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password!";
        }

        return jwtUtil.generateToken(email);
    }
}

