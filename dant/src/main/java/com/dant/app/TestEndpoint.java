package com.dant.app;

import com.dant.entity.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pitton on 2017-02-20.
 */
@Path("/api")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class TestEndpoint {
	
//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	public String helloWorld() {
//		return "Hello World";
//	}
	
	// @POST
	// @Path("/table/{name}")
	// public Table createTable(@PathParam("name")String name) {
	// 	Table table = new Table(name);
	// 	Table.listTable.add(table);
	// 	return table;
		
	// }
	
	// @POST
	// @Path("/table/{name}/index/{indexCol}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Index createIndex(@PathParam("name")String name, @PathParam("indexCol")int indexCol) throws IOException {
	// 	Index index = new Index(indexCol);
	// 	Table tab = Table.getTablebyName(name);		
	// 	tab.addIndex(index);
	// 	index.parseCSV(indexCol);
	// 	return index;	
	// }
	
	// // createIndex method for testing purposes
	// @POST
	// @Path("/test/table/{name}/index/{indexCol}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public void createIndexTest(@PathParam("name")String name, @PathParam("indexCol")int indexCol) throws IOException {
	// 	Index index = new Index(indexCol);
	// 	Table tab = Table.getTablebyName(name);		
	// 	tab.addIndex(index);
	// 	index.parseCSV(indexCol);
	// 	return;	
	// }

	
	// //retourne lignes en fonction de l'index
	// @GET
	// @Path("/table/{name}/{indexCol}/{index}")
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response getLines(@PathParam("name")String name, @PathParam("indexCol")int indexCol, @PathParam("index")String param_index) {
	// 	Table tab = Table.getTablebyName(name);
		
	// 	Index i = tab.getIndex(indexCol);		
	// 	return Response.status(201).entity(i.getLignes(param_index)).build();
	// }
	
	// @POST
	// @Path("/entity")
	// public Account getAccount(Account account) {
	// 	System.out.println("Received account " + account);
	// 	account.setUpdated(System.currentTimeMillis());
	// 	return account;
	// }

	// @GET
	// @Path("/exception")
	// public Response exception() {
	// 	throw new RuntimeException("Mon erreur");
	// }


	@POST
	@Path("/ParseCsv/{indexCol}")
	public Response parseCsv(@PathParam("indexCol")int indexCol) throws IOException {
		Index index = new Index();
		index.parseCSV(indexCol);
		return Response.status(201).build();
		
	}

}
