package com.stefan;

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
import javax.servlet.http.*;
import javax.ws.rs.core.*;

import java.util.Date;
import java.util.Collection;

import com.stefan.data.User;
import com.stefan.user.UserManager;

@Path("users")
public class UsersEndpoint {
	@Context private HttpServletRequest request;


	@POST
	@Path("register")
	@Produces("application/json")
	public User register(User user) {
		UserManager.getInstance().registerUser(user);
		return user;
	}

	@POST
	@Path("login")
	@Produces("application/json")
	public User login(User user) {
		UserManager.getInstance().login(user);
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		return user;
	}

	@GET
	@Path("registered")
	@Produces("application/json")
	public Collection<User> list() {
		return UserManager.getInstance().getUsers();
	}
	
	@GET
	@Path("loggedIn")
	@Produces("application/json")
	public Collection<User> listLogged() {
		return UserManager.getInstance().getOnlineUsers();
	}
	
	@GET
	@Path("current")
	@Produces("application/json")
	public User current() {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		return user;
	}

	@DELETE
	@Path("loggedIn")
	@Produces("application/json")
	public User logout() {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		if (user == null) return null;
		UserManager.getInstance().logout(user);
		session.setAttribute("user", null);
		return user;
	}
}