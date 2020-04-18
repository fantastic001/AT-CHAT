package com.stefan.cluster;

public class WorkerNode implements ControlInterface {
    
    
    @Override
    public void init() {
        // figure out where is master 
        // register to master 
        // get list of all users from master and add them to UserManager 
    }

    @Override
    public void run() {

    }

    @Override
    public void finish() 
    {
        //  send notification to master of deinitializing node 
    }

    @Override
    public void nodeAdded(Node node) {
        
    }
    
    @Override
    public void nodeRemoved(Node node) {
        
    }
}