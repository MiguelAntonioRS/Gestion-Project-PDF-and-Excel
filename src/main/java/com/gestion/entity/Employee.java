package com.gestion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Employee {

    private Long id;
}
