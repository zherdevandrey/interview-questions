package ru.cetelem.com.patterns;

import lombok.AllArgsConstructor;

public class BridgeExample {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new BlackColor());
        rectangle.draw();
    }
}

@AllArgsConstructor
abstract class Shape{

    protected Color color;

    abstract void draw();
}

interface Color{
    void fillColor();
}

class BlackColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in black color");
    }
}

class GreenColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in green color");
    }
}

class Rectangle extends Shape{

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        color.fillColor();
        System.out.println("DRAW RECTANGLE");
    }
}

class Triangle extends Shape{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        color.fillColor();
        System.out.println("DRAW TRIANGLE");
    }
}
