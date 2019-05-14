package com.sda.practical.dto;


import java.io.Serializable;

public class RoleDto implements Serializable { //no methods // marker

    private String name;
    private Long id;

    public RoleDto(String name) {
        this.name = name;
    }

    public RoleDto(){

    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

}
