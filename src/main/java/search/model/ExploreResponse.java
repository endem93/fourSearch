package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExploreResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("response")
    private Response response;
}