//package com.sda.practical.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sda.practical.dto.UserDto;
//import com.sda.practical.model.Passenger;
//import com.sda.practical.model.User;
//import com.sda.practical.service.Imp.UserServiceImp;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMVC;
//
//    @MockBean
//    private UserServiceImp userServiceImp;
//
//
//    @Test
//    public void findUserResultSuccess() throws Exception {
//        final UserDto userDto = new UserDto();
//        userDto.setId(1L);
//        userDto.setUserName("test");
//        userDto.setPhoneNumber("127123");
////        final String responseMessage = "{\"userId\":1,\"username\":\"test\",\"mobile\":\"127123\"}";
//        final User user = new User();
//        user.setId(1L);
//        user.setUserName("test");
//        user.setPhoneNumber("127123");
//
//        when(userServiceImp.findOne(any())).thenReturn(user);
//
//
//
//        final ObjectMapper mapper = new ObjectMapper();
//        final String request = mapper.writeValueAsString(userDto);
//
//        mockMVC.perform(get("/user/list/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(request).header("id",1))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void findUserListResultSuccess() throws Exception {
//
//        final List<UserDto> user = new ArrayList<>();
//        final UserDto user1 = new UserDto();
//        user1.setFirstName("Artjom");
//        user1.setLastName("Prozorov");
//        user1.setUserName("user");
//        user1.setAge(18L);
//        user1.setId(1L);
//        user1.setPassword("123");
//        user1.setEmail("timprozorov@icoud.com");
//        user1.setPhoneNumber("1234567");
//
//        final UserDto user2 = new UserDto();
//        user1.setFirstName("Artjom1");
//        user1.setLastName("Prozorov2");
//        user1.setUserName("user3");
//        user1.setAge(18L);
//        user1.setId(1L);
//        user1.setPassword("123");
//        user1.setEmail("timprozorovv@icoud.com");
//        user1.setPhoneNumber("1234567");
//
//        user.add(user1);
//        user.add(user2);
//
//
//        final List<UserDto> usertest = new ArrayList<>(2);
//
//        when(userServiceImp.getUserList()).thenReturn(user);
//
//        mockMVC.perform(get("/user/list")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
//}
