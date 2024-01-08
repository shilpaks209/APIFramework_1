Feature: Verify API response for GetSingleUser
#testcase1
 Scenario: Verify the response for getting single user 
   Given request type and api path in a json file
   When the admin sends a GET request
   Then verify the respondsbody and status code 