package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import search.service.FourSquareService;

import static search.validator.RequestValidator.validateLimit;
import static search.validator.RequestValidator.validateLocation;

@RestController
public class SearchController {

    private final FourSquareService fourSquareService;

    @Autowired
    SearchController(final FourSquareService fourSquareService) {
        this.fourSquareService = fourSquareService;
    }

    @RequestMapping("/recommend")
    public String recommendPlaces(@RequestParam("location") String location, @RequestParam("limit") String limit) {
        validateLocation(location);
        validateLimit(limit);
        return fourSquareService.getRecommendedPlaces(location, Integer.parseInt(limit));
    }

}