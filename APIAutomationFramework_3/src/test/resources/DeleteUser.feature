Feature: Delete users

  Scenario: Delete an existing user
    When admin send a DELETE request to "/api/users/2"
    Then the response status code should be 204