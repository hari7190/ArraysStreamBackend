package stream.arrays.backend.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories( basePackages = "stream.arrays.backend")
@ComponentScan("stream.arrays.backend")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class)
    }
}
