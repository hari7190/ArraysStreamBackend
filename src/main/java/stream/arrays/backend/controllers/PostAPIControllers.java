package stream.arrays.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stream.arrays.backend.domain.Post;
import stream.arrays.backend.services.interfaces.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostAPIControllers {
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
    @PostMapping
    public void createPost(@RequestBody Post payload){
        int newId;
        if(payload.getId() > 0){
            newId = payload.getId();
        } else {
            newId = (int) postRepository.count() +1;
        }
        postRepository.save(new Post(
                newId
                ,payload.getContent()
                ,payload.getTitle()
                , payload.getAuthor()
                , payload.getImages()
        ));
    }
}
