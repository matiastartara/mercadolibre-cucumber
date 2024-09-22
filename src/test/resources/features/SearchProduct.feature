@All
Feature: Product Search and Availability Check

  @Search
  Scenario Outline:  As a Customer, I want to verify the availability of a product on the second
  page of search results so that I can add it to my cart for purchase.

    Given the user is on the home page
    When the user searches for "<product>"
    And navigates to page "<pageNumber>"
    And selects the "<itemNumber>" item
    Then the user should be able to add the item to the cart

    Examples:
      | product      | pageNumber | itemNumber |
      | Play Station | 2          | 2          |