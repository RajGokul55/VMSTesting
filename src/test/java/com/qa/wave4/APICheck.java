package com.qa.wave4;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.comparesEqualTo;
import io.restassured.RestAssured;

public class APICheck {
	@Test
	public void TestAPI()
	{
		given()
		.when()
		.get("https://10.22.4.108/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon");
		.getStatusCode();
	
	
}
}
