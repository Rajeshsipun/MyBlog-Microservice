package com.microservice.post.service;

import com.microservice.post.entity.Post;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class PostServiceIMPL implements PostService{

    @Autowired
    private PostRepository postRepository ;


    @Override
    public Post savePost(Post post) {

        String postId = UUID.randomUUID().toString();
        post.setId(postId);

        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public Post findPostById(String postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();

        return post;
    }
}
