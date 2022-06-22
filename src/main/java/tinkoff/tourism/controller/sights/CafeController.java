package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.service.sights.CafeService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cafe")
public class CafeController extends AbstractPlaceController<Cafe, CafeService> {
    public CafeController(CafeService service) {
        super(service);
    }

    @GetMapping(value = "food-type", produces = APPLICATION_JSON_VALUE)
    public List<Cafe> getCafesByTypeOfFood(@RequestParam("foodType") String foodType) {
        return service.findByTypeOfFood(foodType);
    }
}
