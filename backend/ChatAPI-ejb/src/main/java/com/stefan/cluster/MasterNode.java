package com.stefan.cluster;

import java.util.ArrayList;
import java.util.Collection;

import com.stefan.user.UserManager;
import com.stefan.data.User;
import javax.ws.rs.core.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class MasterNode implements ControlInterface {
    
    private ArrayList<Node> nodes;


    @Override
    public void init() {
        System.out.println("Initializing master node");
        nodes = new ArrayList<>();
    }

    @Override
    public void run() {
        // pinging all nodes 
    }

    @Override
    public void finish() {
        
    }
    
    @Override
    public void nodeAdded(Node node) {
        System.out.println("Adding node: " + node.getAlias());
        for (Node current : nodes) {
            current.post("/node/", node);
            node.postAsync("/nodes/", current);
        }
        
        nodes.add(node);
       
    }

    @Override
    public Collection<User> getAllUsers() {
        return UserManager.getInstance().getUsers();
    }
    @Override
    public void nodeRemoved(String alias) {
        Node node = null; 
        for (Node n : nodes) {
            if (n.getAlias().equals(alias)) node = n;
        }
        if (node != null) {
            System.out.println("Removing node from registered nodes: " + node.getAlias());
            nodes.remove(node);
        }
        System.out.println("Notifying all other nodes of removed node");
        for (Node n : nodes) {
            System.out.println("Notify " + n.getAlias());
            n.deleteAsync("/node/" + node.getAlias());
        }
        System.out.println("All nodes notified");
    }
    @Override
    public void onPing() {
        Collection<Node> removal = new ArrayList<>();
        for (Node node : nodes) {
            System.out.println("Health check for " + node.getAlias());
            try {
                node.getAsync("/node/").get(1, TimeUnit.SECONDS);
            } 
            catch (InterruptedException e) {

            }
            catch (TimeoutException e) {
                removal.add(node);
            }
            catch (ExecutionException e) {
                removal.add(node);
            }
        }
        for (Node n : removal) {
            this.nodeRemoved(n.getAlias());
        }
    }

    @Override
    public void onPong(Node node) {
        
    }
}