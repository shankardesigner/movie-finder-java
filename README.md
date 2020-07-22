This project is based on the java Spring Framework And RESTFUL Services.

it is implemented Through three tire technology to keep  aside for the data and implementations.

# it follows the basics of the Microservies where as applicable.
  * used RestTemplate to call the external Resources for those datas https://data.sfgov.org/resource/yitu-d5am.json and getLatLong(http://open.mapquestapi.com/geocoding/v1/) Service from the implemented on ResourcesService.java
  * implemented the GoogleImageSearch in GoogleSearchUtils.java to get the poster of the Movie i could use the GoogleImageAPI but it only allows us 100 calls per day.
  * Movie data are loaded from classpath becauses getLatLong Services will hit to the server serveral times it decrese the performance speed
  
  #FUTURE ENHANCEMENT
  * will implement the getLatLong service and bind with our data as per pagination and Asynchronously with respect to time
  * Will performs the test (unit test)
