package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.AccountManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/accountmanagement")
public class AccountManagementController {

    @PutMapping(path = "/api/superadmin/admins/update/{adminId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateAccountManagement(@PathVariable Long adminId, @RequestBody AccountManagement updatedAccount) {
    try {
        AccountManagement existingAccount = accountManagementRepository.findById(adminId)
        .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + adminId));
        existingAccount.setSomeProperty(updatedAccount.getSomeProperty());
        AccountManagement savedAccount = accountManagementRepository.save(existingAccount);
        return ResponseEntity.ok(savedAccount);
    } catch (ResourceNotFoundException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @DeleteMapping(path = "/api/superadmin/admins/delete/{adminId}")
    public ResponseEntity<?> deleteAccountManagement(@PathVariable Long adminId) {
    try {
        Optional<AccountManagement> optionalAccount = accountManagementRepository.findById(adminId);
        if (optionalAccount.isPresent()) {
            AccountManagement accountManagement = optionalAccount.get();
            accountManagementRepository.delete(accountManagement);
            return ResponseEntity.ok("Account management record deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting account management record.");
    }
}
    @PostMapping(path = "/api/superadmin/admins/create",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createAccountManagement(@RequestBody AccountManagement accountManagement) {
    try {
        AccountManagement savedAccount = accountManagementRepository.save(accountManagement);
        return ResponseEntity.ok("Account management record created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @GetMapping(path = "/api/auth/login/{superadminId}",produces = "application/json")
    public ResponseEntity<String> showAdminContent(Principal principal) {
    String message = "Welcome, " + principal.getName() + "! <BR> Only an admin can view this content.";
    return new ResponseEntity<>(message, HttpStatus.OK);
}