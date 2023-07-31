package com.mongoweb.jobpost.Repo;
import java.util.List;

import com.mongoweb.jobpost.Post;

public interface SearchRepo{
    List<Post> search(String query);
}