package com.gestion.entity;

import jakarta.persistence.Entity;

@Entity
public class Employee {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int phone;
    private String sex;
    private double salary;
}
