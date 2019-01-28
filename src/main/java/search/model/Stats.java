package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    @JsonProperty("visitsCount")
    private Integer visitsCount;
    @JsonProperty("checkinsCount")
    private Integer checkinsCount;
    @JsonProperty("usersCount")
    private Integer usersCount;
    @JsonProperty("tipCount")
    private Integer tipCount;
}