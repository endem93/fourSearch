package search.crendentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CredentialsProvider {

    private final String fourSquareID;
    private final String fourSquareSecret;
    private final String version;

    @Autowired
    public CredentialsProvider(@Value("${fourSquare.client.id}") final String fourSquareID,
                               @Value("${fourSquare.client.secret}")final String fourSquareSecret,
                               @Value("${fourSquare.client.version}")final String version) {
        this.fourSquareID = fourSquareID;
        this.fourSquareSecret = fourSquareSecret;
        this.version = version;
    }

    public String getFourSquareID() {
        return fourSquareID;
    }

    public String getFourSquareSecret() {
        return fourSquareSecret;
    }

    public String getVersion() {
        return version;
    }
}
