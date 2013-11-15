// 13 Rectangle
// Write a program that reads the X and Y coordinates of two points and then 
// outputs the area of a rectangle where both points are opposite corners. 
// Use the following class to store the data for the points:
// class Rectangle {
//    Point upLeft;
//    Point downRight;
// }
// Your program should calculate (and write on the screen) the perimeter and 
// area of the rectangle.

// import java.util.*;

public class Rectangle {
    Point upLeft;
    Point downRight;

    public Rectangle(Double x1, Double y1, Double x2, Double y2) {
        // 0 5 5 0
        upLeft = new Point(x1, y1);
        System.out.println(x1 + ", " + y1);
        downRight = new Point(x2, y2);
        System.out.println(x2 + ", " + y2);
    }
            
    public double area() {
        double vert = Math.abs(upLeft.gety() - downRight.gety());
        // 5 - 0
        System.out.println(upLeft.gety() + " - " + downRight.gety() + " = " + vert);
        double hor = Math.abs(upLeft.getx() - downRight.getx());
        // 0 - 5
        System.out.println(hor);
        return vert * hor;
    }
    
    public class Point {
        double x;
        double y;
        
        public Point(Double xIn, Double yIn) {
            x = xIn;
            System.out.println("yoda x y " + x + " " + y);

            y = yIn;
            System.out.println("hamish x y " + x + " " + y);

        }
        
        double getx() {
            return x;
        }
        
        double gety() {
            return y;
        }
    } 
    
    public static void main(String[] args) {
        Rectangle r = new Rectangle(0.0, 5.0, 5.0, 0.0);
        // OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        System.out.println(r.area());
    }
}