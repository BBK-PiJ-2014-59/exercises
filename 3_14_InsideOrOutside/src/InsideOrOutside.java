// 14 Inside or outside
// Write a program that reads the coordinates of the two points defining a 
// rectangle and then the coordinates of a third point. The program must then 
// determine whether the point falls inside or outside the rectangle.

// xIsIn(left, right)
// yIsIn(up, down)

public class InsideOrOutside {
    Rectangle r;
    TestPoint testpoint;
    
    public InsideOrOutside() {
        r = new Rectangle();
        testpoint = new TestPoint();
    }
    
    public Double[] getPointFromUser(String desc) {
        Double xy[] = new Double[2];
        System.out.println("Enter " + desc + "x: ");
        xy[0] = Double.parseDouble(System.console().readLine());
        System.out.println("Enter " + desc + "y: ");
        xy[1] = Double.parseDouble(System.console().readLine());
        return xy;
    }
    
    public class TestPoint {
        Point tp;
        
        TestPoint() {
            tp = new Point();
        }
    }
    
    public getTestPoint() {
        Double xy[] getPoint
        
    }
    
    public class Rectangle {
        Point p1;
        Point p2;
    
        Rectangle() {
            p1 = new Point();
            p2 = new Point();
        }
        
        class Point {
            double x;
            double y;
        }
        
        private void setX(Point p, double xIn) {
            p.x = xIn;
        }
        
        private void setY(Point p, double yIn) {
            p.y = yIn;
        }
                
        public void getPoint() {
            System.out.println("Enter x: ");
            double in = Double.parseDouble(System.console().readLine());
            setX(p1, in);
            System.out.println("Enter y: ");
            in = Double.parseDouble(System.console().readLine());
            setY(p1, in);
        }
        
    }
    
    public static void main(String[] args) {
        InsideOrOutside pointTest = new InsideOrOutside();
        pointTest.Rectangle.getPoint();
        pointTest.Rectangle.getPoint();
        pointTest.getTestPoint();
        pointTest.printInOrOut();
    }
}
