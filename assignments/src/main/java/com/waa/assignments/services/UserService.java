package com.waa.assignments.services;

import com.waa.assignments.entity.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends BaseService<UserDto, Long> {

    public List<UserDto> findAll();

    void update(Long id, UserDto p);

    List<UserDto> findUsersByPostTitle(String title);

    UserDetails loadUserByUsername(String username);


}