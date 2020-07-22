# It follows the basics of the Microservies where as applicable.

This project is based on the java Spring Framework And RESTFUL Services.

it is implemented Through three tire technology to keep  aside for the data and implementations.
This API us designed to get the information of movies that are currently running on cinemas hall.

# Articture used
  * used RestTemplate to call the external Resources for those datas https://data.sfgov.org/resource/yitu-d5am.json and getLatLong(http://open.mapquestapi.com/geocoding/v1/) Service from the implemented on ResourcesService.java
  * implemented the GoogleImageSearch in GoogleSearchUtils.java to get the poster of the Movie i could use the GoogleImageAPI but it only allows us 100 calls per day.
  * Movie data are loaded from classpath becauses getLatLong Services will hit to the server serveral times it decrese the performance speed however service is created for getting the lattitude and longitude of the location by address
  
  # Future Enhancement
  * will implement the getLatLong service and bind with our data as per pagination and Asynchronously with respect to time
  * Will performs the test (unit test)
  * ImageSearch is not performing well will look better solutions
  
  # Problem faced
  * through imageService can not pick the correct movie poster
  * multiple calls through imageService gives the TimeOut problems


# EndPoints
* ("/") method => GET -> gives the all movies list
* ("/unique-movies") method => GET => gives the distinct movies through the title
* ("/get-promo-Movies") method => GET => gives the Featured movies size = 4
* ("/movie/{movieName}") method => GET => gives the list of movies by movie title
* ("/getAllMoviesWithLocation") method => GET => gives the list of movies that location is known
* ("/find-by-location/{location}") method => GET => gives the list of movies in that location
* ("/locations-list") method => GET => gives the distinct location list 
* ("/get-movies-details") method => GET => gives the movie with the movie poster using Google Search Image 

