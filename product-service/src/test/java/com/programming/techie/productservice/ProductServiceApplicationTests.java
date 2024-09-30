package com.programming.techie.productservice;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.0.4");
	
	@LocalServerPort
	private Integer port;
	
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	static {
		mongoDBContainer.start();
	}
	
	@Test
	void shouldCreateProduct() {
		String requestBody = "";
		requestBody+="{";
		requestBody+="\"name\":\"iPhone 15\",";
		requestBody+="\"description\":\"iPhone 15 is a smartphone from Apple\",";
		requestBody+="\"price\":1000";
		requestBody+="}";
		
		RestAssured.given()
					.contentType("application/json")
					.body(requestBody)
					.when()
					.post("/api/product")
					.then()
					.statusCode(201)
					.body("id", Matchers.notNullValue())
					.body("name", Matchers.equalTo("iPhone 15"))
					.body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
					.body("price", Matchers.equalTo("1000"));
	}

}
