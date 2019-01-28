package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsItem {
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("reasons")
    private Reasons reasons;
    @JsonProperty("referralId")
    private String referralId;
}