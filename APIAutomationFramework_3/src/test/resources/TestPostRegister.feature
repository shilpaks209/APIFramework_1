Feature: Verify API response for RegisterUser

  Scenario Outline: Register a user with different email and password combinations
    Given the  endpoint of the api is "/api/register"
    And the request body is:
      """
      {
        "email": "<email>",
        "password": "<password>"
      }
      """
    When Admin send a the api  request for register user
    Then verify the response status code should be 200

    Examples:
      | email                    | password   |
      | eve.holt@reqres.in       | pistol     |
      | john.doe@reqres.in       | secret     |
      | alice.smith@reqres.in    | 123456     |