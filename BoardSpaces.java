import java.awt.*;


public class BoardSpaces {
	int x, y, dx;
	static Color call = Color.WHITE;
	static PlayerPiece[][] space = new PlayerPiece[7][10];

	public BoardSpaces(int xval, int yval) {
		this.x = xval;
		this.y = yval;
		this.dx = 80;
	}

	public void draw(Graphics g) {
		for (int row = 0; row < space.length; row++) {
			for (int col = 0; col < space[row].length; col++) {
				space[row][col] = new PlayerPiece(x + 30 + col * dx, y + 40 + row * dx, call);
				space[row][col].paint(g);
			}
		}
	}
}
