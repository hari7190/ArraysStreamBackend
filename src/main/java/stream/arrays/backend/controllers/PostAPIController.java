package stream.arrays.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stream.arrays.backend.domain.Post;
import stream.arrays.backend.services.interfaces.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostAPIController {
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable int id){
        return postRepository.findById(id);
    }

    @PostMapping
    public void createPost(@RequestBody Post payload){
        //An existing Id indicates a record in db, so we reuse it to update db record
        Post postTop = postRepository.findTopByOrderByIdDesc();
        int newId = (payload.getId() > 0) ? payload.getId() : (int) postTop.getId() +1;
        postRepository.save(new Post(
                newId
                ,payload.getContent()
                ,payload.getTitle()
                , payload.getAuthor()
                , payload.getImages()
                , payload.getDate()
                , payload.isReady()
        ));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postRepository.deleteById(id);
    }
}
