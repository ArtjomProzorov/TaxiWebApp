package com.sda.practical.service;


import com.sda.practical.dto.RoleDto;
import com.sda.practical.model.Role;
import com.sda.practical.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
//@Sql(scripts = "/test-dataset.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RoleServiceTest {


    @Autowired
    RoleService roleService;


    @Test
    public void getRoleList(){
        List<RoleDto> roles = roleService.getRoleList();
        Assert.assertEquals(3, roles.size());

    }

    @Test
    public void getRole(){
        Role role = roleService.getRole(1L);
        Assert.assertEquals(1,99);

    }



}
