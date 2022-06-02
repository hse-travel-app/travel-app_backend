package tinkoff.tourism.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.RouteService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<Sight> getRoute(@RequestBody @Valid RouteRequest request) {
        if (request.getBudget() == null) request.setBudget(Integer.MAX_VALUE);
        if (request.getStartTime() == null) request.setStartTime("00:00");
        if (request.getEndTime() == null) request.setEndTime("23:59");
        return service.getRoute(request);
    }
}
