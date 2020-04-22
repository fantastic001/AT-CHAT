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

@Path("node")
public class NodeEndpoint {
	//@Context private HttpServletRequest request;


	@POST
	@Path("")
	@Produces("application/json")
	public Result newNode() {
		Result r = new Result();
		r.setA(5);
		return r;
	}
	@GET
	@Path("")
	@Produces("application/json")
	public String pingNode() {
		return "PONG";
	}

	@DELETE
	@Path("{alias}")
	@Produces("application/json")
	public String deleteNode(@PathParam("alias") String alias) {
		return "OK";
	}
}
