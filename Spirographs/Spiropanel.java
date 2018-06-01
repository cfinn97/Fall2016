import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Spiropanel extends JPanel implements MouseListener {
	static final int MAX = 100;
	CenteredTrochoid[] spiral = new CenteredTrochoid[MAX];
	static final Color c = Color.WHITE;
	int count = 0;
	int xcll, ycll, Rcll, rcll, pcll, color;
	// final static boolean run = true; // never changes; don't need

	// calling GUI
	private static SpiroGUI enclosingWin;
	boolean mouse = false;

	public Spiropanel(SpiroGUI s) {
		super();
		enclosingWin = s;
		this.addMouseListener(this);
		// add onto this JPanel a listener for mouse events
		// (because the listener is also this JPanel object, we add
		// **this**)
	}

	// have to include all mouse events, BUT don't need to use all of them
	@Override
	public void mouseClicked(MouseEvent e) {
		if (mouse == true) {
			xcll = e.getX();
			ycll = e.getY();
			String R_cll = enclosingWin.inRcll.getText();
			String r_cll = enclosingWin.inrcll.getText();
			String p_cll = enclosingWin.inpcll.getText();
			String cll = enclosingWin.incll.getText();

			try {
				Rcll = Integer.parseInt(R_cll);
				rcll = Integer.parseInt(r_cll);
				pcll = Integer.parseInt(p_cll);
				color = Integer.parseInt(cll);

				if (enclosingWin.drawOn == true) {
					if (enclosingWin.drawEpitrochoid == true) {
						spiral[count] = new Epitrochoid(xcll, ycll, Rcll, rcll, pcll, colorOf(color));
					} else if (enclosingWin.drawHypotrochoid == true) {
						spiral[count] = new Hypotrochoid(xcll, ycll, Rcll, rcll, pcll, colorOf(color));
					}
					count = count + 1;
				} else {
					count = 0;
				}
				enclosingWin.repaint();
			} catch (NumberFormatException exc) {
			}
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouse = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouse = false;
	}

	public static Color colorOf(int color) {
		switch (color) {
		case 0: {
			return Color.BLUE;
		}
		case 1: {
			return new Color(135, 206, 250);
		} // light blue
		case 2: {
			return new Color(25, 25, 112);
		} // midnight blue
		case 3: {
			return Color.GREEN;
		}
		case 4: {
			return new Color(0, 250, 154);
		} // sea green
		case 5: {
			return new Color(0, 100, 0);
		} // dark green
		case 6: {
			return Color.ORANGE;
		}
		case 7: {
			return new Color(255, 20, 147);
		} // pink
		case 8: {
			return new Color(128, 0, 128);
		} // purple
		case 9: {
			return Color.RED;
		}
		default: {
			return Color.BLACK;
		}
		}
	}

	protected void paintComponent(Graphics g) {
		// calls and gives class access to paintComponent
		super.paintComponent(g);
		// if (run == false) {
		// for (int i = 0; i < MAX; i++) {
		// g.setColor(c);
		// g.fillRect(0, 0, getWidth(), getHeight());
		// CenteredTrochoid drawA = spiral[i];
		// drawA.draw(g);
		// }
		// } else not needed, reason: no idea
		// if (run == true) {
		for (int i = 0; i < count; i++) {
			CenteredTrochoid drawA = spiral[i];
			drawA.draw(g);
			System.out.println("CHECK"); // unrelated to project
			// }
		}
	}
}
