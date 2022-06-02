package tinkoff.tourism.controller.sights;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.sights.SightService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/sight")
public class SightController {

    private final SightService service;

    public SightController(SightService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Sight getSight(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<Sight> getSights() {
        return service.findAll();
    }

    @GetMapping(value = "name", produces = APPLICATION_JSON_VALUE)
    public List<Sight> getSightsByName(@RequestParam("name") String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "distance", produces = APPLICATION_JSON_VALUE)
    public List<Sight> getSightsByDistance(@RequestParam("x") Double x, @RequestParam("y") Double y, @RequestParam("distance") Double distance) {
        return service.findByDistance(x, y, distance);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateSight(@RequestBody @Valid Sight sight) {
        service.updateSight(sight);
    }

    @DeleteMapping()
    public void deleteSight(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @DeleteMapping(value = "all")
    public void deleteSights() {
        service.deleteAll();
    }
}
