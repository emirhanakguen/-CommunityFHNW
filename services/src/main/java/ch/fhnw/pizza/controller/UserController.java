package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.User;
import ch.fhnw.pizza.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
    try {
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @PutMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
    try {
        User existingUser = userRepository.findById(updatedUser.getUserID())
        .orElseThrow(() -> new Exception("User not found with ID: " + updatedUser.getUserID()));
        existingUser.setSomeProperty(updatedUser.getSomeProperty());
        userRepository.save(existingUser);
        return ResponseEntity.ok("User updated successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @DeleteMapping(path = "/api/admin/users/manage")
    public ResponseEntity<?> deleteUser(@RequestBody long userID) {
    try {
        User optionalUser = userRepository.findById(userID).get();
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
}
    @GetMapping(path = "/api/auth/login/{studentId}",produces = "application/json")
    public ResponseEntity<String> showUserContent(Principal principal) {
    String message = "Welcome, " + principal.getName() + "! <BR> Only a user can view this content.";
    return new ResponseEntity<>(message, HttpStatus.OK);
    }
}