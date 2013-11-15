// 6 More on points
// Write a program in which you create and use a class called Point, with two 
// fields of type double (e.g. x, y) and the following methods:

// distanceTo(Point): calculates the distance to another point.


// Two methods in a class can have the same name (identifier) as long as their 
// parameters are different. This is called method overloading and we will see 
// more of that in the future.

import java.math.*;

public class MoreOnPoints {
    class Point {
        Double x;
        Double y;
        
        Point(Double xIn, Double yIn) {
            x = xIn;
            y = yIn;
        }
        
        Double distanceTo(Point p) {
            // a^2 = b^2 + c^2
            // 
            //        3,4
            //       /|
            //   0,0/ |3,0
            //   5 = ( (3-0)^2 + (4-0)^2) )^(1/2)
            
            // can we access attributes as follows?
            // System.out.println(p.x);
            Double aSquared = Math.pow(Math.abs(this.x - p.x), 2.0);
            Double bSquared = Math.pow(Math.abs(this.y - p.y), 2.0);     
            Double c = Math.pow(aSquared + bSquared, 0.5);
            // System.out.println("yoda " + aSquared);

            return c;
        }

	Double distanceToOrigin() {
  // distanceToOrigin(): calculates the distance to the origin. 
  // Implement it by calling distanceTo().

    MoreOnPoints session = new MoreOnPoints();
    MoreOnPoints.Point origin = session.new Point(0.0,0.0);
    return this.distanceTo(origin);
     	
	}

  void moveTo(double x, double y) {
    // moveTo(double x, double y): changes the coordinates of this point to be the 
    //  given parameters x and y.
      this.x = x;
      this.y = y;
  }

  // returns a copy of the current point with the same coordinates. 
  public Point myClone() {
    MoreOnPoints m = new MoreOnPoints();
    MoreOnPoints.Point c = m.new Point(this.x,this.y);
    return c;
  }

// moveTo(Point): changes the coordinates of this point to move where the given point is.
  void moveTo(Point p) {
    this.x = p.x;
    this.y = p.y;
  } 
    
    }
    public void launch(MoreOnPoints session) {
        MoreOnPoints.Point point1 = session.new Point(3.0,4.0); 
        // MoreOnPoints.Point point2 = session.new Point(5.0,4.0);
        // System.out.println(point2.x);
        // System.out.println(point1.distanceTo(point2));
        // System.out.println(point1.distanceToOrigin());
        // point1.moveTo(point2);
        Point c = point1.myClone();
        System.out.println(c.x);
    }
      
    public static void main(String[] args) {
        MoreOnPoints session = new MoreOnPoints();
        session.launch(session);
    }
}