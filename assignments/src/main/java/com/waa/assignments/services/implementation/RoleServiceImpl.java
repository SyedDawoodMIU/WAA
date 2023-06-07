package com.waa.assignments.services.implementation;

import com.waa.assignments.entity.business.Role;
import com.waa.assignments.entity.dto.RoleDto;
import com.waa.assignments.helper.ListMapper;
import com.waa.assignments.repo.RoleRepository;
import com.waa.assignments.services.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final ListMapper listMapper;

    @Override
    public void save(RoleDto roleDto) {
        roleRepository.save(modelMapper.map(roleDto, Role.class));

    }

    @Override
    public RoleDto getById(Integer integer) throws Exception {
        var role =  roleRepository.findById(integer);

        if(role.isPresent()){
            return modelMapper.map(role.get(), RoleDto.class);
        }
        throw new Exception("Role not found");
    }

    @Override
    public void delete(RoleDto roleDto) {
        roleRepository.delete(modelMapper.map(roleDto, Role.class));
    }

    @Override
    public void deleteByID(Integer integer) {
        roleRepository.deleteById(integer);

    }

    @Override
    public void update(Integer integer, RoleDto roleDto) {
        if (roleRepository.existsById(integer)) {
            roleRepository.save(modelMapper.map(roleDto, Role.class));
        }

    }

    @Override
    public List<RoleDto> getAll() {
        return listMapper.mapList(roleRepository.findAll(), RoleDto.class);
    }
}
