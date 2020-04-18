package com.stefan.user;

import com.stefan.data.User;

import java.util.ArrayList;

import javax.swing.ListCellRenderer;

public class UserManager {
    private ArrayList<User> users;
    private ArrayList<LoginListener> loginListeners;
    private static UserManager instance = null; 
    private UserManager() {
        this.users = new ArrayList<>();
        loginListeners = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (UserManager.instance == null) UserManager.instance = new UserManager();
        return UserManager.instance;
    }

    public void registerUser(User user) {
        for (User u : this.users) {
            if (u.getUsername().equals(user.getUsername())) return;
        }
        this.users.add(user);
    }

    public void login(User user) {
        for (User currentUser : this.users) {
            if (user.getUsername().equals(currentUser.getUsername()) && user.getPassword().equals(currentUser.getPassword())) {
                for (LoginListener listener : this.loginListeners) {
                    listener.userLoggedIn(user);
                }
            }
        }
    }

    public void addLoginListener(LoginListener listener) {
        this.loginListeners.add(listener);
    }
}