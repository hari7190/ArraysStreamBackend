package stream.arrays.backend.services.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stream.arrays.backend.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    public Post findByAuthor(String author);
}
