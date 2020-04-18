package com.stefan.cluster;

import java.util.Date;

public class Node {
	
	
	private String alias; 
	
	private String hostname; 
	
	private int port; 
	
	private String path; 
	
	public Node() 
	{
	}
	public Node(String _alias, String _hostname, int _port, String _path) {
		super();
		 
		this.alias = _alias;
		 
		this.hostname = _hostname;
		 
		this.port = _port;
		 
		this.path = _path;
		
	}
	
	 
	public String getAlias() 
	{
		return this.alias;
	}

	public void setAlias(String newValue) 
	{
		this.alias = newValue;
	}
	 
	public String getHostname() 
	{
		return this.hostname;
	}

	public void setHostname(String newValue) 
	{
		this.hostname = newValue;
	}
	 
	public int getPort() 
	{
		return this.port;
	}

	public void setPort(int newValue) 
	{
		this.port = newValue;
	}
	 
	public String getPath() 
	{
		return this.path;
	}

	public void setPath(String newValue) 
	{
		this.path = newValue;
	}
	
}