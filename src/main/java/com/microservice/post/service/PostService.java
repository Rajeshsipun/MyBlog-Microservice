package com.microservice.post.service;

import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;

public interface PostService {
    Post savePost(Post post);

    Post findPostById(String postId);

    PostDto getPostWithComments(String postId);
}
