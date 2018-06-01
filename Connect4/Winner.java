import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Winner extends JPanel implements ActionListener {
	String name = "Winner is ", W;
	private Container contain;
	private JFrame win;
	public JButton ReplayButton;

	public Winner(String W) {
		this.W = W;
		win = new JFrame("Winner Screen");
		win.setBackground(Color.WHITE);

		ReplayButton = new JButton("Replay");
		ReplayButton.setForeground(Color.CYAN);
		ReplayButton.setFont(new Font("American Typewriter", Font.PLAIN, 40));
		ReplayButton.setBounds((int) 357.5, (int) 312.5, 200, 100);
		ReplayButton.addActionListener(this);

		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = win.getContentPane();
		this.setLayout(null);
		this.add(ReplayButton);

		contain.add(this);
		this.setPreferredSize(new Dimension(915, 725)); 
		win.pack();
		win.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setFont(new Font("American Typewriter", Font.BOLD, 50));
		g.setColor(Color.RED);
		g.drawString(name, (int) 317.5, (int) 131.25);
		g.drawString(W, (int) 317.5, (int) 231.25);
	}

	public static void main(String[] args) {
		new Winner(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == ReplayButton) {
			GamePanel.game.dispose();
			new GameGUI();
			this.win.dispose();
		}
	}
}
