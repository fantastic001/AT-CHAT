package com.stefan.cluster;

import java.util.ArrayList;
import java.util.Collection;

import com.stefan.user.UserManager;
import com.stefan.data.User;

public class MasterNode implements ControlInterface {
    
    private ArrayList<Node> nodes;


    @Override
    public void init() {
        nodes = new ArrayList<>();
    }

    @Override
    public void run() {

    }

    @Override
    public void finish() {
        
    }
    
    @Override
    public void nodeAdded(Node node) {
        nodes.add(node);
        for (Node current : nodes) {
            // send notification about new node
        }
    }

    @Override
    public Collection<User> getAllUsers() {
        return UserManager.getInstance().getUsers();
    }
    @Override
    public void nodeRemoved(Node node) {
        for (Node n : nodes) {
            if (n.getAlias().equals(node.getAlias())) {
                nodes.remove(n);
            }
        }
    }
}