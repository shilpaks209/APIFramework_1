Feature: Verify API response for GetListOfUsers


  Scenario: Verify the response for getting list of users
    Given the API endpoint is "/api/users?page=2"
    When admin send a GET request
    Then the response code should be 200
    And the response should contain the user details like name,email id etc.
   
   Scenario: Verify the response for getting list of users by passing value from json file
   Given the API endpoint and request type in a json file
   When admin send the request 
   Then verify the reponse status code 
   And verify the reponse body
     
   Scenario: Verify the response for getting list of users using user directory
   Given A json file having request type and api path
   When admin hit the api
   Then verify the responde status code and body
  
