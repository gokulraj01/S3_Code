/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to demonstrate abstract classes.
 * 
 * QUESTION
 * Java Program to create Abstract Class 'Shape' with empty method noOfSides()
 * Provide 3 classes, Rectangle, Triangle, Hexagon, each extending Shape class, implementing noOfSides()
 * that displays sides in that geometric shape.
*/

// Abstract Class for Shapes
abstract class Shape {
    abstract int noOfSides();
}

// Triangle implemented from Shape
class Triangle extends Shape{
    int noOfSides() {return 3;}
}

// Rectangle implemented from Shape
class Rectangle extends Shape{
    int noOfSides() {return 4;}
}

// Hexagon implemented from Shape
class Hexagon extends Shape{
    int noOfSides() {return 6;}
}

class Shapes{
    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape rect = new Rectangle();
        Shape hex = new Hexagon();
        System.out.println("Sides of Triangle: "+tri.noOfSides());
        System.out.println("Sides of Rectangle: "+rect.noOfSides());
        System.out.println("Sides of Hexagon: "+hex.noOfSides());
    }
}