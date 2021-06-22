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
@Table(name = "DEPARTMENT")
public class Department {

    public Department(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MTM",
            //foreign key for EmployeeEntity in employee_car table
            joinColumns = @JoinColumn(name = "DEPARTMENT_ID"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    List<User> users;

}
