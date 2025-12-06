package com.project.lms.payload;

import com.project.lms.entity.Role;

public class SigninRequest {
    private String username;
    private String password;
    private Role role;

    // Default constructor
    public SigninRequest() {}

    // Parameterized constructor
    public SigninRequest(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
}
