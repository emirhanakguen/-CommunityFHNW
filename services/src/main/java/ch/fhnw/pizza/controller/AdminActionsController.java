package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.repository.AdminActionsRepository;
import ch.fhnw.pizza.data.repository.ForumPostRepository;
import ch.fhnw.pizza.data.domain.AdminActions;
import ch.fhnw.pizza.data.domain.ForumPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/adminactions")
public class AdminActionsController {

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @PutMapping(path = "/api/admin/modify/{type}/{id}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<AdminActions> updateAdminAction(@PathVariable String type, @PathVariable Long id, @RequestBody AdminActions adminAction) {
        AdminActions existingAction = adminActionsRepository.findById(id).orElse(null);
        if (existingAction != null) {
            existingAction.setType(type);
            AdminActions updatedAction = adminActionsRepository.save(existingAction);
            return ResponseEntity.ok(updatedAction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
}
    @DeleteMapping(path = "/api/admin/delete/{type}/{id}")
    public ResponseEntity<String> deleteAdminAction(@PathVariable String type, @PathVariable Long id) {
        AdminActions adminAction = adminActionsRepository.findById(id).orElse(null);
        if (adminAction != null) {
            adminActionsRepository.delete(adminAction);
            return ResponseEntity.ok("Admin action deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin action not found.");
        }
}
    @DeleteMapping("/api/forum/delete/{postId}")
    public ResponseEntity<String> deleteForumPost(@PathVariable Long postId) {
        try {
            forumPostRepository.deleteByPostId(postId);
            return ResponseEntity.ok("Forum post deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
}
    @PutMapping(path = "/api/forum/edit/{postId}")
    public ResponseEntity<ForumPost> updateForumPost(@PathVariable Long postId, @RequestBody ForumPost updatedPost) throws Exception {
        ForumPost existingPost;
        try {
            existingPost = forumPostRepository.findById(postId).get();
            ForumPost savedPost = forumPostRepository.save(existingPost);
            return ResponseEntity.ok(savedPost);
        }catch(Exception e){
            new Exception("ForumPost not found with ID: " + postId);
        }
        return null;
}
    @GetMapping(path = "/api/auth/login/{adminId}",produces = "application/json")
    public ResponseEntity<String> showAdminContent(Principal principal) {
    String message = "Welcome, " + principal.getName() + "! <BR> Only an admin can view this content.";
    return new ResponseEntity<>(message, HttpStatus.OK);
    }
}