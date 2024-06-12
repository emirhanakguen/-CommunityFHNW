package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @PostMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
    try {
        entityManager.persist(user);
        return ResponseEntity.ok("User created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @PutMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
    try {
        User existingUser = userRepository.findById(updatedUser.getId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + updatedUser.getId()));
        existingUser.setSomeProperty(updatedUser.getSomeProperty());
        userRepository.save(existingUser);
        return ResponseEntity.ok("User updated successfully.");
    } catch (ResourceNotFoundException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @DeleteMapping(path = "/api/admin/users/manage")
    public ResponseEntity<?> deleteUser(@RequestBody int userID) {
    try {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @GetMapping(path = "/api/auth/login/{studentId}",produces = "application/json")
    public ResponseEntity<String> showUserContent(Principal principal) {
    String message = "Welcome, " + principal.getName() + "! <BR> Only a user can view this content.";
    return new ResponseEntity<>(message, HttpStatus.OK);
}