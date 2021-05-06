package com.marinin.core_to_boot.controllers;

import com.marinin.core_to_boot.models.Role;
import com.marinin.core_to_boot.models.User;
import com.marinin.core_to_boot.service.service.RoleService;
import com.marinin.core_to_boot.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RestController
public class RESTController { // если имя класса RestController - ругается

    private final UserService userService;
    private final RoleService roleService;

    public RESTController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    // вроде можно использовать @ResponseBody, в результате чего ответ автоматически обернётся в ResponseEntity, но сделаем топорно
    @GetMapping("/rest/current")
    public ResponseEntity<User> getCurrent() {
        return new ResponseEntity<>((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(), HttpStatus.OK);
    }

    @GetMapping("/rest/users")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/rest/roles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getSetOfAllRoles(), HttpStatus.OK);
    }

    @PostMapping("/rest")
    public ResponseEntity<List<User>>  newUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/rest/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PatchMapping("rest/{id}")
    public ResponseEntity<List<User>> edit(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
