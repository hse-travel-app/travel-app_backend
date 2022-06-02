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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface GenericPlaceController<T extends Sight> {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    void addSight(@RequestBody @Valid T sight);

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    List<T> getAllSights();

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    T getSight(@RequestParam("id") Long id);

    @GetMapping(value = "name", produces = APPLICATION_JSON_VALUE)
    List<T> getSightsByName(@RequestParam("name") String name);

    @GetMapping(value = "distance", produces = APPLICATION_JSON_VALUE)
    List<T> getSightsByDistance(@RequestParam("x") Double x, @RequestParam("y") Double y, @RequestParam("distance") Double distance);

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    void updateSight(@RequestBody @Valid T sight);

    @DeleteMapping()
    void deleteSight(@RequestParam("id") Long id);

    @DeleteMapping(value = "all")
    void deleteSights();
}
