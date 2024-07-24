package com.microservice.post.service;

import com.microservice.post.config.RestTemplateConfig;
import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@Service
public class PostServiceIMPL implements PostService{

    @Autowired
    private PostRepository postRepository ;

    @Autowired
    private RestTemplateConfig restTemplateConfig ;


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

    @Override
    public PostDto getPostWithComments(String postId) {

        Post post = postRepository.findById(postId).get();
        ArrayList comment = restTemplateConfig.getRestTemplate().getForObject
                ("http://localhost:8083/api/v1/comment/" + postId, ArrayList.class);

        PostDto  postDto = new PostDto();

       postDto.setTitle(post.getTitle());
       postDto.setDescription(post.getDescription());
       postDto.setContent(post.getContent());
       postDto.setPostId(post.getId());
       postDto.setComments(comment);
        return postDto;

    }
}
