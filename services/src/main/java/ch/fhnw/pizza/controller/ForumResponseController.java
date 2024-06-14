package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.ForumResponse;
import ch.fhnw.pizza.data.repository.ForumResponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/forumresponse")
public class ForumResponseController {

    @Autowired
    private ForumResponseRepository forumResponseRepository;

    @PostMapping(path = "/api/forum/posts/{postId}/responses", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ForumResponse> createForumResponse(@PathVariable Long postId, @RequestBody ForumResponse forumResponse) {
        forumResponse.setPostId(postId);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
    }
}