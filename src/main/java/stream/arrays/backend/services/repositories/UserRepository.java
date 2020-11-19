package stream.arrays.backend.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import stream.arrays.backend.domain.User;
import java.util.Optional;

@Service
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByuserName(String username);
}
