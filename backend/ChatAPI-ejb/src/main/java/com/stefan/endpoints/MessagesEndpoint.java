package com.stefan.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

import javax.annotation.Generated;
import javax.servlet.http.*;
import javax.ws.rs.core.*;

import java.util.Date;
import java.util.Collection;
import com.stefan.data.Message;
import com.stefan.data.User;
import com.stefan.message.MessageManager; 
import com.stefan.user.UserManager;

import javax.ejb.Stateless;

@Stateless
@Path("messages")
public class MessagesEndpoint {
	@Context private HttpServletRequest request;



	@POST
	@Path("all")
	@Produces("application/json")
	public Message all(Message message) {
		MessageManager.getInstance().broadcastMessage(message, UserManager.getInstance().getUsers());
		return message;
	}

	@POST
	@Path("user")
	@Produces("application/json")
	public Message user(Message message) {
		return MessageManager.getInstance().createMessage(
				message.getFromUsername(), 
				message.getToUsername(), 
				message.getSubject(), 
				message.getText()
			);
	}
	@GET 
	@Path("")
	@Produces("application/json")
	public Collection<Message> getInbox() {
		return MessageManager.getInstance().getMessages((User) request.getSession().getAttribute("user"));
	}
}
