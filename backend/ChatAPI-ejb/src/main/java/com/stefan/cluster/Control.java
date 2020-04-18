package com.stefan.cluster;

public class Control {

    private static ControlInterface node = null;

    public static ControlInterface getControl() {
        if (node != null) return node;
        if (Control.isMaster()) {
            node = new MasterNode();
        }
        else {
            node = new WorkerNode();
        }
        return node;
    }

    public static boolean isMaster() {
        return true;
    }

}