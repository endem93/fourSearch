package search.service;

public interface FourSquareService {
    /**
     * Method returns a list of recommended venues near the area of interest passed in.
     * @param location the area of interest
     * @return A list of recommended places
     */
    String getRecommendedPlaces(final String location);
}
