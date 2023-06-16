package alston.homework3;

public class Polymorphism_shape {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape triangle = new Triangle();
        Shape trapezoid = new Trapezoid();

        circle.countArea(27);
        circle.countCircumference(13);
        triangle.countArea(26, 8);
        trapezoid.countArea(36, 84, 109);
    }

}

class Shape {

    void countArea(int r) {
        System.out.println("counting Circle area");
    }

    void countArea(int l, int h) {
        System.out.println("counting Triangle area");
    }

    void countArea(int c, int f, int h) {
        System.out.println("counting Trapezoid area");
    }

    void countCircumference(int r) {
        System.out.println("counting Circle circumference");
    }

    void countCircumference(int l, int h) {
        System.out.println("counting Triangle circumference");
    }

}

class Circle extends Shape{

    @Override
    void countArea(int r) {
        System.out.println("Circle area is " + (r * r * Math.PI));
    }

    @Override
    void countCircumference(int r) {
        System.out.println("Circle circumference is " + (r * 2 * Math.PI));
    }

}

class Triangle extends Shape{

    @Override
    void countArea(int l, int h) {
        System.out.println("Triangle area is " + (l * h / 2));
    }

    @Override
    void countCircumference(int l, int h) {
        double t = (Math.sqrt(l) + Math.sqrt(h)) / 2;
        System.out.println("Triangle circumference is " + (l * h / 2));
    }

}

class Trapezoid extends Shape{

    @Override
    void countArea(int c, int f, int h) {
        System.out.println("Trapezoid area is " + ((c + f) * h / 2));
    }

}