package com.waa.assignments.services.implementation;

import com.waa.assignments.aspect.annotation.ExecutionTime;
import com.waa.assignments.entity.business.User;
import com.waa.assignments.entity.dto.UserDto;
import com.waa.assignments.helper.ListMapper;
import com.waa.assignments.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    public List<UserDto> findAll() {
        var Users = userRepository.findAll();
        return listMapper.mapList(Users, UserDto.class);
    }

    @ExecutionTime
    public UserDto getById(Long id) throws Exception {
    var user = userRepository.findById(id);

        if (user.isPresent())
        {
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw  new Exception("My exception");
    }

    public void delete(UserDto UserDto) {

        userRepository.delete(modelMapper.map(UserDto, User.class));

    }

    public void save(UserDto p) {

        userRepository.save(modelMapper.map(p, User.class));

    }

    public void update(Long id, UserDto p) {

        if (userRepository.existsById(id)) {
            userRepository.save(modelMapper.map(p, User.class));
        }

    }

    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDto> findUsersByPostTitle(String title) {
        var users = userRepository.findUsersByPostTitle(title);
        return listMapper.mapList(users, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
