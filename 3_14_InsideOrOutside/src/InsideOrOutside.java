// 14 Inside or outside
// Write a program that reads the coordinates of the two points defining a 
// rectangle and then the coordinates of a third point. The program must then 
// determine whether the point falls inside or outside the rectangle.

// xIsIn(left, right)
// yIsIn(up, down)

public class InsideOrOutside {
    Rectangle r;
    TestPoint testpoint;
    
    // public InsideOrOutside() {
        // r = new Rectangle();
        // testpoint = new TestPoint();
    // }
    
    public boolean isInside(TestPoint testp, Rectangle rect) {
        Point tp = testp.getTestPoint();
        double tpx = tp.getx();
        double tpy = tp.gety();
        Point rp1 = rect.getP1();
        Point rp2 = rect.getP2();
        double rp1x = rp1.getx();
        double rp1y = rp1.gety();
        double rp2x = rp2.getx();
        double rp2y = rp2.gety();
        
        if (isBetween(tpx, rp1x, rp2x) && isBetween(tpx, rp1y, rp2y)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isBetween(Double a, Double lim1, Double lim2) {
        return ((lim1 > a && a > lim2 ) || (lim2 > a && a > lim1));
    }
    
    public class TestPoint {
        Point tp;
        
        TestPoint() {
            tp = new Point();
        }
        
        void getTestPointFromUser() {
            tp.getPointFromUser("test point");
        }
        
        Point getTestPoint() {
            return tp;
        }
    }
    
    public class Rectangle {
        Point p1;
        Point p2;
    
        public Rectangle() {
            p1 = new Point();
            p2 = new Point();
        }
        
        Rectangle getRectangle() {
            return this;
        }
        
        private Point getP1() {
            return p1;
        }
        
        private Point getP2() {
            return p2;
        }
        
        public void getP1FromUser() {
            p1.getPointFromUser("rectangle point one");
        }
        
        public void getP2FromUser() {
            p2.getPointFromUser("rectangle point two");
        }
    }
    
    class Point {
        String desc;
        double x;
        double y;
        
        double getx() {
            return x;
        }
        
        double gety() {
            return y;
        }
        
        void setx(Double xIn) {
            x = xIn;
        }
        
        void sety(Double yIn) {
            y = yIn;
        }
        
        public void getPointFromUser(String desc) {
            System.out.println("Enter " + desc + " x: ");
            double in = Double.parseDouble(System.console().readLine());
            setx(in);
            System.out.println("Enter " + desc + " y: ");
            in = Double.parseDouble(System.console().readLine());
            sety(in);
        }
    }
        
    
    public static void main(String[] args) {
        InsideOrOutside pointTest = new InsideOrOutside();
        // OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        InsideOrOutside.Rectangle rectangle = pointTest.new Rectangle();
        rectangle.getP1FromUser();
        rectangle.getP2FromUser();
        InsideOrOutside.TestPoint testpoint = pointTest.new TestPoint();  
        testpoint.getTestPointFromUser();
        String answer = (pointTest.isInside(testpoint, rectangle)) ? "Inside" : "Not inside";
        System.out.println(answer);
    }
}
