package com.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class BreedsSteps {
	
	private String url;
	private Boolean invalidToken = false;
	private Response response;

	@Given("I am at the endpoint {string}")
	public void Given_I_am_at_the_endpoint_STRING(String endpoint) {
		url = endpoint;
	}

	@Given("I append the word {string} at the end of the URL {string}")
	public void Given_i_append_the_word_at_the_end_of_the_url(String word, String finalUrl) {
	    String newUrl = this.url + word;
	    Assert.assertEquals(finalUrl, newUrl);
	    this.url = newUrl;
	}

	@When("I execute the GET request")
	public void When_I_execute_the_GET_request() {
		if (this.invalidToken) {
			response = RestAssured
					.given().header("authorization", "teste")
					.get(this.url);
			return;
		}
		
		response = RestAssured.get(this.url);
	}
	
	@Then("it returns the status code {int}")
	public void Then_it_returns_the_status_INT__STRING(Integer status) {
		Assert.assertEquals(status.intValue(), this.response.getStatusCode());
	}
	
	@Then("the response should contain a list of breeds")
	public void Then_the_response_should_contain_a_list_of_breeds() {
		JsonPath json = response.jsonPath();
		Assert.assertTrue(json.getList("data.breed").size() > 0);
	}
	
	@Then("the response should be in JSON format")
	public void Then_the_response_should_be_in_json_format() {
		JsonPath json = response.jsonPath();
		Assert.assertEquals(98, json.getInt("total"));
	}
	
	@Then("the response should contain an error message")
	public void Then_the_response_should_contain_an_error_message() {
		JsonPath json = response.jsonPath();
		Assert.assertEquals("Not Found", json.getString("message"));
	}
	
	@Then("I provide an invalid token in the \"Headers\"")
	public void Then_i_provide_an_invalid_token_in_the_headers() {
		this.invalidToken = true;
	}
}
