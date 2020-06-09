package info.luckydog.springbootelasticsearch.dao;

import info.luckydog.springbootelasticsearch.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

}
