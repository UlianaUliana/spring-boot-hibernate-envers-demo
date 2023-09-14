package com.ns.springboothibernateenvers.controller;

import com.ns.springboothibernateenvers.entity.User;
import com.ns.springboothibernateenvers.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envers/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{UserId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

    // Vertical query
    @GetMapping("/revisions_by_user_id/{userId}")
    public List<Object> getAllRevisionsByUserId(@PathVariable Integer userId) {
        return userService.getAllRevisionsByUserId(userId);
    }

    @GetMapping("/users_by_revision/{revisionNumber}")
    public List<User> getUsersByRevision(@PathVariable Integer revisionNumber) {
        return userService.getUsersByRevision(revisionNumber);
    }

    // Horisontal query
    @GetMapping("/users_at_revision/{revisionNumber}")
    public List<User> getUsersAtRevision(@PathVariable Integer revisionNumber) {
        return userService.getUsersAtRevision(revisionNumber);
    }
}

