package com.sharecab.sharecab.services;

import com.sharecab.sharecab.entities.UserDTO;
import com.sharecab.sharecab.models.Login;
import com.sharecab.sharecab.models.Register;
import com.sharecab.sharecab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//UserService class as define service class therefore implement by the @Service annotation
public class UserService {


    @Autowired
    // UserRepository want to work as service , So that implement by @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserDTO register(Register register){


        UserDTO userExist = userRepository.findByUsername(register.getUsername());

       /* if(userExist!=null){
            throw new RuntimeException("UserDTO Exist");
        }*/


        UserDTO user = new UserDTO();


        user.setPassword(register.getPassword());
        user.setFirstname(register.getFirstname());
        user.setLastname(register.getLastname());
        user.setDob(register.getDob());
        user.setGender(register.getGender());
        user.setEmail(register.getEmail());
        user.setConfirmPass(register.getConfirmPass());
        user.setUsername(register.getUsername());
        user.setPhonenumber(register.getPhonenumber());



        userRepository.save(user);


        return user;
    }

    public Boolean login(Login login) {

        UserDTO user = userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());


        return user!=null;
    }
}
