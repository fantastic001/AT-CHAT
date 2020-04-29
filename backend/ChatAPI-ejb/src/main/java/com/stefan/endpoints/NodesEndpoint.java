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
import javax.servlet.http.*;
import javax.ws.rs.core.*;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
@Path("nodes")
public class NodesEndpoint {
	//@Context private HttpServletRequest request;



	@POST
	@Path("")
	@Produces("application/json")
	public Result submitAllNodes() {
		Result r = new Result();
		r.setA(5);
		return r;
	}
}
