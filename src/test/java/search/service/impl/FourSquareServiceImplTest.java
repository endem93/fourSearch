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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FourSquareServiceImplTest {
    @Mock
    private CredentialsProvider credentialsProvider;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ResponseEntity<String> response;

    @InjectMocks
    private FourSquareServiceImpl fourSquareService;

    @Before
    public void setUp() {
        String fourSquareExploreEndpoint = "http://end-point.com";
        fourSquareService = new FourSquareServiceImpl(credentialsProvider, fourSquareExploreEndpoint);
        fourSquareService.setRestTemplate(restTemplate);
        when(response.toString()).thenReturn("Response");
        when(restTemplate.getForEntity(any(String.class), eq(String.class), any(HttpEntity.class))).thenReturn(response);
        when(credentialsProvider.getFourSquareID()).thenReturn("id");
        when(credentialsProvider.getFourSquareSecret()).thenReturn("secret");
        when(credentialsProvider.getVersion()).thenReturn("version");
    }

    @Test
    public void shouldGetPlaces(){

        final String result = fourSquareService.getRecommendedPlaces("london");

        assertNotNull(result);
        assertEquals("Response", result);
    }
}