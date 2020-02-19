Feature: George Login 

    Scenario: Try to login with invalid credentials    
    When I try to login with "66666666"
    Then I am asked to enter my date of birth

    Scenario: Try to login with no credentials    
    When I try to login with ""
    Then I am asked to enter my client number and username