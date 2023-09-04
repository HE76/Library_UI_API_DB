package com.library.steps;

import com.library.pages.LoginPage;
import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;


public class Us01StepDef {

  String token;
  Response response;
  String expectedHeader;

    @Given("I logged Library api as a {string}")
    public void i_logged_library_api_as_a(String user) {
        token = LibraryAPI_Util.getToken(user);


    }
    @Given("Accept header is {string}")
    public void accept_header_is(String expected_header) {
      expectedHeader=expected_header;
    }
    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endpoint) {
      response=RestAssured.given().accept(expectedHeader).headers("x-library-token",token).when().get(ConfigurationReader.getProperty("library.baseUri")+endpoint);


    }
    @Then("status code should be {int}")
    public void status_code_should_be(int expectedStatusCode) {
      Assert.assertEquals(expectedStatusCode,response.statusCode());

    }
    @Then("Response Content type is {string}")
    public void response_content_type_is(String expectedContentType) {
      Assert.assertEquals(expectedContentType,response.contentType());    }
    @Then("{string} field should not be null")
    public void field_should_not_be_null(String string) {

    }

}
