package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;--
//static import--> improves readability
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verify if Login API is working")
	public void loginTest() {

		// Base URL
//		baseURI = "http://64.227.160.186:8080";
		// Chaining
		Response response = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json")
				.body("{\"username\": \"uday1234\", \"password\": \"uday12345\"}").post("/api/auth/login");
//		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
