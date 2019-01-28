package search.validator;

import org.junit.Test;

import static search.validator.RequestValidator.validateLocation;
import static search.validator.RequestValidator.validateLimit;

public class RequestValidatorTest {

    @Test
    public void shouldValidateCorrectLocation(){
        validateLocation("london");
    }

    @Test
    public void shouldValidateCorrectLimit(){
        validateLimit("23");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullLocation(){
        validateLocation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyLocation(){
        validateLocation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullLimit(){
        validateLimit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyLimit(){
        validateLimit("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForIncorrectLimit(){
        validateLimit("io");
    }
}