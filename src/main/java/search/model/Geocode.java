package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geocode {
    @JsonProperty("cc")
    private String cc;
    @JsonProperty("what")
    private String what;
    @JsonProperty("displayString")
    private String displayString;
    @JsonProperty("center")
    private Center center;
    @JsonProperty("where")
    private String where;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("longId")
    private String longId;
    @JsonProperty("slug")
    private String slug;
}