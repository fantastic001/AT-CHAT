package com.stefan.cluster;

import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.annotation.PostConstruct;

@Singleton
@Startup
public class Control {


    private ControlInterface node = null;
    private ControlInterface getControl() {
        if (node != null) return node;
        if (isMaster()) {
            node = new MasterNode();
        }
        else {
            node = new WorkerNode();
        }
        return node;
    }

    @PostConstruct 
    private void run() {
        node = getControl();
    }

    private boolean isMaster() {
        ResourceReader reader = new ResourceReader();
        if (reader.getProperty("masterHostname", "").equals("")) {
            System.out.println("This node is master node");
            return true;
        }
        else return false;
    }

}