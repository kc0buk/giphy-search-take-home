# Getting Started with the Giphy Search API

This project is a simple Java / Spring API to retrieve search results from the Giphy API and return a maximum of five
 results to the user. It was built to fulfill the requirements of a take home assignment for a potential employer.
 
 >NOTE: A search returning more than 5 results from the Giphy API will only return five results to the user. A search
> returning less than five results from the GIPHY API will not return any results to the user. 
 
 ## Installation Instructions
 1. Clone the repository
 2. Setup your `.env` file. The `.env.sample` file can be used by removing `.sample` from the end, and inserting your
  own `GIPHY_API_KEY`. The server will not run unless the `GIPHY_KEY` environmental variable is present, and contains a
   valid API key. A valid API key is not included in this repository.
    >Visit the Giphy Developers [page](https://developers.giphy.com) to create an API key.
3. Build the project.  
4. The API is available at http://localhost:8080/search/

## Automated Testing Instructions
A Postman collection file (Giphy Search Endpoint Tests.postman.json) is included with the repository. This collection
 can be imported into Postman to test both valid and invalid search results from the API. More information about
  importing collections into Postman is available from the Postman [website](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/).
 
 The full suite of tests can be initiated by selecting the included JSON file in the Collection Runner. More information
  is available from the Postman [website](https://learning.postman.com/docs/running-collections/working-with-data-files/).
  
  After running the tests, you will see a screen similar to this if all tests have passed. 
  ![Postman Testing Example](/images/Postman_Testing_Screen_Shot.png)

## Lessons Learned