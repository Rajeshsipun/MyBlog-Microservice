package com.microservice.post.service;

import com.microservice.post.entity.Post;

public interface PostService {
    Post savePost(Post post);

    Post findPostById(String postId);
}
