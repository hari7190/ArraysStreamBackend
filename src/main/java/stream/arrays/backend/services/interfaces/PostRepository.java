package stream.arrays.backend.services.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stream.arrays.backend.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findByAuthor(String author);
    public Post findById(int id);
    public void deleteById(int id);
}
