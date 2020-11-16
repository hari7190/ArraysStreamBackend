package stream.arrays.backend.services.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stream.arrays.backend.domain.Subscriber;

import java.util.List;

@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
    public Subscriber findTopByOrderByIdDesc();
}
