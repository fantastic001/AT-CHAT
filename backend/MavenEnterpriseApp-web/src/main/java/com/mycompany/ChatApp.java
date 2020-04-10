package com.mycompany;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ChatApp extends Application {

	public ChatApp() {
	}
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(Hello.class);
        return classes;
    }

}