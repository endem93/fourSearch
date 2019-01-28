package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photos {
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("groups")
    private List groups;
}