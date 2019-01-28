package search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import search.crendentials.CredentialsProvider;
import search.model.ExploreResponse;
import search.model.Recommendations;
import groovy.json.JsonBuilder;
import search.service.FourSquareService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FourSquareServiceImpl implements FourSquareService {
    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String V = "v";
    private static final String NEAR = "near";
    private static final String LIMIT = "limit";
    private final CredentialsProvider credentialsProvider;
    private final String fourSquareExploreEndpoint;
    private RestTemplate restTemplate;

    @Autowired
    FourSquareServiceImpl(final CredentialsProvider credentialsProvider,
                          @Value("${fourSquare.url}") final String fourSquareExploreEndpoint) {
        this.credentialsProvider = credentialsProvider;
        this.fourSquareExploreEndpoint = fourSquareExploreEndpoint;
        restTemplate = new RestTemplate();
    }

    @Override
    public String getRecommendedPlaces(String location, int limit) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fourSquareExploreEndpoint)
                .queryParam(CLIENT_ID, credentialsProvider.getFourSquareID())
                .queryParam(CLIENT_SECRET, credentialsProvider.getFourSquareSecret())
                .queryParam(V, credentialsProvider.getVersion())
                .queryParam(NEAR, location)
                .queryParam(LIMIT, limit);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<ExploreResponse> response = restTemplate.getForEntity(builder.toUriString(), ExploreResponse.class, entity);
        return handleResponse(response.getBody());
    }

    private String handleResponse(ExploreResponse response) {
        List<String> places = response.getResponse().getGroups().stream()
                                      .flatMap(groupsItem -> groupsItem.getItems().stream())
                                      .map(itemsItem -> itemsItem.getVenue().getName())
                                      .collect(Collectors.toList());

        Recommendations recommendations = new Recommendations();
        recommendations.setPlaces(places);
        return new JsonBuilder(recommendations).toPrettyString() + "\n";
    }

    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
