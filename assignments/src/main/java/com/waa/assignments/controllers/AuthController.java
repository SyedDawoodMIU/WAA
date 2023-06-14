package com.waa.assignments.controllers;

import com.waa.assignments.entity.dto.AuthRequest;
import com.waa.assignments.entity.dto.AuthResponse;
import com.waa.assignments.entity.dto.RoleDto;
import com.waa.assignments.security.JwtTokenUtil;
import com.waa.assignments.services.RoleService;
import com.waa.assignments.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
public class AuthController {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        var user = userService.loadUserByUsername(authRequest.getUsername());
        var roles =  roleService.getAll().stream().map(RoleDto::getName).map(SimpleGrantedAuthority::new).toList();
        UserDetails userDetails = new User(user.getUsername(), "", roles);
        String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
