package org.pup.system.osas.apiclient;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.pup.system.osas.core.domain.User;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UserApiClient {

	public User checkFullName(String firstName, String middleName, String lastName) throws Exception {
			User user = null;
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		URI uri = new URIBuilder("http://localhost:8080/api/users/checkFullName")
			    .addParameter("firstName", firstName)
			    .addParameter("middleName", middleName)
			    .addParameter("lastName", lastName)
			    .build();
		 
		HttpGet getRequest = new HttpGet(uri);
		
		HttpResponse response = httpClient.execute(getRequest);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonResponse = EntityUtils.toString(response.getEntity());
		if(jsonResponse != null && !jsonResponse.isBlank()) {
			user = mapper.readValue(jsonResponse, User.class);
		}
			
        return user;	
	}	
	
}
