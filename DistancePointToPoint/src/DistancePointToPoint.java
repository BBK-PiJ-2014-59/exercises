// 12 Distance point–to–point
// Write a program that reads the X and Y coordinates of three points and then
// outputs which of the three are closer.
// Use the following class to store the data for the points:
// class Point {
//   double x;
//   double y;
// }

public class DistancePointToPoint {
    public static void main(String[] args) {
        double x1, x2, x3, y1, y2, y3;
        x1 = 1.0;
        y1 = -5.0;
        x2 = 3.0;
        y2 = 20.0;
        x3 = -2.0;
        y3 = -10.0;
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        double p1p2 = p1.distance(p2);
        double p2p3 = p2.distance(p3);
        double p3p1 = p3.distance(p1);
        String answer;
        if (p1p2 > p2p3 && p1p2 > p3p1) {
            answer = "p1p2";
        } else if (p2p3 > p1p2 && p2p3 > p3p1) {
            answer = "p2p3";
        } else if (p3p1 > p2p3 && p3p1 > p1p2) {
            answer = "p3p1";
        } else {
            answer = "At least two distances are the same.";
        }
        System.out.println(answer);
    }
}