package com.qa.wave1;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestALM {
	@Test(enabled = false)
	public void RunAPICommand() {
				
		RequestSpecification request = RestAssured.given();
		//request.header("Content-Type", "application/json");
		//Response response = request.get("http://sjalmappprdn03:8080/qcbin/rest/is-authenticated?login-form-required=y");
		Response response = request.get("https://sjgpvapptstg01.na.gilead.com/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon");
		//Response response = request.get("http://api.plos.org/search?q=title:\"Drosophila\" AND body:\"RNA\"&fl=id,abstract");
		
		String result = response.getStatusLine();
		 //Assert.assertEquals(code, 200);
		 
		 System.out.println(result);
		
		
	}
	
	@Test(enabled = true)
	public void test2() {
		//int code = RestAssured.given().auth().preemptive().basic("bpalle", "MyPasswor").when().get("http://sjalmappprdn03:8080/qcbin/start_a.jsp").getStatusCode();

		int code = RestAssured.given().auth().preemptive().basic("pimadmin", "RDlG{\\#j$+65@UpGxjMl")
	    .when()
	    .get("https://sjgpvapptstg01.na.gilead.com/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon")
	    .getStatusCode();
		System.out.println("Result: "+ code) ;
		
		//https://10.22.4.108/PasswordVault/WebServices/auth/Cyberark/CyberArkAuthenticationService.svc/Logon
		
	}
	
	@Test(enabled = false)
	public void test3() {
		RestAssured.given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void test4() {
	JSONObject json = new JSONObject();

		json.put("field name", "status");
		json.put("value", "PASSED");	
		//System.out.println(json.toJSONString());

		RestAssured.given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(json.toJSONString()).
		when().
			get("http://sjalmappprdn03:8080/qcbin/rest/domains/GILEAD/projects/VMSTesting/test-instances/1106?login-form-required=y").
		then().
			statusCode(200).
			log().all();

	}
		
		//RestAssured.given().get("/qcbin/api/domains/GILEAD/projects/VMSTesting/test-instances/1147").then().statusCode(401).log().all();
	/*
	 * RestAssured.given().get("http://sjalmappprdn03:8080/qcbin/rest/is-authenticated?login-form-required=y");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.put("/qcbin/api/domains/GILEAD/projects/VMSTesting/test-instances/1147");
		String result = response.getStatusLine();
		System.out.println("Result:"+result);
	 */
		
		
	

}
