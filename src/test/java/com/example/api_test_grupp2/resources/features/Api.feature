Feature: API
  Test the Api from Webshop

  Scenario: Requesting the Webshop Api should return all categories # Yevheniia
    When sending a Get request for getting products categories
    Then the response should return code 200

  Scenario: Requested categories amount should be equal 4 # Yevheniia
    When sending a Get request for getting products categories
    Then number of categories is 4

  Scenario: Requested categories should have correct names # Yevheniia
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


  Scenario: Requesting the API should return correct status code # Jaime
    When sending request to get products
    Then the response status code should be 200

  Scenario: Requested products amount should be equal to 20 # Jaime
    When sending request to get products
    Then number of products are 20

  Scenario: User requests a product by a valid ID //Salim
    When the user requests the product with ID '1'
    Then the response status should be 200 OK
    And the response should contain the product details for ID '1'

  Scenario: User requests a product by a non-existing ID //Salim
    When the user requests the product with ID '9999'
    Then the response code should be 403