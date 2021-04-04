package com.schema.backend.controller;

import java.util.List;
import java.util.Optional;

import com.schema.backend.entity.User;
import com.schema.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    //instanciando o repositório do usuário para usar o banco (JPA-MySql):
    @Autowired
    private UserRepository userRepository;

    

    //Controlando o CRUD do User:
    //Perceba que extender a classe USER com JPA Repository possibilita um CRUD muito simples(veja a class: UserRepository)!
    // find all users
    @GetMapping("/all-users")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    // find user by id
    @GetMapping("/user-id={id}")
    public Optional<User> selectById(@PathVariable(value = "id") Integer id) {
        return userRepository.findById(id);
    }

    // find user (podem haver muitos "users" com o mesmo "name") by name
    @GetMapping("/user-name={name}")
    public List<User> selectByName(@PathVariable(value = "name") String name) {
        return userRepository.findByName(name);
    }

    // find user by email ("email" deve ser uma "unique key")
    @GetMapping("/user-email={email}")
    public Optional<User> selectByEmail(@PathVariable(value = "email") String email) {
        return userRepository.findByEmail(email);
    }
    
    // insert new user
    @PostMapping("/insert-user")
    public User savetUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // delete user (VOID)
    @DeleteMapping("/delete-user")
    public void deleteUser(@RequestBody User user){
        userRepository.delete(user);
    }

    // update user 
    @PutMapping("/update-user - UNIQUE")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }
    
}
