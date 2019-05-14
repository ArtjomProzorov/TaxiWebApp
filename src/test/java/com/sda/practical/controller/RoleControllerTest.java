package com.sda.practical.controller;


import com.sda.practical.dto.RoleDto;
import com.sda.practical.model.Role;
import com.sda.practical.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoleControllerTest.class)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Test
    public void getRoleTestSuccess() throws Exception {


        RoleDto role = new RoleDto();
        RoleDto role2 = new RoleDto();
        List<RoleDto> roleList = new ArrayList<>();
        role.setId(1L);
        role.setName("admin");
        roleList.add(role);
        role2.setId(2L);
        role2.setName("user");
        roleList.add(role2);
        when(roleService.getRoleList(/*any()*/)).thenReturn(roleList);


        mockMvc.perform(get("/role/list")
                .contentType(MediaType.APPLICATION_JSON)) //return type JSON
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("id")
                        .value("1"));


    }

}
