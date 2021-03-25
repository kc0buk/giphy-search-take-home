package com.giphysearch.giphy_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GiphySearchApplication {

    /**
     * Connect to the system environment where environment variables live.
     */
    private final Environment env;

    /**
     * If an environment variable is not found, set this to true
     */
    private static boolean stop = false;

    public GiphySearchApplication(Environment env) {
        this.env = env;
    }

    /**
     * The application relies on an environment variable, check to make sure that environment variable is available.
     * If the environment variable is not available, stop execution of the program
     *
     * @param envvar The system environment where environment variable live
     */
    private static void checkEnvironmentalVariable(String envvar) {
        if (System.getenv(envvar) == null) {
            stop = true;
        }
    }

    /**
     * Main method to start the application.
     *
     * @param args Not used in this application.
     */
    public static void main(String[] args) {
        checkEnvironmentalVariable("GIPHY_KEY");

        if (!stop) {
            SpringApplication.run(GiphySearchApplication.class, args);

        }
    }

}
