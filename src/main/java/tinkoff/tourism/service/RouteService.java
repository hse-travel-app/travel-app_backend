package tinkoff.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.dao.RouteRepository;
import tinkoff.tourism.model.sights.Sight;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Sight> getRoute(RouteRequest request) {
        return repository.getRoute(request);
    }
}
