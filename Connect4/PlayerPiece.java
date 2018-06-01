import java.awt.*;

public class PlayerPiece {
	public int px, py, pieceRadius = 50;
	Color color;

	public PlayerPiece(int x, int y, Color c) {
		this.px = x;
		this.py = y;
		this.color = c;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(px, py, pieceRadius, pieceRadius);
	}

}
