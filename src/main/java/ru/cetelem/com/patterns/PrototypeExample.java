package ru.cetelem.com.patterns;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PrototypeExample {

    public static void main(String[] args) {
        Project prototype = new Project("prototype", "description");
        Project clone = new ProjectFactory(prototype).cloneProject();
        System.out.println(prototype.equals(clone));
    }

}

interface Copyable {
    Object copy();
}

@Data
@AllArgsConstructor
class Project implements Copyable {
    String name;
    String description;

    @Override
    public Object copy() {
        return new Project(name, description);
    }
}

@AllArgsConstructor
class ProjectFactory {
    Project project;

    Project cloneProject() {
        return (Project) project.copy();
    }
}