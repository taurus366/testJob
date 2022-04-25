package com.example.testjob.web;

import com.example.testjob.model.binding.UserRegisterEditBindingModel;
import com.example.testjob.model.dto.UserDTO;
import com.example.testjob.model.service.UserRegistrationEditServiceModel;
import com.example.testjob.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<Object> registerNewUser(@Valid @RequestBody UserRegisterEditBindingModel userRegisterEditBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {


        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterEditBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return ResponseEntity.status(HttpStatus.CONFLICT).body(bindingResult.getAllErrors());
        }

//        TODO
        UserDTO userDTO = this.userService
                .postNewUserAndTokenToDB(asUserRegistrationServiceModel(userRegisterEditBindingModel), request, response);


        return ResponseEntity.ok().body(userDTO);


    }

    @PatchMapping("/edit")
    public ResponseEntity<Object> editRegisteredUser(@Valid @RequestBody UserRegisterEditBindingModel userRegisterEditBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {

        System.out.println(userRegisterEditBindingModel.getUsername());
        System.out.println(userRegisterEditBindingModel.getUnderSectorThreeId());
        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterEditBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return ResponseEntity.status(HttpStatus.CONFLICT).body(bindingResult.getAllErrors());
        }

        try {
            UserDTO userDTO = this.userService
                    .editCurrentUser(asUserRegistrationServiceModel(userRegisterEditBindingModel), request, response);

            return ResponseEntity.ok(userDTO);

        } catch (NullPointerException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("You have to register new user first !");
        }

    }


    private UserRegistrationEditServiceModel asUserRegistrationServiceModel(UserRegisterEditBindingModel user) {

        UserRegistrationEditServiceModel newUser = new UserRegistrationEditServiceModel();
        newUser
                .setAgree(user.IsAgree())
                .setUsername(user.getUsername())
                .setSectorId(user.getSectorId())
                .setUnderSectorOneId(user.getUnderSectorOneId())
                .setUnderSectorTwoId(user.getUnderSectorTwoId())
                .setUnderSectorThreeId(user.getUnderSectorThreeId());

        return newUser;

    }
}
