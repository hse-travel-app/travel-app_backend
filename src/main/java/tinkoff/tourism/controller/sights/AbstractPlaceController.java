package tinkoff.tourism.controller.sights;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.sights.GenericSightService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class AbstractPlaceController<T extends Sight, S extends GenericSightService<T>> implements GenericPlaceController<T> {
    protected final S service;

    public AbstractPlaceController(S service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addSight(@RequestBody @Valid T sight) {
        service.addSight(sight);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public T getSight(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "name", produces = APPLICATION_JSON_VALUE)
    public List<T> getSightsByName(@RequestParam("name") String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "distance", produces = APPLICATION_JSON_VALUE)
    public List<T> getSightsByDistance(@RequestParam("x") Double x, @RequestParam("y") Double y, @RequestParam("distance") Double distance) {
        return service.findByDistance(x, y, distance);
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<T> getAllSights() {
        return service.findAll();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateSight(@RequestBody @Valid T sight) {
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
