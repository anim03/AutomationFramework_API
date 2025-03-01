package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITestBetter {

	@Test(description = "Verify if Login API is working")
	public void loginTest() {

		// Base URL
		RestAssured.baseURI = "http://64.227.160.186:8080";
		// given
		RequestSpecification request1 = RestAssured.given();
		//header
		RequestSpecification request2 = request1.header("Content-Type", "application/json");
		//Body
		RequestSpecification request3=request2.body("{\"username\": \"uday1234\", \"password\": \"uday12345\"}");
		//http verb and endpoint
		Response response =request3.post("/api/auth/login");
//		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
