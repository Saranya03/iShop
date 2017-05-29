package services;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import models.Person;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserLoginServices {
	
	public Person getPerson(int partyId){
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("http://52.14.112.17:8098/api-services-prodv2/party/person/findByPartyId/" + partyId)
		  .get()
		  .addHeader("accept", "*/*")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "ec6bbd72-9500-aeff-673b-a12fda199bcf")
		  .build();

		try {
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonData);
			
			if(jsonObject.getString("forenames").length() != 0 && jsonObject.getString("lastname").length()!=0){
			String firstName = jsonObject.getString("forenames");
			String lastName = jsonObject.getString("lastname");
			return new Person(firstName,lastName,partyId);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Person("","",0); 
	} 
	
	public void insertUserLogin(int bockChainContract, String email,String fName, String lName, String loginId, int partyId){
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\n  \"alterDate\": \"2017-03-24T06:34:50.441Z\",\n  \"blockchainContract\": \"" + bockChainContract + "\",\n  \"email\": \"" + email +"\",\n  \"enabled\": \"y\",\n  \"firstName\": \"" + fName + "\",\n  \"lastName\": \"" + lName + "\",\n  \"loginId\": \"" + loginId + "\",\n  \"partyId\": " + partyId + ",\n  \"password\": \"xxxxxxxxx\",\n  \"role\": \"user\"\n}");
		Request request = new Request.Builder()
		  .url("http://52.14.112.17:8098/api-services-prodv2/userLogin")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("accept", "*/*")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "9b2cf9eb-0eea-e97e-1002-e54ad71222ae")
		  .build();

		try {
			Response response = client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
