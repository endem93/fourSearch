package search.validator;

import org.springframework.util.StringUtils;

public class RequestValidator {
    public static void validateLocation(final String location){
        if(StringUtils.isEmpty(location)){
            throw new IllegalArgumentException("The location passed in was invalid");
        }
    }

    public static void validateLimit(final String limit){
        try
        {
            Integer.parseInt(limit);
        }
        catch (NumberFormatException | NullPointerException e)
        {
            throw new IllegalArgumentException("The limit passed in was invalid");
        }
    }
}
