package com.mongoweb.jobpost.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoweb.jobpost.Post;

public interface PostRepository extends MongoRepository<Post,String> {
    
}
