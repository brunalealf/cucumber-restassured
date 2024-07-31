Feature: Breeds

	Scenario: Successful Listing 
		Given I am at the endpoint "https://catfact.ninja/breeds"
		When I execute the GET request 
		Then it returns the status code 200
		And the response should contain a list of breeds 
		And the response should be in JSON format

	Scenario: Invalid URL 
		Given I am at the endpoint "https://catfact.ninja/breeds"  
		And I append the word "teste" at the end of the URL "https://catfact.ninja/breedsteste"
		When I execute the GET request 
		Then it returns the status code 404
		And the response should contain an error message

	Scenario: Invalid Token 
		Given I am at the endpoint "https://catfact.ninja/breeds"
		And I provide an invalid token in the "Headers"
		When I execute the GET request 
		Then it returns the status code 401
