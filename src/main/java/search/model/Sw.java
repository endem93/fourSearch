package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sw {
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("lat")
    private Double lat;
}