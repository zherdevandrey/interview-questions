package ru.cetelem.com.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent {

    String parentName;

    public static void test() {
        System.out.println("CHILD");
    }

}
