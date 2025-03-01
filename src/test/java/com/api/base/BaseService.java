package com.api.base;

import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {// wrapper for rest assured--> Abstraction
	// BASE URI
	// Creating The Request
	// handling the response

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	// Service Object Model-->Design Pattern

	public BaseService() {
		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

	}

	protected Response getRequest(String endpoint) {

		return requestSpecification.get(endpoint);

	}

	protected Response putRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);

	}

	protected RequestSpecification setAuthToken(String token) {
		return requestSpecification.header("Authorization", "Bearer " + token);
	}
}
