package com.example.task1.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Title")
    private String title;

    public String getTitle() {
        return title;
    }

    public String setTitle() {
        return title;
    }
    
    public String getName() {
        return name;
    }

    public String setName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
}
