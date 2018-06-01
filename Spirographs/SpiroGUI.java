import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class SpiroGUI extends JFrame {
	static final int MAX = 100;
	// call display Control_Panel (SpiroControl_Panel); this: so that it knows where it is being called

	public Spiropanel DrawPanel = new Spiropanel(this);

	static final Color c = Color.WHITE;
	
	JTextField inRcll;
	JTextField inrcll;
	JTextField inpcll;
	JTextField incll;

	boolean drawEpitrochoid = false;
	boolean drawHypotrochoid = false;
	//to turn on/determine which spiral to draw

	boolean drawOn = false;
	// draw or clear boolean

	public JPanel contentPane;
	JButton Clear;
	JButton Draw;
	JToggleButton spiralE;
	JToggleButton spiralH;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpiroGUI window = new SpiroGUI();
					window.setResizable(true);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public SpiroGUI() {
		setTitle("Spirals");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		//first Control_Panel holding control and display Control_Panels

		setResizable(true);
		setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel Control_Panel = new JPanel();
		contentPane.add(Control_Panel, BorderLayout.NORTH);
		Control_Panel.setLayout(new BorderLayout(0, 0));

		JPanel Control_Panel_2 = new JPanel();
		Control_Panel.add(Control_Panel_2, BorderLayout.CENTER);
		Control_Panel_2.setLayout(new BorderLayout(0, 0));

		Panel ButtonPanel = new Panel();
		Control_Panel_2.add(ButtonPanel, BorderLayout.WEST);
		ButtonPanel.setLayout(new BorderLayout(0, 0));

		JPanel Choicecll = new JPanel();
		ButtonPanel.add(Choicecll, BorderLayout.NORTH);

		JButton Clear = new JButton("Clear");
		Choicecll.add(Clear);
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawOn = false;
			}
		});

		Draw = new JButton("Draw");
		Draw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawOn = true;
			}
		});
		Choicecll.add(Draw);

		JPanel spiralcll = new JPanel();
		ButtonPanel.add(spiralcll, BorderLayout.SOUTH);

		spiralE = new JToggleButton("Epitrochoid");
		spiralcll.add(spiralE);

		spiralH = new JToggleButton("Hypotrochoid");
		spiralcll.add(spiralH);
		spiralH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//code so that when you unclick button, spiral type is no longer being called
				if (drawHypotrochoid == true) {
					drawHypotrochoid = false;
				} else {
					drawHypotrochoid = true;
				}
			}
		});
		spiralE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code so that when you unclick button, spiral type is no longer being called
				if (drawEpitrochoid == true) {
					drawEpitrochoid = false;
				} else {
					drawEpitrochoid = true;
				}
			}
		});

		Panel textfieldPanel = new Panel();
		// Control_Panel, NOT JPanel
		Control_Panel_2.add(textfieldPanel, BorderLayout.CENTER);
		textfieldPanel.setLayout(new BorderLayout(0, 0));

		Panel penColor = new Panel();
		textfieldPanel.add(penColor, BorderLayout.EAST);
		penColor.setLayout(new GridLayout(5, 2, 0, 0));

		Label Blue = new Label("0");
		Blue.setAlignment(Label.CENTER);
		Blue.setBackground(Color.BLUE);
		Blue.setForeground(Color.WHITE);
		penColor.add(Blue);

		Label Light_Blue = new Label("1");
		Light_Blue.setAlignment(Label.CENTER);
		Light_Blue.setBackground(new Color(135, 206, 250));
		Light_Blue.setForeground(new Color(0, 0, 0));
		penColor.add(Light_Blue);

		Label Dark_Blue = new Label("2");
		Dark_Blue.setAlignment(Label.CENTER);
		Dark_Blue.setBackground(new Color(25, 25, 112));
		Dark_Blue.setForeground(new Color(255, 255, 255));
		penColor.add(Dark_Blue);

		Label Green = new Label("3");
		Green.setAlignment(Label.CENTER);
		Green.setBackground(Color.GREEN);
		Green.setForeground(Color.BLACK);
		penColor.add(Green);

		Label Light_Green = new Label("4");
		Light_Green.setAlignment(Label.CENTER);
		Light_Green.setBackground(new Color(0, 255, 153));
		Light_Green.setForeground(Color.WHITE);
		penColor.add(Light_Green);

		Label Dark_Green = new Label("5");
		Dark_Green.setBackground(new Color(0, 100, 0));
		Dark_Green.setAlignment(Label.CENTER);
		Dark_Green.setForeground(new Color(0, 0, 0));
		penColor.add(Dark_Green);

		Label Orange = new Label("6");
		Orange.setAlignment(Label.CENTER);
		Orange.setBackground(Color.ORANGE);
		Orange.setForeground(Color.WHITE);
		penColor.add(Orange);

		Label Pink = new Label("7");
		Pink.setForeground(new Color(0, 0, 0));
		Pink.setBackground(new Color(255, 20, 147));
		Pink.setAlignment(Label.CENTER);
		penColor.add(Pink);

		Label Purple = new Label("8");
		Purple.setAlignment(Label.CENTER);
		Purple.setBackground(new Color(128, 0, 128));
		Purple.setForeground(new Color(255, 255, 255));
		penColor.add(Purple);

		Label Red = new Label("     9     ");
		Red.setAlignment(Label.CENTER);
		Red.setBackground(new Color(255, 0, 0));
		Red.setForeground(new Color(0, 0, 0));
		penColor.add(Red);

		Panel textfield = new Panel();
		textfieldPanel.add(textfield, BorderLayout.CENTER);
		textfield.setLayout(new BoxLayout(textfield, BoxLayout.X_AXIS));

		//Label, NOT JLabel
		Label Player_Number = new Label("R r p pen-color");
		Player_Number.setAlignment(Label.CENTER);
		textfield.add(Player_Number);

		inRcll = new JTextField();
		inrcll = new JTextField();
		inpcll = new JTextField();
		incll = new JTextField();
		textfield.add(inRcll);
		textfield.add(inrcll);
		textfield.add(inpcll);
		textfield.add(incll);
		
		//calling the SpiroControl_Panel DrawPanel & adding to window
		contentPane.add(DrawPanel, BorderLayout.CENTER);

		DrawPanel.setBackground(Color.WHITE);
		DrawPanel.setVisible(true);
	}
}
