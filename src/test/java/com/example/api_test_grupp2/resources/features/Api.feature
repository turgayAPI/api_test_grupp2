Feature: API
  Test the Api from Webshop

  Scenario: Requesting the Webshop Api should return all categories
    When sending a Get request for getting products categories
    Then the response should return code 200

  Scenario: Requested categories amount should be equal 4
    When sending a Get request for getting products categories
    Then number of categories is 4

  Scenario: Requested categories should have correct names
    When sending a Get request for getting products categories
    Then the categories titles should match:
      |electronics|
      |jewelery|
      |men's clothing|
      |women's clothing|


  Scenario: Turgay- Retrieve products by category
    When  sending a get request products for the "men's clothing" category
    Then the response should contain products related to "men's clothing"
    And the response status should be 200 OK


  Scenario: Turgay-User requests products from the Electronics category
    When sending a get request products for the "electronics" category
    Then the response status should be 200 OK
    And the number of products in the response should be 6


  Scenario: Turgay-User requests products from the Womens clothing category
    When sending a get request products for the "women's clothing" category
    Then the response status should be 200 OK
    And the number of products in the response should be 6

  Scenario:Turgay- User requests products from the Jewelery category
    When sending a get request products for the "jewelery" category
    Then the response status should be 200 OK
    And the number of products in the response should be 4