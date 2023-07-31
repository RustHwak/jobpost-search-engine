package com.mongoweb.jobpost;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongoweb.jobpost.Repo.PostRepository;
import com.mongoweb.jobpost.Repo.SearchRepo;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@CrossOrigin(origins ="http://localhost:3000")
public class Controller {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepo srepo;
    
    
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("swagger-ui/index.html");
        
    }
    @GetMapping("/allposts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        
        return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post>search(@PathVariable String text){
        return srepo.search(text);
    }
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }



    
}
