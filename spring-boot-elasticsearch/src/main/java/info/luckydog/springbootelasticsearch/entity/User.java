package info.luckydog.springbootelasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "user", type = "test")
public class User {
    @Id
    private String id;
    private String name;
    private int age = 18;
    private Date createTime = new Date();
}
