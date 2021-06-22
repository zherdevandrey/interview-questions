package com.example.hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
@Table(name = "USER")
public class User {

    public User(String name) {
        this.name = name;
    }

    public User(String name, Salary salary) {
        this.name = name;
        this.salary = salary;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "user")
    private Salary salary;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MTM",
            //foreign key for EmployeeEntity in employee_car table
            joinColumns = @JoinColumn(name = "USER_ID"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "DEPARTMENT_ID"))
    List<Department> departments;


}
