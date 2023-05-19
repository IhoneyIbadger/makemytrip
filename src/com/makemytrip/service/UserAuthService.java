package com.myapp.service;

import com.myapp.model.User;
import com.myapp.util.AuthenticationUtil;

public class UserAuthService {
    private AuthenticationUtil authenticationUtil;

    public UserAuthService() {
        this.authenticationUtil = new AuthenticationUtil();
    }

    public User login(String username, String password) {
        return authenticationUtil.authenticateUser(username, password);
    }

    public boolean register(User user) {
        return authenticationUtil.registerUser(user);
    }

    public void logout(User user) {
        authenticationUtil.logoutUser(user);
    }
}
