package com.giphysearch.giphy_search.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTermResult {

    /**
     * The Data array to hold the search results returned from the Giphy API.
     */
    private ArrayList<Data> data;

    /**
     * Default constructor used primarily by the JPA.
     */
    public SearchTermResult() {};

    /**
     * Given the param, create a new Data object.
     * @param data The Data array to hold the search results.
     */
    public SearchTermResult(ArrayList<Data> data) {
        this.data = data;
    }

    /**
     * Getter to retrieve the results stored in the Data object.
     * @return An array of the search results returned from the Giphy API.
     */
    public ArrayList<Data> getData() {
        return data;
    }

}
