package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description = "Verify if SignUp API is working")

	public void creatAccounTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("animesh1234").password("animesh1234")
				.email("animeshp456@gmail.com").firstName("Animesh").lastName("Pandey").mobileNumber("8840932732").build();

		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		
		System.out.println(response.asPrettyString());
	}
}
