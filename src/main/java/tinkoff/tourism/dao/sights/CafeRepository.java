package tinkoff.tourism.dao.sights;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Cafe;

@Mapper
public interface CafeRepository extends GenericRepository<Cafe> {
    List<Cafe> findByTypeOfFood(String foodType);
}
