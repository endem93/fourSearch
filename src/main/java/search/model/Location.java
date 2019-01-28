package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @JsonProperty("cc")
    private String cc;
    @JsonProperty("country")
    private String country;
    @JsonProperty("address")
    private String address;
    @JsonProperty("labeledLatLngs")
    private List<LabeledLatLngsItem> labeledLatLngs;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("formattedAddress")
    private List<String> formattedAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("crossStreet")
    private String crossStreet;
    @JsonProperty("lat")
    private Double lat;
}