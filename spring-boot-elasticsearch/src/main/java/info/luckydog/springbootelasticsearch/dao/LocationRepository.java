package info.luckydog.springbootelasticsearch.dao;

import info.luckydog.springbootelasticsearch.entity.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LocationRepository extends ElasticsearchRepository<Location, String> {

}
