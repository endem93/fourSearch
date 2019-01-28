package search.service;

public interface FourSquareService {
    /**
     * Method returns a list of recommended venues near the area of interest passed in.
     * @param location the area of interest
     * @param limit the limit of number of places to be returned
     * @return A list of recommended places
     */
    String getRecommendedPlaces(final String location, final int limit);
}
