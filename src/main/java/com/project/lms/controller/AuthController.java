package com.project.lms.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.ResponseEntity;
import com.project.lms.Service.JwtUtil;
import com.project.lms.payload.LoginRequest;
import com.project.lms.payload.LoginResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.project.lms.payload.SigninRequest;
import com.project.lms.payload.SigninRespond;
import com.project.lms.entity.User;
import com.project.lms.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (Exception e) {
            // Return 401 Unauthorized instead of 403
            return ResponseEntity.status(401).body("Invalid username or password");
    }

}

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SigninRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(request.getRole());
        userRepository.save(newUser);
        String token = jwtUtil.generateToken(newUser.getUsername());
        return ResponseEntity.ok(new SigninRespond(token));

       
    }
}