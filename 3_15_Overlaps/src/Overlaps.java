// 15 Overlaps
// Write a program that reads the coordinates of four point points, the former
// two defining one rectangle and the latter two defining another one. The 
// program must read the coordinates of a fifth point and say whether the 
// point is inside both rectangles, inside one of them only, or out of both.

public class Overlaps {
    Rectangle r1, r2;
    TestPoint testpoint;
    
    public String isInside(TestPoint testp, Rectangle rect1, Rectangle rect2) {
        Point tp = testp.getTestPoint();
        double tpx = tp.getx();
        double tpy = tp.gety();
        
        Point r1p1 = rect1.getP1();
        Point r1p2 = rect1.getP2();
        double r1p1x = r1p1.getx();
        double r1p1y = r1p1.gety();
        double r1p2x = r1p2.getx();
        double r1p2y = r1p2.gety();
        
        Point r2p1 = rect2.getP1();
        Point r2p2 = rect2.getP2();
        double r2p1x = r2p1.getx();
        double r2p1y = r2p1.gety();
        double r2p2x = r2p2.getx();
        double r2p2y = r2p2.gety();        
        
        boolean inr1;
        if (isBetween(tpx, r1p1x, r1p2x) && isBetween(tpx, r1p1y, r1p2y)) {
            inr1 = true;
        } else {
            inr1 = false;
        }

        boolean inr2;
        if (isBetween(tpx, r2p1x, r2p2x) && isBetween(tpx, r2p1y, r2p2y)) {
            inr2 = true;
        } else {
            inr2 = false;
        }        
        
        String answer;
        if (inr1 && inr2) {
            answer = "Inside both";
        } else if (inr1) {
            answer = "In rectangle one only.";
        } else if (inr2) {
            answer = "In rectangle two only.";
        } else {
            answer = "In neither";
        }
        
        return answer;
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
            System.out.println("Enter x for " + desc + ": ");
            double in = Double.parseDouble(System.console().readLine());
            setx(in);
            System.out.println("Enter y for " + desc + ": ");
            in = Double.parseDouble(System.console().readLine());
            sety(in);
        }
    }
        
    public static void main(String[] args) {
        Overlaps pointTest = new Overlaps();
        // OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        Overlaps.Rectangle rectangle1 = pointTest.new Rectangle();
        Overlaps.Rectangle rectangle2 = pointTest.new Rectangle();        
        rectangle1.getP1FromUser();
        rectangle1.getP2FromUser();
        rectangle2.getP1FromUser();
        rectangle2.getP2FromUser();
        Overlaps.TestPoint testpoint = pointTest.new TestPoint();  
        testpoint.getTestPointFromUser();
        String answer = (pointTest.isInside(testpoint, rectangle1, rectangle2));
        System.out.println(answer);
    }
}