package com.sharecab.sharecab.repositories;

import com.sharecab.sharecab.entities.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<UserDTO, Integer> {

    UserDTO findByUsername(String name);

    UserDTO findByUsernameAndPassword(String username, String password);
}
