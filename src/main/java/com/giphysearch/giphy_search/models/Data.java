package com.giphysearch.giphy_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonPropertyOrder({
        "gif_id",
        "url"
})
@JsonIgnoreProperties("type")
@Entity
public class Data {

    @Id
    @JsonAlias("id")
    @JsonProperty("gif_id")
    private String gif_id;


    @JsonProperty("url")
    private String url;

    public Data() {}

    public Data(String gif_id, String url) {
        this.gif_id = gif_id;
        this.url = url;
    }

    public String getGif_id() {
        return gif_id;
    }

    public void setGif_id(String gif_id) {
        this.gif_id = gif_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
