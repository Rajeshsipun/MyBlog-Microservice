package com.microservice.post.controller;


import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
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
    @Autowired
    private PostRepository postRepository;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8082/api/v1/posts
    @PostMapping
    public ResponseEntity<Post>savePost(@RequestBody Post post){
      Post newPost=  postService.savePost(post);
    return new ResponseEntity<>(newPost, HttpStatus.CREATED);
}


    //http://localhost:8082/api/v1/posts/{postId}
@GetMapping("/{postId}")
public Post getPostByPostId(@PathVariable String postId){
      Post postById = postService.findPostById(postId);
      return postById;

}


    //http://localhost:8082/api/v1/posts/{postId}/comments
@GetMapping("/{postId}/comments")
public ResponseEntity<PostDto>getPostWithComments(@PathVariable String postId){

        PostDto postDto = postService.getPostWithComments(postId);

        return new ResponseEntity<>(postDto,HttpStatus.OK);
}


}
