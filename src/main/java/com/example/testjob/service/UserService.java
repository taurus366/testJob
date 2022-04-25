package com.example.testjob.service;
import com.example.testjob.model.dto.UserDTO;
import com.example.testjob.model.service.UserRegistrationEditServiceModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {


    UserDTO postNewUserAndTokenToDB(UserRegistrationEditServiceModel newUser, HttpServletRequest request, HttpServletResponse response);
    UserDTO editCurrentUser(UserRegistrationEditServiceModel currentUser,HttpServletRequest request,HttpServletResponse response);

}
