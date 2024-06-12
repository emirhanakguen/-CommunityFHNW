package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.ForumResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/forumresponse")
public class ForumResponseController {

    @PostMapping(path = "/api/forum/posts/{postId}/responses", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ForumResponse> createForumResponse(@PathVariable Long postId, @RequestBody ForumResponse forumResponse) {
        forumResponse.setPostId(postId);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
    }
}