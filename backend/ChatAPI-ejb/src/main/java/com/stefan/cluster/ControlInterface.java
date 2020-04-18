package com.stefan.cluster;

import com.stefan.data.User;

import java.util.Collection;

public interface ControlInterface {


    public void init();
    public void run();
    public void finish();
    public void nodeAdded(Node node);
    public void nodeRemoved(Node node);
    public Collection<User> getAllUsers();
    public void onPing();
    public void onPong(Node node);
}