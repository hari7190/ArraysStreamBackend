package stream.arrays.backend.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import stream.arrays.backend.domain.User;
import stream.arrays.backend.services.repositories.UserRepository;

import java.util.Arrays;

@SpringBootApplication
@EnableMongoRepositories( basePackages = "stream.arrays.backend")
@ComponentScan("stream.arrays.backend")
public class Application {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    /*
    *
    * TODO: NEED TO FIGURE OUT WHAT TO DO WITH THIS !!!!!!
    *
    * */
    @Bean
    public void insertUsers(){
        // Testing code
        userRepository.save(new User(1, "foo", "foo", Arrays.asList("ROLE_ADMIN"), true));
        userRepository.save(new User(2, "foo1", "foo", Arrays.asList("ROLE_USER"), true));
        userRepository.save(new User(3, "foo2", "foo", Arrays.asList("ROLE_VERE"), true));

    }
}
