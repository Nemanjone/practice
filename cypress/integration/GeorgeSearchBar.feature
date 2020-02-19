Feature: George Search Bar 
    
   Background:
    Given Visit George CZ demo page
    And Navigate to Your Products
    And Go to  Portfolios JIŘÍ SPOKOJENÝ
  
    Scenario: Check the result of the search for Erste
    When Search for "Erste" in Search Bar
    Then Check the results of the search

    Scenario: Send single space string to Search Bar
    When Search for " " in Search Bar
    Then Check the search bar status for empty string

    Scenario: Send invalid charactes to Search Bar
    When Search for "!@#$##$%#$%" in Search Bar
    Then Check the search status for invalid characters

    Scenario: Send Lorem ipsum to Search Bar
    When Search for "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget" in Search Bar
    Then Check the search status for Lorem ipsum
