package com.example.api_test_grupp2;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiSteps {

    private Response response;

    @When("sending a Get request for getting products categories")//Yevheniia
    public void sending_a_get_request_for_getting_products_categories() {
       response = given().baseUri("https://produktapi-6ef53ba8f2f2.herokuapp.com/products/categories").
               when().get();
    }
    @Then("the response should return code {int}")//Yevheniia
    public void the_response_should_return_code(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();

        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("number of categories is {int}")//Yevheniia
    public void number_of_categories_is(Integer expectedNumberOfCategories) {
        List<String> actualCategoriesTitles = response.jsonPath().get();
        int actualNumberOfCategories = actualCategoriesTitles.size();

        assertEquals(expectedNumberOfCategories, actualNumberOfCategories);
    }

    @Then("the categories titles should match:") //Yevheniia
    public void the_categories_titles_should_match(List<String> expectedCategoriesTitles) {
        List<String> actualCategoriesTitles = response.jsonPath().get();

        assertEquals(expectedCategoriesTitles, actualCategoriesTitles);
    }

}
