package com.schema.backend.controller;

import java.util.List;
import java.util.Optional;

import com.schema.backend.entity.User;
import com.schema.backend.repository.UserRepository;

import org.apache.catalina.connector.Response;
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
    public User saveUser(@RequestBody User user){
				Optional<User> findbyEmail = userRepository.findByEmail(user.getEmail());

				if(findbyEmail.isEmpty() == true){
					return userRepository.save(user);
				}else{
					User userNull = new User();
					return userNull;
				}
    }

    // delete user (VOID)
    @DeleteMapping("/delete-user={id}")
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    // update user
		// conversar com o professor sobre os retornos
    @PutMapping("/update-user={id}")
    public User updateUser(@RequestBody User user){
        //Não deu muito certo, deixar comentado por enquanto... tem que verificar o que q ta acontecendo depois, essa regra ta afetando o insert e não o update, deve ter feito alguma chamada atravessada no front..
			// String t = userRepository.findById(user.getId()).get().getEmail().toLowerCase().toString();
			// String p =  user.getEmail().toLowerCase().toString();
			// if(!t.equals(p)){
			// 	return "Email não pode ser alterado!";
			// }else{
				return userRepository.save(user);
			// 	return "Sucesso!";
			// }
		}

}
