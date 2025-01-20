package com.pract.spring3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pract.spring3.util.CustomDoubleSerializer;
import jakarta.persistence.*;


@Entity
@Table(name = "EMPLOYEE", schema = "EMP_SCHEMA")  // Specify schema here
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")  // Use SEQUENCE strategy
    @SequenceGenerator(
            name = "employee_seq",
            sequenceName = "EMP_SCHEMA.EMPLOYEE_SEQ",  // Full path to the sequence (including schema)
            allocationSize = 1  // Define allocation size
    )
    @Column(name = "ID")  // Column name in the table
    private int id;

    @Column(name = "NAME", nullable = false)  // Column name and constraints
    private String name;

    @Column(name = "DEPARTMENT", nullable = false)  // Column name and constraints
    private String department;

    //@JsonFormat(shape = JsonFormat.Shape.STRING)  // Format salary as plain number
    @JsonSerialize(using = CustomDoubleSerializer.class)  // Apply the custom serializer to salary
    @Column(name = "SALARY", nullable = false)
    private double salary;

    // Constructors, Getters, and Setters
    public Employee() {}

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
