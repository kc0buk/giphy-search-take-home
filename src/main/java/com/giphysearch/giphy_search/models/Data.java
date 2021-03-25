package com.giphysearch.giphy_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Used to force the return order of keys in the data array returned to the user.
 */
@JsonPropertyOrder({
        "gif_id",
        "url"
})
@Entity
public class Data {

    /**
     * The id associated with each search result as returned from the Giphy API.
     * The key is changed from id => gif_id in the object returned to the user.
     */
    @Id
    @JsonAlias("id")
    @JsonProperty("gif_id")
    private String gif_id;

    /**
     * The url of each search result as returned from the Giphy API.
     */
    @JsonProperty("url")
    private String url;

    /**
     * Default constructor used primarily by the JPA.
     */
    public Data() {}

    /**
     * Given the param, create a new search result inside the Data object.
     * @param gif_id The id of the search result as returned from the Giphy API.
     * @param url The url of the search result as returned from the Giphy API.
     */
    public Data(String gif_id, String url) {
        this.gif_id = gif_id;
        this.url = url;
    }

}
