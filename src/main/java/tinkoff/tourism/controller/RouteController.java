package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.enums.DurationEnum;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.RouteService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Sight> getRoute(@Valid RouteRequest request) {
        if (request.getBudget() == null) request.setBudget(Integer.MAX_VALUE);
        if (request.getStartTime() == null) request.setStartTime("00:00");
        if (request.getEndTime() == null) request.setEndTime("23:59");
        if (request.getDuration() == null) request.setDuration(DurationEnum.SHORT);
        return service.getRoute(request);
    }
}
