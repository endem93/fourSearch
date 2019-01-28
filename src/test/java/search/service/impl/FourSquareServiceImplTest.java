package search.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import search.crendentials.CredentialsProvider;
import search.model.*;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareServiceImplTest {
    private final static String JSON_RESPONSE = "{\n" +
            "    \"places\": [\n" +
            "        \"A Place\"\n" +
            "    ]\n" +
            "}\n";
    @Mock
    private CredentialsProvider credentialsProvider;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ResponseEntity<ExploreResponse> response;

    @InjectMocks
    private FourSquareServiceImpl fourSquareService;

    @Before
    public void setUp() {
        String fourSquareExploreEndpoint = "http://end-point.com";
        fourSquareService = new FourSquareServiceImpl(credentialsProvider, fourSquareExploreEndpoint);
        ExploreResponse exploreResponse = new ExploreResponse();
        Response response1 = new Response();
        GroupsItem group = new GroupsItem();
        ItemsItem item = new ItemsItem();
        Venue venue = new Venue();
        venue.setName("A Place");
        item.setVenue(venue);
        group.setItems(Collections.singletonList(item));
        response1.setGroups(Collections.singletonList(group));
        exploreResponse.setResponse(response1);
        fourSquareService.setRestTemplate(restTemplate);
        when(response.toString()).thenReturn("Response");
        when(response.getBody()).thenReturn(exploreResponse);
        when(restTemplate.getForEntity(any(String.class), eq(ExploreResponse.class), any(HttpEntity.class))).thenReturn(response);
        when(credentialsProvider.getFourSquareID()).thenReturn("id");
        when(credentialsProvider.getFourSquareSecret()).thenReturn("secret");
        when(credentialsProvider.getVersion()).thenReturn("version");
    }

    @Test
    public void shouldGetPlaces(){
        final String result = fourSquareService.getRecommendedPlaces("london", 10);

        assertNotNull(result);
        assertEquals(JSON_RESPONSE, result);
    }
}