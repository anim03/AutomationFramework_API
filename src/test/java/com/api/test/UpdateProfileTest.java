package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.ProfileRequest;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description = "Verify if Update Profile API is working")
	public void UpdateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234","uday12345"));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(),"uday1234");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Animesh")
				.lastName("Pandey")
				.email("animesh@gmail.com")
				.mobileNumber("77777777776").build();
		
		response=userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
		System.out.println(response.asPrettyString());
				
		
		
	}

}
