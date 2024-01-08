Feature:  Testing POST API - creating single user
 Scenario:  Create a user with valid data
    Given: the API endpoint is "/api/users"
    When: Admin user provides valid user details
    Then: User should get created
    
Scenario: create a single user using data from json file
   Given: the api end point,request body, request type is passed from json file
   When: Admin user submit valid details 
   Then: the user should be created    
      