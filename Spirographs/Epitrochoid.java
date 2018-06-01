import java.awt.*;

public class Epitrochoid extends CenteredTrochoid{
  public Epitrochoid(int x, int y, int R, double r, double p, Color clr){
    super(x, y, R);
    this.r = r;
    this.penR = p;
    this.color = clr;
  }
  public void draw(Graphics g){
    
    double t = 0.0;
    double incr = 0.01;
    double period = period (fixedRingR, r);
    
    double xp, yp;
    g.setColor(color);
    
    while(t < period){
      xp = cx + ((fixedRingR + r)*Math.cos(t) - penR*Math.cos(((fixedRingR + r)/r) * t));
      yp = cy + ((fixedRingR + r)*Math.sin(t) - penR*Math.sin(((fixedRingR + r)/r) * t));
      
      g.fillOval((int)xp, (int)yp, point, point);     
      t = t + incr;
    }
  }
}