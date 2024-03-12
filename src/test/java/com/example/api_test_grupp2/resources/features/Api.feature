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

