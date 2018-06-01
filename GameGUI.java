 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JTextField;

public class GameGUI extends JFrame {
	public static JPanel contentPane;
	JTextField input_numPlayers;
	public GamePanel gameArea = new GamePanel(this);

	Label Player_Number, Player1_Label, Player2_Label;
	JButton start, set, drop1, drop2, drop3, drop4, drop5, drop6, drop7, drop8, drop9, drop10;

	boolean HvsC = false, HvsH = false, play = false, turn_1 = false, turn_2 = false, turn_C = false;
	int y_max, y1M = 520, y2M = 520, y3M = 520, y4M = 520, y5M = 520, y6M = 520, y7M = 520, y8M = 520, y9M = 520,
			y10M = 520, y0 = -85;
	int[][] grid = new int[20][20];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.setResizable(false);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameGUI() {
		setTitle("Connect 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 915, 725);
		contentPane = new JPanel();

		setResizable(true);
		setVisible(true);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Panel Control_Panel = new Panel();
		contentPane.add(Control_Panel, BorderLayout.NORTH);
		Control_Panel.setLayout(new BorderLayout(0, 0));

		Panel GameMode = new Panel();
		Control_Panel.add(GameMode, BorderLayout.NORTH);

		Player_Number = new Label("Number of Players (1-2): ");
		GameMode.add(Player_Number);

		input_numPlayers = new JTextField();
		GameMode.add(input_numPlayers);
		input_numPlayers.setColumns(5);

		set = new JButton("Set");
		set.addActionListener(new ActionDone(this));
		GameMode.add(set);

		Player1_Label = new Label("  Player 1  ");
		Player1_Label.setAlignment(Label.CENTER);
		Player1_Label.setBackground(new Color(30, 144, 255));
		GameMode.add(Player1_Label);

		Player2_Label = new Label("       ???       ");
		Player2_Label.setBackground(new Color(255, 20, 147));
		Player2_Label.setAlignment(Label.CENTER);
		GameMode.add(Player2_Label);

		start = new JButton("Start");
		GameMode.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play = true;
				turn_1 = true;
			}
		});

		Panel Drop_Panel = new Panel();
		Control_Panel.add(Drop_Panel, BorderLayout.SOUTH);

		drop1 = new JButton("Drop");
		Drop_Panel.add(drop1);
		drop1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y1M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 30;
					gameArea.y = y0;
					y_max = y1M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][1] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][1] = 2;
					}
					y1M -= 80;
					gameArea.timer.start();
				} else if (play && y1M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 30;
					gameArea.y = y1M + 35;
					y_max = y1M;
					grid[(y_max - (-40)) / 80][1] = 3;
					y1M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop2 = new JButton("Drop");
		Drop_Panel.add(drop2);
		drop2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y2M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 110;
					gameArea.y = y0;
					y_max = y2M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][2] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][2] = 2;
					}
					y2M -= 80;
					gameArea.timer.start();
				} else if (play && y2M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 110;
					gameArea.y = y2M + 35;
					y_max = y2M;
					grid[(y_max - (-40)) / 80][2] = 3;
					y2M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop3 = new JButton("Drop");
		Drop_Panel.add(drop3);
		drop3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y3M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 190;
					gameArea.y = y0;
					y_max = y3M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][3] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][3] = 2;
					}
					y3M -= 80;
					gameArea.timer.start();
				} else if (play && y3M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 190;
					gameArea.y = y3M + 35;
					y_max = y3M;
					grid[(y_max - (-40)) / 80][3] = 3;
					y3M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop4 = new JButton("Drop");
		Drop_Panel.add(drop4);
		drop4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y4M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 270;
					gameArea.y = y0;
					y_max = y4M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][4] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][4] = 2;
					}
					y4M -= 80;
					gameArea.timer.start();
				} else if (play && y4M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 270;
					gameArea.y = y4M + 35;
					y_max = y4M;
					grid[(y_max - (-40)) / 80][4] = 3;
					y4M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop5 = new JButton("Drop");
		Drop_Panel.add(drop5);
		drop5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y5M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 350;
					gameArea.y = -85;
					y_max = y5M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][5] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][5] = 2;
					}
					y5M -= 80;
					gameArea.timer.start();
				} else if (play && y5M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 350;
					gameArea.y = y5M + 35;
					y_max = y5M;
					grid[(y_max - (-40)) / 80][5] = 3;
					y5M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop6 = new JButton("Drop");
		Drop_Panel.add(drop6);
		drop6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y6M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 430;
					gameArea.y = y0;
					y_max = y6M;
					if (turn_1) {
						grid[(y_max + 40) / 80][6] = 1;
					} else if (turn_2) {
						grid[(y_max + 40) / 80][6] = 2;
					}
					y6M -= 80;
					gameArea.timer.start();
				} else if (play && y6M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 430;
					gameArea.y = y6M + 35;
					y_max = y6M;
					grid[(y_max - (-40)) / 80][6] = 3;
					y6M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop7 = new JButton("Drop");
		Drop_Panel.add(drop7);
		drop7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y7M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 510;
					gameArea.y = y0;
					y_max = y7M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][7] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][7] = 2;
					}
					y7M -= 80;
					gameArea.timer.start();
				} else if (play && y7M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 510;
					gameArea.y = y7M + 35;
					y_max = y7M;
					grid[(y_max - (-40)) / 80][7] = 3;
					y7M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop8 = new JButton("Drop");
		Drop_Panel.add(drop8);
		drop8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y8M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 590;
					gameArea.y = y0;
					y_max = y8M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][8] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][8] = 2;
					}
					y8M -= 80;
					gameArea.timer.start();
				} else if (play && y8M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 590;
					gameArea.y = y8M + 35;
					y_max = y8M;
					grid[(y_max - (-40)) / 80][8] = 3;
					y8M -= 80;
					gameArea.timer.start();
				}
			}
		});
		drop9 = new JButton("Drop");
		Drop_Panel.add(drop9);
		drop9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y9M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 670;
					gameArea.y = y0;
					y_max = y9M;
					if (turn_1) {
						grid[(y_max - (-40)) / 80][9] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][9] = 2;
					}
					y9M -= 80;
					gameArea.timer.start();
				} else if (play && y9M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 670;
					gameArea.y = y9M + 35;
					y_max = y9M;
					grid[(y_max - (-40)) / 80][9] = 3;
					y9M -= 80;
					gameArea.timer.start();
				}
			}
		});

		drop10 = new JButton("Drop");
		Drop_Panel.add(drop10);
		drop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (play && y10M > -40 && !turn_C) {
					gameArea.x = gameArea.Board.x + 750;
					gameArea.y = y0;
					y_max = y10M;
					if (turn_1) {
						grid[(y_max + 40) / 80][10] = 1;
					} else if (turn_2) {
						grid[(y_max - (-40)) / 80][10] = 2;
					}
					y10M -= 80;
					gameArea.timer.start();
				} else if (play && y10M > -40 && turn_C) {
					gameArea.x = gameArea.Board.x + 750;
					gameArea.y = y10M + 35;
					y_max = y10M;
					grid[(y_max - (-40)) / 80][10] = 3;
					y10M -= 80;
					gameArea.timer.start();
				}
			}
		});

		contentPane.add(gameArea, BorderLayout.CENTER);
		gameArea.setBackground(Color.WHITE);
		gameArea.setVisible(true);
	}
}

class ActionDone implements ActionListener {
	private GameGUI player;

	public ActionDone(GameGUI g) {
		player = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String players = player.input_numPlayers.getText();
			if (players.equals("1")) {
				String numplayers = "Computer";

				player.Player2_Label.setText(numplayers);
				player.HvsC = true;
				player.HvsH = false;
			} else {
				String numplayers = "PLayer 2";
				player.Player2_Label.setText(numplayers);
				player.HvsH = true;
				player.HvsC = false;
			}
		} catch (NumberFormatException e1) {
			String numplayers = "Not a Number, try again.";
			player.Player_Number.setText(numplayers);
		}
	}
}