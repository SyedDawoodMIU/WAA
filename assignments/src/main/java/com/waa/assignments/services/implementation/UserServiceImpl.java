package com.waa.assignments.services.implementation;

import com.waa.assignments.entity.business.User;
import com.waa.assignments.entity.dto.UserDto;
import com.waa.assignments.helper.ListMapper;
import com.waa.assignments.repo.UserRepository;
import com.waa.assignments.services.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<UserDto> findAll() {
        var Users = userRepository.findAll();
        return listMapper.mapList(Users, UserDto.class);
    }

    @Override
    public UserDto getById(Long id) {

        return modelMapper.map(userRepository.getById(id), UserDto.class);
    }

    @Override
    public void delete(UserDto UserDto) {

        userRepository.delete(modelMapper.map(UserDto, User.class));

    }

    @Override
    public void save(UserDto p) {

        userRepository.save(modelMapper.map(p, User.class));

    }

    @Override
    public void update(Long id, UserDto p) {

        if (userRepository.existsById(id)) {
            userRepository.save(modelMapper.map(p, User.class));
        }

    }

    @Override
    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

}
