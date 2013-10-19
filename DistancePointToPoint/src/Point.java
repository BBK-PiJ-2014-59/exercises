// class Point {
//   double x;
//   double y;
// }

public class Point {
    double x;
    double y;
    
    public Point(double xIn, double yIn) {
        x = xIn;
        y = yIn;
    }
    
    public double distance(Point p2) {
        double a = p2.getx() - x;
        double b = p2.gety() - y;
        double c = Math.pow((Math.pow(a, 2) + Math.pow(b, 2)), 0.5);
        System.out.println(a + " " + b + " " + c);
        return c;
    }
    
    private double getx() {
        return this.x;
    }
    
    private double gety() {
        return this.y;
    }
}