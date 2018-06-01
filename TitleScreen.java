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

public class TitleScreen extends JPanel implements ActionListener {
	private String name = "Connect 4";
	private Container contain;
	private JFrame menue;
	public JButton PlayButton;

	public TitleScreen() {
		menue = new JFrame("Connect 4 Title Screen");
		menue.setBackground(Color.WHITE);

		PlayButton = new JButton("PLAY");
		PlayButton.setForeground(Color.CYAN);
		PlayButton.setFont(new Font("American Typewriter", Font.PLAIN, 40));
		PlayButton.setBounds((int) 357.5, (int) 312.5, 200, 100);
		PlayButton.addActionListener(this);

		menue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contain = menue.getContentPane();
		this.setLayout(null);
		this.add(PlayButton);

		contain.add(this);
		this.setPreferredSize(new Dimension(915, 725));
		menue.pack();
		menue.setVisible(true);
		menue.setResizable(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setFont(new Font("American Typewriter", Font.BOLD, 50));
		g.setColor(Color.RED);
		g.drawString(name, (int) 317.5, (int) 131.25);
	}

	public static void main(String[] args) {
		new TitleScreen();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object object = event.getSource();
		if (object == PlayButton) {
			new GameGUI();
			this.menue.dispose();
		}
	}
}