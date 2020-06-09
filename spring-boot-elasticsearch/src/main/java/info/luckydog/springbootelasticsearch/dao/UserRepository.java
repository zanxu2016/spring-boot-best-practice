package info.luckydog.springbootelasticsearch.dao;

import info.luckydog.springbootelasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByName(String name);
}
