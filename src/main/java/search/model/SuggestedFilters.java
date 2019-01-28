package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuggestedFilters {
    @JsonProperty("header")
    private String header;
    @JsonProperty("filters")
    private List<FiltersItem> filters;
}