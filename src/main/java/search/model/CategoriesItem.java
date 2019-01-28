package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesItem {
    @JsonProperty("pluralName")
    private String pluralName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("icon")
    private Icon icon;
    @JsonProperty("id")
    private String id;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("primary")
    private Boolean primary;
}