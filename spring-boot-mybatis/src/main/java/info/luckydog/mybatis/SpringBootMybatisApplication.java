package info.luckydog.mybatis;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
        DocsConfig config = new DocsConfig();
        config.setProjectPath("E:\\workspace\\projects\\learn\\spring-boot-best-practice\\spring-boot-mybatis"); // 项目根目录
        config.setProjectName("spring-boot-mybatis"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("E:\\workspace\\projects\\learn\\spring-boot-best-practice\\spring-boot-mybatis"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        config.addPlugin(new MarkdownDocPlugin());
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
