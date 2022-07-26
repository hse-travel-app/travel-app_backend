package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Sight;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface GenericPlaceController <T extends Sight> {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    void addSight(@RequestBody @Valid T sight);

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    List<T> getAllSights();

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    T getSight(@RequestParam("id") Long id);

    @GetMapping(value = "name", produces = APPLICATION_JSON_VALUE)
    List<T> getSightsByName(@RequestParam("name") String name);

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    void updateSight(@RequestBody @Valid T sight);

    @DeleteMapping()
    void deleteSight(@RequestParam("id") Long id);

    @DeleteMapping(value = "all")
    void deleteSights();
}
