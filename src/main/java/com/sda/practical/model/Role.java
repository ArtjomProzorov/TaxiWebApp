package com.sda.practical.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role")
    private Set<User> users;                                     // One Role can have many Users

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role(){

    }
}