package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @JsonProperty("suggestedFilters")
    private SuggestedFilters suggestedFilters;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("geocode")
    private Geocode geocode;
    @JsonProperty("headerFullLocation")
    private String headerFullLocation;
    @JsonProperty("warning")
    private Warning warning;
    @JsonProperty("headerLocationGranularity")
    private String headerLocationGranularity;
    @JsonProperty("groups")
    private List<GroupsItem> groups;
    @JsonProperty("suggestedBounds")
    private SuggestedBounds suggestedBounds;
    @JsonProperty("headerLocation")
    private String headerLocation;
}