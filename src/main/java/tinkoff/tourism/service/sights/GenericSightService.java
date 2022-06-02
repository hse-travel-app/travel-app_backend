package tinkoff.tourism.service.sights;

import java.util.List;

import tinkoff.tourism.model.sights.Sight;

public interface GenericSightService<T extends Sight>{

    void addSight(T sight);

    void delete(Long id);

    void deleteAll();

    void updateSight(T sight);

    T findById(Long id);

    List<T> findByName(String name);

    List<T> findByDistance(Double x, Double y, Double distance);

    List<T> findAll();
}
