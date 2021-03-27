# Getting Started with the Giphy Search API

This project is a simple Java / Spring API to retrieve search results from the Giphy API. It was built to fulfill the
 requirements of a take home assignment from a potential employer.
 
 >NOTE: Per the assignment requirements, a search returning more than five results from the Giphy API will only return
> five
> results to the user. A search returning less than five results from the Giphy API will not return any results to the user. 
 
 A deployed version of this API is available at `https://giphy-search-take-home.herokuapp.com/search/<SEARCH_TERM>`.
 
 ## Installation Instructions
 1. Clone the repository.
 2. Setup your `.env` file in the root directory of the project. The `.env.sample` file can be used by removing `.sample
 ` from the end, and inserting your
  own `GIPHY_API_KEY`. The server will not run unless the `GIPHY_KEY` environmental variable is present in the root
   directory of the project, and contains a valid API key. A valid API key is not included in this repository.
    >Visit the Giphy Developers [page](https://developers.giphy.com) to create an API key.
 3. Compile the `.jar` file. Note: Docker requires the `.jar` file to be located in `/target`. 
 4. To launch the project via Docker, run `docker-compose up` from the root directory of the project.
 5. The `/search` endpoint will be accessible at `http://localhost:8080/search/<SEARCH_TERM>`.

## Automated Testing Instructions
A Postman collection file (Giphy_Search_Endpoint_Tests) is included with the repository. This collection
 can be imported into Postman to test both valid and invalid search results from the API. More information about
  importing collections into Postman is available from the Postman [website](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/).
 
 The full suite of tests can be initiated by selecting the included JSON file in the Collection Runner, and clicking
  the `Start Run` button. More information about using the Collection Runner is available from the Postman [website
  ](https://learning.postman.com/docs/running-collections/working-with-data-files/).
  
  After running the tests, you will see a screen similar to this if all tests have passed. 
  ![Postman Testing Example](/images/Postman_Testing_Screen_Shot.png)

## Lessons Learned
1. How to retrieve data from an external API via a Java backend.

    This was my first time retrieving data from an external API via a Java backend. While most of the code and
 project structure was very similar to a regular API endpoint, I did not initially structure the models
  correctly to accommodate the structure of the JSON response object from the Giphy API. To illustrate, this is
   an example response from the Giphy API.
```
{
    "data": [
        {
            "type": "gif",
            "id": "xT0xeQ3j5IdcYGiiaY",
            "url": "https://giphy.com/gifs/bigeastconference-dog-basketball-xT0xeQ3j5IdcYGiiaY",
            "slug": "bigeastconference-dog-basketball-xT0xeQ3j5IdcYGiiaY",
            "bitly_gif_url": "http://gph.is/2j8rDe6",
            "bitly_url": "http://gph.is/2j8rDe6",
            "embed_url": "https://giphy.com/embed/xT0xeQ3j5IdcYGiiaY",
            "username": "bigeastconference",
            "source": "bigeast.com",
            "title": "Big East Dog GIF by BIG EAST Conference",
            "rating": "pg",
            "content_url": "",
            "source_tld": "",
            "source_post_url": "bigeast.com",
            "is_sticker": 0,
            "import_datetime": "2017-12-08 18:16:23",
            "trending_datetime": "2021-03-14 01:55:47",
            "images": {
                "original": {
                    "height": "270",
                    "width": "480",
                    "size": "3029313",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.gif",
                    "mp4_size": "715988",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.mp4",
                    "webp_size": "662322",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.webp",
                    "frames": "47",
                    "hash": "9fbc560ca870e006015082edac7a4f96"
                },
                "downsized": {
                    "height": "270",
                    "width": "480",
                    "size": "1683283",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-downsized.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-downsized.gif"
                },
                "downsized_large": {
                    "height": "270",
                    "width": "480",
                    "size": "3029313",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.gif"
                },
                "downsized_medium": {
                    "height": "270",
                    "width": "480",
                    "size": "3029313",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.gif"
                },
                "downsized_small": {
                    "height": "140",
                    "width": "248",
                    "mp4_size": "134299",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-downsized-small.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-downsized-small.mp4"
                },
                "downsized_still": {
                    "height": "270",
                    "width": "480",
                    "size": "41266",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-downsized_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-downsized_s.gif"
                },
                "fixed_height": {
                    "height": "200",
                    "width": "356",
                    "size": "1252420",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200.gif",
                    "mp4_size": "439715",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200.mp4",
                    "webp_size": "483912",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200.webp"
                },
                "fixed_height_downsampled": {
                    "height": "200",
                    "width": "356",
                    "size": "181584",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200_d.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200_d.gif",
                    "webp_size": "107478",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200_d.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200_d.webp"
                },
                "fixed_height_small": {
                    "height": "100",
                    "width": "178",
                    "size": "439369",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100.gif",
                    "mp4_size": "186936",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100.mp4",
                    "webp_size": "203330",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100.webp"
                },
                "fixed_height_small_still": {
                    "height": "100",
                    "width": "178",
                    "size": "11624",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100_s.gif"
                },
                "fixed_height_still": {
                    "height": "200",
                    "width": "356",
                    "size": "30612",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200_s.gif"
                },
                "fixed_width": {
                    "height": "113",
                    "width": "200",
                    "size": "590088",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w.gif",
                    "mp4_size": "198666",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w.mp4",
                    "webp_size": "233326",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w.webp"
                },
                "fixed_width_downsampled": {
                    "height": "113",
                    "width": "200",
                    "size": "76145",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w_d.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w_d.gif",
                    "webp_size": "41626",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w_d.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w_d.webp"
                },
                "fixed_width_small": {
                    "height": "57",
                    "width": "100",
                    "size": "163253",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100w.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100w.gif",
                    "mp4_size": "49416",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100w.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100w.mp4",
                    "webp_size": "91750",
                    "webp": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100w.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100w.webp"
                },
                "fixed_width_small_still": {
                    "height": "57",
                    "width": "100",
                    "size": "4501",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/100w_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=100w_s.gif"
                },
                "fixed_width_still": {
                    "height": "113",
                    "width": "200",
                    "size": "14784",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/200w_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=200w_s.gif"
                },
                "looping": {
                    "mp4_size": "2934612",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-loop.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-loop.mp4"
                },
                "original_still": {
                    "height": "270",
                    "width": "480",
                    "size": "69512",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy_s.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy_s.gif"
                },
                "original_mp4": {
                    "height": "270",
                    "width": "480",
                    "mp4_size": "715988",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy.mp4"
                },
                "preview": {
                    "height": "148",
                    "width": "263",
                    "mp4_size": "41110",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-preview.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-preview.mp4"
                },
                "preview_gif": {
                    "height": "75",
                    "width": "133",
                    "size": "47991",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-preview.gif?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-preview.gif"
                },
                "preview_webp": {
                    "height": "92",
                    "width": "164",
                    "size": "40950",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-preview.webp?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-preview.webp"
                },
                "hd": {
                    "height": "1080",
                    "width": "1920",
                    "mp4_size": "5660282",
                    "mp4": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/giphy-hd.mp4?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=giphy-hd.mp4"
                },
                "480w_still": {
                    "height": "270",
                    "width": "480",
                    "size": "3029313",
                    "url": "https://media2.giphy.com/media/xT0xeQ3j5IdcYGiiaY/480w_s.jpg?cid=799690d5so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&rid=480w_s.jpg"
                }
            },
            "user": {
                "avatar_url": "https://media4.giphy.com/channel_assets/big-east-conference/RORUp9fyd2u9.jpg",
                "banner_image": "https://media4.giphy.com/channel_assets/big-east-conference/khmL0lqMko66.png",
                "banner_url": "https://media4.giphy.com/channel_assets/big-east-conference/khmL0lqMko66.png",
                "profile_url": "https://giphy.com/bigeastconference/",
                "username": "bigeastconference",
                "display_name": "BIG EAST Conference",
                "description": "The Official Giphy Page Of The BIG EAST Conference",
                "instagram_url": "https://instagram.com/bigeastconf",
                "website_url": "http://www.bigeast.com/",
                "is_verified": true
            },
            "analytics_response_payload": "e=Z2lmX2lkPXhUMHhlUTNqNUlkY1lHaWlhWSZldmVudF90eXBlPUdJRl9TRUFSQ0gmY2lkPTc5OTY5MGQ1c283b3U1MDE2b2N3OTMzbnQ2MjA1ZzZwYmZ0NDd6MXU4M2dncXBnMg",
            "analytics": {
                "onload": {
                    "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&event_type=GIF_SEARCH&gif_id=xT0xeQ3j5IdcYGiiaY&action_type=SEEN"
                },
                "onclick": {
                    "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&event_type=GIF_SEARCH&gif_id=xT0xeQ3j5IdcYGiiaY&action_type=CLICK"
                },
                "onsent": {
                    "url": "https://giphy-analytics.giphy.com/simple_analytics?response_id=so7ou5016ocw933nt6205g6pbft47z1u83ggqpg2&event_type=GIF_SEARCH&gif_id=xT0xeQ3j5IdcYGiiaY&action_type=SENT"
                }
            }
        }
    ]
}
```  

   My initial model attempted to jump straight to `id` and `url` (the only two fields returned to the user), without
 first building the `Data` object to hold each search result returned from the Giphy API. Once the structure
of the models matched the structure of the data coming from Giphy (SearchTermResult -> Data), it was much easier tweak
 the shape of the object returned to the user.
```
{
    "data": [
        {
            "gif_id": "xT0xeQ3j5IdcYGiiaY",
            "url": "https://giphy.com/gifs/bigeastconference-dog-basketball-xT0xeQ3j5IdcYGiiaY"
        }
    ]
}
```
    
2. How to control the key names and property order in a JSON object returned to the user.

    The original data returned from the Giphy API included the key `id`, however, the data returned to the user needed to
 be `gif_id`. By adding `@JsonAlias("id")` I was able to map this field to the correct field in the Data model
 . Adding `@JsonPropertyOrder({"gif_id", "url"})` allowed me to control the shape of the object returned to the user.

3. How to use Postman for automated API testing.

    During a conversation with a friend, they recommended I check out Postman's automated testing features. After some
 investigation and a little trial-and-error I was able to build a full series of tests for both valid, and invalid
  search results, and setup the entire package to be fully automated. This was the first time I've used Postman for
   automated API testing. Going forward, I will definitely be adding this tool to my testing regime.

4. How to Dockerize a Java / Spring application, and pass environmental variables to the image during the build
 process.
 
    This was the first time I have Dockerized a Java / Spring application, and only my second time ever Dockerizing
     an application. After getting the Dockerfile setup and attempting to launch the application, it would not launch. Docker desktop only said `EXITED(0)`. I've learned from previous experience, that generally means the
      application can't find the correct environmental variables necessary to launch the application. After a bunch of
       Googling, I
       discovered the best way to pass environmental variables to the image is by including them in a docker-compose
        file, using the following syntax.  
       
       
       environment:
             GIPHY_KEY: "${GIPHY_KEY}"
       
   The additional benefit to creating the docker-compose file, it greatly simplifies the process to build and launch
    the Docker container.
 
 ## Next Steps
 
 As it stands today, this is a very bare bones API with limited functionality. The following are some ideas of
  potential improvements that could be added to this API.
  
  * Add data persistence on a per user basis
  * Enable the user to include the max search result param in their query string
  * Create an interface to allow users to select which fields they want included in the return object
  * Return a user-friendly error message if the search term includes special characters
  * Allow the user to specify which size and/or type of image(s) from the Giphy API they would like returned   