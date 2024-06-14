package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.ForumPost;
import ch.fhnw.pizza.data.repository.ForumPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/forumpost")
public class ForumPostController {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}