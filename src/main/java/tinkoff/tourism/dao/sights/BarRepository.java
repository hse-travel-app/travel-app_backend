package tinkoff.tourism.dao.sights;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Bar;

@Mapper
public interface BarRepository  extends GenericRepository<Bar> {
    List<Bar> findByCocktailsForAdults(Boolean forAdults);
}
