package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bounds {
    @JsonProperty("sw")
    private Sw sw;
    @JsonProperty("ne")
    private Ne ne;
}