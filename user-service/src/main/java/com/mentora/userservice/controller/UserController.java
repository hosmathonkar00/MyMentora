package com.mentora.userservice.controller;

import com.mentora.userservice.dto.LoginRequest;
import com.mentora.userservice.entity.User;
import com.mentora.userservice.repository.UserRepository;
import com.mentora.userservice.service.UserService;
import com.mentora.userservice.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/users")

public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder,UserRepository userRepository,JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository= userRepository;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("adduser")
    public User addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail());
        }
        return "Invalid credentials!";
    }


    @GetMapping("getalluser")
    public List<User> userList() {
        return userService.getAllUsers();
    }

    @GetMapping("userById/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/deleteById/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}