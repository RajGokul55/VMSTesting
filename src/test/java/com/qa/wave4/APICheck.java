package com.qa.wave4;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.comparesEqualTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APICheck {
	@Test(enabled = false)
	public void TestAPI()
	{
		Response response=RestAssured.given()
				
				.get("https://sjgpvapptstg01.na.gilead.com/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon");
		System.out.println("response.getStatusCode()");
		System.out.println(response.getBody().jsonPath().prettify());
		
}
	
	@Test(enabled = true)
	public void test2() {
		

		 Response resp= RestAssured.given().auth().preemptive().basic("pimadmin", "RDlG{\\#j$+65@UpGxjMl")
	    .when()
	    .get("https://sjgpvapptstg01.na.gilead.com/PasswordVault/WebServices/PIMServices.svc/Verify");
	    
	    System.out.println(resp.getBody().jsonPath().prettify());
		
		
		//https://10.22.4.108/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon
		
	}
}

