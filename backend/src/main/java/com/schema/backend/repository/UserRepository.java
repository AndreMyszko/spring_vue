package com.schema.backend.repository;

import java.util.List;
import java.util.Optional;

import com.schema.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    //CRUD:    
    //find userS (collection) by name
    List<User> findByName(String name);

    //find useR (email deve ser único - unique key )
    Optional<User> findByEmail(String email);

    //OBS.: todos os demais itens do CRUD já existem e são herdados da classe extendida "JpaRepository"...

}
