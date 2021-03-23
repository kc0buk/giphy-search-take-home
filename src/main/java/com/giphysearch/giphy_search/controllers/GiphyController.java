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

    private String giphyKey = System.getenv("GIPHY_KEY");

    private short searchLimit = 5;

    private String searchUrl = "https://api.giphy.com/v1/gifs/search?api_key=" + giphyKey + "&limit=" + searchLimit;

    @GetMapping(value = "/search/{searchTerm}", produces = { "application/json" })
    public ResponseEntity<?> getGiphy(@PathVariable String searchTerm) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        restTemplate.getMessageConverters()
                .add(converter);

        String requestURL = searchUrl + "&q=" + searchTerm;

        ParameterizedTypeReference<SearchTermResult> responseType = new ParameterizedTypeReference<>() {
        };


        ResponseEntity<SearchTermResult> responseEntity = restTemplate.exchange( requestURL, HttpMethod.GET, null,
                responseType);

        SearchTermResult returnData = responseEntity.getBody();

        if (returnData.getData().size() < 5) {
            returnData.getData().clear();
        }
        return new ResponseEntity<>(returnData, HttpStatus.OK);
    }
}
