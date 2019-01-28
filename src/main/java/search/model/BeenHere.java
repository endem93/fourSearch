package search.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeenHere {
    @JsonProperty("marked")
    private Boolean marked;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("lastCheckinExpiredAt")
    private Integer lastCheckinExpiredAt;
    @JsonProperty("unconfirmedCount")
    private Integer unconfirmedCount;
}