package com.sda.practical.controller;


import com.sda.practical.dto.RoleDto;
import com.sda.practical.model.Role;
import com.sda.practical.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {


    final private RoleService roleService;
    final private ModelMapper modelMapper;


    @Autowired
    public RoleController(RoleService roleService, ModelMapper modelMapper) {
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<RoleDto> getRoleList() {
        return roleService.getRoleList();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody RoleDto addRole( RoleDto roleDto) {
        Role savedRole = roleService.add(roleDto);
        return modelMapper.map(savedRole, RoleDto.class);
    }

    @GetMapping("/{id}")
    public RoleDto getRole(@PathVariable final Long id) {
        Role role = roleService.getRole(id);
        return modelMapper.map(role, RoleDto.class);


    }

}


