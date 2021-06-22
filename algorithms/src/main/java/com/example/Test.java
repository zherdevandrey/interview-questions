package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person(1, "person1", 1, "MOS"),
                new Person(2, "person2", 2, "MOS"),
                new Person(3, "person3", 3, "SPB"),
                new Person(4, "person4", 4, "SPB"),
                new Person(5, "person5", 5, "SPB")
        );





    }


}


@AllArgsConstructor
@NoArgsConstructor
@Data
class Person{
    private int id;
    private String name;
    private int age;
    private String city;
}
