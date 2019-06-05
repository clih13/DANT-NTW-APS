package com.dant.app;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;

/**
 * Created by pitton on 2017-02-20.
 */
@Path("/api")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class TestEndpoint {

	@POST
	@Path("/ParseCsv/{indexCol}")
	public Response parseCsv(@PathParam("indexCol")int indexCol) throws IOException {
		Table table = new Table();
		table.parseCSV(indexCol);
		return Response.status(201).build();
		
	}

	@GET
	@Path("/equalsSearch")
	@Produces("application/json")
	public String getEquals(@Context UriInfo info) throws IOException {
		SearchEquals search = new SearchEquals(info);
		return new Gson().toJson(search.results());
	}
}
