package com.sda.practical.service;


import com.sda.practical.dto.RoleDto;
import com.sda.practical.model.Role;
import java.util.List;

public interface RoleService {

    List<RoleDto> getRoleList();   // IN SERVICE WE ALWAYS WORKING WITH MODEL NOT DTO OBJECT
    Role add(RoleDto role); // services should not return void
    Role getRole(Long id);
}
