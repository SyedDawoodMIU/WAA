package com.waa.assignments.controllers;

import com.waa.assignments.entity.dto.UserDto;
import com.waa.assignments.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

    private final UserService UserService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.UserService = userService;
        this.modelMapper = modelMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/Users")
    public List<UserDto> getAll() {
        return UserService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/Users")
    public void save(@RequestBody UserDto p) {
        UserService.save(p);
    }

    @GetMapping("/v1/Users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        var User = UserService.getById(id);
        return ResponseEntity.ok(User);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1/Users/{id}")
    public void delete(@PathVariable Long id) {
        UserService.deleteByID(id);
    }

    @PutMapping("/v1/Users/{id}")
    public void update(@PathVariable("id") Long UserId, @RequestBody UserDto p) {
        UserService.update(UserId, p);
    }

}
