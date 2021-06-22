package ru.cetelem.com.patterns;

import lombok.AllArgsConstructor;

public class DecoratorExample {

    public static void main(String[] args) {
        Developer developer = new SeniorJavaDeveloper(new JavaDeveloper());
        developer.makeJob();
    }

}

interface Developer{
    void makeJob();
}

@AllArgsConstructor
class DeveloperDecorator implements Developer{

    Developer developer;

    @Override
    public void makeJob() {
        developer.makeJob();
    }
}

class JavaDeveloper implements Developer{
    @Override
    public void makeJob() {
        System.out.println("write code");
    }
}

class SeniorJavaDeveloper extends DeveloperDecorator {

    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public void makeJob() {
        super.makeJob();
        makeCodeReview();
    }

    public void makeCodeReview() {
        System.out.println("make code review");
    }
}