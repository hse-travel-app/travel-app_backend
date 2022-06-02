package tinkoff.tourism.dao.sights;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.sights.Museum;

@Mapper
public interface MuseumRepository extends GenericRepository<Museum>  {
    List<Museum> findByDiscountForChildren(Boolean discountForChildren);
}
