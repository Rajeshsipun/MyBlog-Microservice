package com.microservice.post.controller;


import com.microservice.post.entity.Post;
import com.microservice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post>savePost(@RequestBody Post post){
      Post newPost=  postService.savePost(post);
    return new ResponseEntity<>(newPost, HttpStatus.CREATED);
}

@GetMapping("/{postId}")
public Post getPostByPostId(@PathVariable String postId){
      Post postById = postService.findPostById(postId);
      return postById;

}


}
