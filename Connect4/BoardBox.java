import java.awt.*;


public class BoardBox {
	int x, y;

	public BoardBox(int xval, int yval) {
		this.x = xval;
		this.y = yval;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 825, 580);
	}
}
