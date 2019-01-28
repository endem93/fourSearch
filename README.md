# FourSquare Search App
A java spring app which reaches out to the FourSquare api to return a list of interesting places.

## Getting Started
The project is built using gradle so you will need to have gradle installed in your system.

For Linux/Mac operating systems, this can be done running `brew install gradle`.

### Starting The Application
1. Clone the project by running `git clone https://github.com/endem93/fourSearch.git`.
1. Navigate into the `fourSearch/` directory
1. Start the application by running `gradle start`

### Getting Responses
* To get a list of recommended places, make a get request to the application like below:
> curl -X GET -G   'localhost:8080/recommend'     -d location="Nigeria"     -d limit=10
* This will return a JSON response with a list of places of interest near the location contained in the request:
> {
>     "places": [
>         "Wheatbaker Hotel",
>         "Filmhouse Imax",
>         "Jabi Lake Mall",
>         "Sakura Japanese Restaurant",
>         "Yello Chilli",
>         "Spice Route",
>         "xovar lounge",
>         "Angle Villa",
>         "Domino Pizza",
>         "Dunes"
>     ]
> }
* You can modify the area of interest and the number of responses by modifying the `location` and `limit` variables respectfully
* The health of the service can be gleaned by running the following request: `curl localhost:8080/actuator/health`


### Summary Of Approach
The application is built with Spring.

The Controller layer is used to receive requests and respond to them.
The SearchController will receive a request from outside the application and pass it on to the Service Layer to deal with.

The Service layer includes the FourSquareService which is the part of the application which interacts with the FourSquare api.
In order to connect with the external api, some credentials are needed. I opted to keep these credentials in the application properties.
The credentials will be provided to the FourSquareService via a CredentialsProvider. I took this approach to keep the responsibilities of the FourSquareService singular.

To handle the response from the api, I decided to transform the JSON to a POJO. This was done by using a JacksonXml plugin.
Having the response as a Java object made it easier to loop through and extract the necessary information.

To present the result, I chose to use a new POJO and transform that to JSON. This made it easy to influence the display of the JSON response of the application.