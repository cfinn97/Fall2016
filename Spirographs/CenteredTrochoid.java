import java.awt.*;

public abstract class CenteredTrochoid {
  
  final double fixedRingR; // The radius of the fixed ring
  final double cx, cy;     // The coordinates of the fixed ring's center
  Color color;          // The color of the curve's drawing pen
  final int point = 6; // radius of points making shape
  double r, penR;
  
  protected CenteredTrochoid(double x, double y, double R) {
    // The "protected" modifier means that only subclasses can use this
    // constructor (which is true anyway, since the class is abstract).
    this.fixedRingR = R;
    this.cx = x;
    this.cy = y;
  }
  protected static double period(double R, double r) {
   
    
    double a = R - r, b = r;
    
  
    
    while (((int) a) != a || ((int) b) != b) {
      // We'll handle roundoff error by keeping a and b to only 5 decimal places
      a = round(a * 10,5);
      b = round(b * 10,5);
    }
    
    return  2*Math.PI*(b/gcd((int) a, (int) b));
  } // period
  
  static double round(double x, int p) {
    // returns the value of x, rounded to the nearest p decimal places
    
    return ((long) ((x + (5 * Math.pow(10,-(p+1))))*Math.pow(10,p))) / Math.pow(10,p);
  }
  
  static int gcd(int a, int b){
    // Returns the greatest common integer divisor of a and b
    // This is based on an algorithm discovered by the ancient Greek
    // mathematician Euclid
    
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
  abstract public void draw(Graphics g);
}