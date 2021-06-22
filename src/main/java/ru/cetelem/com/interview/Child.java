package ru.cetelem.com.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Child extends Parent {

    String childName;

    public static void test() {

       int a = new Integer(1);

        System.out.println("CHILD");
    }

    public Child(String childName) {
        this.childName = childName;
    }

    public Child(String parentName, String childName) {
        super(parentName);
        this.childName = childName;
    }
}
