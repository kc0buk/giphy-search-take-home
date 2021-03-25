package com.giphysearch.giphy_search.controllers;

import com.giphysearch.giphy_search.models.SearchTermResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class GiphyController {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Connect to the system environment to retrieve the "GIPHY_KEY".
     */
    private String giphyKey = System.getenv("GIPHY_KEY");

    /**
     * Set the max amount of search results to return from the Giphy API.
     */
    private short searchLimit = 5;

    /**
     * Create the concatenated search URL to connect to the Giphy search API.
     */
    private String searchUrl = "https://api.giphy.com/v1/gifs/search?api_key=" + giphyKey + "&limit=" + searchLimit;

    /**
     * Returns a JSON object of search results for the associated searchTerm from the Giphy API.
     * @param searchTerm The search parameter submitted by the user. Note: This param currently allows special
     *                   characters to accommodate the case of searches like "Kevin's dog".
     * @return JSON list of results associated with the specified searchTerm from the Giphy API.
     */
    @GetMapping(value = "/search/{searchTerm}", produces = { "application/json" })
    public ResponseEntity<?> getGiphy(@PathVariable String searchTerm) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        restTemplate.getMessageConverters()
                .add(converter);

        /**
         * Adds the specified searchTerm to the final query string for submission to the Giphy API.
         */
        String requestURL = searchUrl + "&q=" + searchTerm;

        ParameterizedTypeReference<SearchTermResult> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<SearchTermResult> responseEntity = restTemplate.exchange( requestURL, HttpMethod.GET, null,
                responseType);

        SearchTermResult returnData = responseEntity.getBody();

        /**
         * If the number of search results returned from the Giphy API is less than the max specified in searchLimit,
         * all results are removed from the return list and an empty is is returned to the user.
         */
        if (returnData.getData().size() < searchLimit) {
            returnData.getData().clear();
        }

        return new ResponseEntity<>(returnData, HttpStatus.OK);
    }
}
