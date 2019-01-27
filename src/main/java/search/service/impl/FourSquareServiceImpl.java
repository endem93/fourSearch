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
import search.service.FourSquareService;


@Service
public class FourSquareServiceImpl implements FourSquareService {
    private final CredentialsProvider credentialsProvider;
    private final String fourSquareExploreEndpoint;

    @Autowired
    FourSquareServiceImpl(final CredentialsProvider credentialsProvider,
                          @Value("${fourSquare.url}") final String fourSquareExploreEndpoint) {
        this.credentialsProvider = credentialsProvider;
        this.fourSquareExploreEndpoint = fourSquareExploreEndpoint;
    }

    public CredentialsProvider getCredentialsProvider() {
        return credentialsProvider;
    }

    @Override
    public String getRecommendedPlaces(String location) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fourSquareExploreEndpoint)
                .queryParam("client_id", credentialsProvider.getFourSquareID())
                .queryParam("client_secret", credentialsProvider.getFourSquareSecret())
                .queryParam("v", credentialsProvider.getVersion())
                .queryParam("near", location)
                .queryParam("limit", "1");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class, entity);
        return response.toString();
    }
}
