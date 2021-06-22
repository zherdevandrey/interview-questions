package ru.cetelem.com.patterns;

public class FactoryExample {

    public static void main(String[] args) {
        Car toyota = new Factory().create("TOYOTA");
        toyota.drive();
    }
}

interface Car{
    public void drive();
}

class Toyota implements Car{

    @Override
    public void drive() {
        System.out.println("DRIVE TOYOTA");
    }
}

class Audi implements Car{

    @Override
    public void drive() {
        System.out.println("DRIVE AUDI");
    }
}

class Factory{

    public Car create(String type){
        switch (type.toUpperCase()){
            case "AUDI": return new Audi();
            case "TOYOTA": return new Toyota();
            default: return null;
        }
    }

}


