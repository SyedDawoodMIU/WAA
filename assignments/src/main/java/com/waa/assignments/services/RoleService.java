package com.waa.assignments.services;

import com.waa.assignments.entity.dto.RoleDto;
import com.waa.assignments.repo.RoleRepository;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleService extends BaseService<RoleDto, Integer> {


    List<RoleDto> getAll();
}
