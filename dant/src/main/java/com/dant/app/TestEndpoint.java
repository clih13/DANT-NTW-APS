package com.dant.app;

import com.dant.entity.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
//		return "Hello World christenpd";
//	}
	
	@POST
	@Path("/table/{name}")
	public Table createTable(@PathParam("name")String name) {
		Table table = new Table(name);
		Table.listTable.add(table);
		return table;
		
	}
	
	@POST
	@Path("/table/{name}/index/{indexCol}")
	public Index createIndex(@PathParam("name")String name, @PathParam("indexCol")int indexCol) {
		Index index = new Index();
		Table tab = Table.getTablebyName(name);
		
		tab.addIndex(index);
		long start = System.currentTimeMillis();
		index.SetData(indexCol);
		System.out.println(System.currentTimeMillis() - start);
		return index;
		
	}

	@POST
	@Path("/entity")
	public Account getAccount(Account account) {
		System.out.println("Received account " + account);
		account.setUpdated(System.currentTimeMillis());
		return account;
	}

	@GET
	@Path("/exception")
	public Response exception() {
		throw new RuntimeException("Mon erreur");
	}

}
