package com.sharecab.sharecab.controllers;

import com.sharecab.sharecab.entities.UserDTO;
import com.sharecab.sharecab.models.Login;
import com.sharecab.sharecab.models.Register;
import com.sharecab.sharecab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private UserDTO register(@RequestBody Register register){

        return  userService.register(register);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Boolean login(@RequestBody Login login){

        return  userService.login(login);

    }

}
