package com.sda.practical.service.Imp;

import com.sda.practical.dto.RoleDto;
import com.sda.practical.model.Role;
import com.sda.practical.repository.RoleRepository;
import com.sda.practical.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<RoleDto> getRoleList() {
        List<Role> listOfRoles = roleRepository.findAll();
        return listOfRoles.stream().map(user -> modelMapper.map(user, RoleDto.class)).collect(Collectors.toList());

    }
    @Override
    public Role add(RoleDto roleDto){ Role role = modelMapper.map(roleDto, Role.class);
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(Long id) { return roleRepository.findById(id).filter(role -> role.getId().equals(id)).orElse(null); }

}
