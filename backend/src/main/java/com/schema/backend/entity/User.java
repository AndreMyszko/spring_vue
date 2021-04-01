package com.schema.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class User {

    // ATRIBUTES:
    @Id // PK - primarykey
    @GeneratedValue(strategy = GenerationType.AUTO) // AI - autoincrement
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private String user_role;

    @Column(name = "active")
    private Boolean active;

    // CONSTRUCTORS:
    // empty constructor:
    public User() {
    }

    // all fields constructor:
    public User(Integer id, String name, String email, String password,
            String user_role/* , Set<User_Roles> user_role */, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.user_role = user_role;
        this.active = active;
    }

    // no ID constructor:
    public User(String name, String email, String password, String user_role/* , Set<User_Roles> user_role */,
            Boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.user_role = user_role;
        this.active = active;
    }

    // GETTERS AND SETTERS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return this.user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
