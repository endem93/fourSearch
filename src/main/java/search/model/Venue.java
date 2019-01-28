package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    @JsonProperty("hereNow")
    private HereNow hereNow;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("name")
    private String name;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("id")
    private String id;
    @JsonProperty("categories")
    private List<CategoriesItem> categories;
    @JsonProperty("photos")
    private Photos photos;
    @JsonProperty("beenHere")
    private BeenHere beenHere;
}