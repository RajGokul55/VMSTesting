package com.qa.wave1;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestALM {
	@BeforeTest(enabled = false)
	public void test1() {
				
		RequestSpecification request = RestAssured.given();
		//request.header("Content-Type", "application/json");
		Response response = request.get("http://sjalmappprdn03:8080/qcbin/rest/is-authenticated?login-form-required=y");
		
		//String result = response.getStatusLine();
		 //Assert.assertEquals(code, 200);
		 
		 //System.out.println(result);
		
		
	}
	
	@BeforeTest(enabled = false)
	public void test2() {
		int code = RestAssured.given().auth().preemptive().basic("bpalle", "Wellness1#").when().get("http://sjalmappprdn03:8080/qcbin/start_a.jsp").getStatusCode();
		System.out.println("Result"+ code) ;
		
	}
	
	@Test(enabled = false)
	public void test3() {
		RestAssured.given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
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
