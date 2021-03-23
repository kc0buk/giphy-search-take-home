package com.giphysearch.giphy_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GiphySearchApplication {

    private final Environment env;

    private static boolean stop = false;

    public GiphySearchApplication(Environment env) {
        this.env = env;
    }

    private static void checkEnvironmentalVariable(String envvar) {
        if (System.getenv(envvar) == null) {
            stop = true;
        }
    }

    public static void main(String[] args) {
        checkEnvironmentalVariable("GIPHY_KEY");

        if (!stop) {
            SpringApplication.run(GiphySearchApplication.class, args);

        }
    }

}
