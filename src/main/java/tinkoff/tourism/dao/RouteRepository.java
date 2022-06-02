package tinkoff.tourism.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.controller.dto.RouteRequest;
import tinkoff.tourism.model.sights.Sight;

@Mapper
public interface RouteRepository {
    List<Sight> getRoute(RouteRequest request);
}
