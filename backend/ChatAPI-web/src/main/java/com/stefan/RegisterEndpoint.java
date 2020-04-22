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

@Path("register")
public class RegisterEndpoint {
	//@Context private HttpServletRequest request;



	@POST
	@Path("")
	@Produces("application/json")
	public String register() {
		return "OK";
	}
}
