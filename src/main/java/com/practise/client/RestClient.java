package com.practise.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws ClientProtocolException, IOException {
		
		//Get Method
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpget);
		
		// Status Code
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code ----> " + statusCode);
		
		// JSon String
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("REsponse JSON --> " + responseJson);
		
		// Fetch Headers
		Header[] headerArray = closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers : \n "+ allHeaders);
		
		String jsonString = responseJson.toString();
		String tmp = jsonString.substring(jsonString.indexOf("en\":")+5, jsonString.indexOf("\"}"));
		System.out.println("\n\n ONLY TOKEN :\n " + tmp);
		
	}
	
	public void meth() {
		
	}
	
	
	

}
