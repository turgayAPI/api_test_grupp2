package com.example.api_test_grupp2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
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

    @When("sending a get request products for the {string} category")//Turgay
    public void sending_a_get_request_products_for_the_category(String category) {
        String baseURI = "https://produktapi-6ef53ba8f2f2.herokuapp.com";
        response = given()
                .pathParam("category", category)
                .when()
                .get(baseURI + "/products/categories/{category}");
    }

    @Then("the response should contain products related to {string}") //Turgay
    public void the_response_should_contain_products_related_to(String category) {
        assertThat(response, notNullValue());
        response.then().body("category", everyItem(equalTo(category)));
    }
    @Then("the response status should be {int} OK") //Turgay
    public void the_response_status_should_be_ok(Integer statusCode) {
        assertThat(response.statusCode(), equalTo(statusCode));
    }

    @Then("the response should contain the following products in category") //Turgay

    public void the_response_should_contain(List<String> expectedCategoriesTitles) {
        List<String> actualCategoriesTitles = response.jsonPath().get();

        assertEquals(expectedCategoriesTitles, actualCategoriesTitles);
    }

    @Then("the number of products in the response should be {int}") //Turgay
    public void the_number_of_products_in_the_response_should_be(Integer int1) {

        int actualSize = JsonPath.from(response.asString()).getList("$").size();
        Assert.assertEquals("Number of products does not match", int1.intValue(), actualSize);
    }

    @When("sending request to get products") // Jaime
    public void sending_a_request_to_get_products() {
        response = given().baseUri("https://produktapi-6ef53ba8f2f2.herokuapp.com/products").when().get();

    }
    @Then("the response status code should be {int}") // Jaime
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
         assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("number of products are {int}") // Jaime
    public void number_of_products_are(Integer expectedNumberOfProducts) {
        List<String> actualProductsTitles = response.jsonPath().get();
        int actualNumberOfProducts = actualProductsTitles.size();

        assertEquals(expectedNumberOfProducts, actualNumberOfProducts);
    }
    @When("the user requests the product with ID {string}") // Salim
    public void the_user_requests_the_product_with_id(String id) {
        String baseUri = "https://produktapi-6ef53ba8f2f2.herokuapp.com";
        response = given()
                .baseUri(baseUri)
                .when()
                .get("/products/{id}", id);
    }
    @Then("the response should contain the product details for ID {string}") // Salim
    public void the_response_should_contain_the_product_details_for_id(String id) {
        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        assertThat(responseBody, containsString("\"id\":" + id));
    }
    @Then("the response code should be {int}") // Salim
    public void the_response_code_should_be(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }
}
