package tinkoff.tourism.service;

import org.springframework.stereotype.Service;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.dao.RouteRepository;
import tinkoff.tourism.model.enums.SightTypeEnum;
import tinkoff.tourism.model.sights.Sight;

import java.util.*;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public List<Sight> getRoute(RouteRequest request) {
        List<Sight> toCompress = repository.getRoute(request);

        Map<SightTypeEnum, LinkedList<Sight>> classifiedSights = new HashMap<>();
        toCompress.forEach((i) -> {
            if (classifiedSights.containsKey(i.getType())) {
                classifiedSights.get(i.getType()).add(i);
            } else {
                classifiedSights.put(i.getType(), new LinkedList<>());
                classifiedSights.get(i.getType()).add(i);
            }
        });
        classifiedSights.forEach((sightTypeEnum, sights) -> Collections.shuffle(sights));

        Random random = new Random(System.currentTimeMillis());
        List<Sight> compressed = new LinkedList<>();

        int numberOfPlaces = request.getDuration().getPossibleNumberOfPlaces()[random.nextInt(request.getDuration().getPossibleNumberOfPlaces().length)];

        // need to rewrite it naxren but idk how
        {
            Iterator<Map.Entry<SightTypeEnum, LinkedList<Sight>>> it = classifiedSights.entrySet().iterator();
            while (compressed.size() != numberOfPlaces &&
                    !classifiedSights.entrySet().stream()
                            .allMatch(entry -> entry.getValue().isEmpty())) {
                Map.Entry<SightTypeEnum, LinkedList<Sight>> pair = it.next();
                if (pair.getValue().isEmpty()) {
                    continue;
                }
                int index = random.nextInt(pair.getValue().size());
                compressed.add(pair.getValue().get(index));
                pair.getValue().remove(index);
                if (!it.hasNext()) {
                    it = classifiedSights.entrySet().iterator();
                }
            }
        }

        return compressed;
    }
}
