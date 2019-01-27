package search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import search.service.FourSquareService;

@RestController
public class SearchController {

    private final FourSquareService fourSquareService;

    @Autowired
    SearchController(final FourSquareService fourSquareService) {
        this.fourSquareService = fourSquareService;
    }

    @RequestMapping("/recommend")
    public String recommendPlaces() {
        return fourSquareService.getRecommendedPlaces("london");
    }

}