package com.rest.web.services.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.rest.web.services.model.ChecksList;

public class CheckProcessingClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:7070/restws/services/checkprocessingservice/checks");
		AsyncInvoker async = target.request().async();
		Future<Boolean> response = async.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML), Boolean.class);
		try {
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {
			if(e.getCause() instanceof BadRequestException) {
				BadRequestException bre = (BadRequestException) e.getCause();
				System.err.println("Please send a valid list of checks.");
			}else {
				e.printStackTrace();
			}
		}
		
	}

}
