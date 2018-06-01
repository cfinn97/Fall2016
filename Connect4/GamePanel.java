import javax.swing.JPanel;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

	static final int MAX = 70;
	static final Color c1 = new Color(30, 144, 255), c2 = new Color(255, 20, 147);
	static GameGUI game;
	
	Color pieceColor;
	BoardBox box = new BoardBox(40, 35);
	BoardSpaces Board = new BoardSpaces(box.x, box.y);
	PlayerPiece[] PP = new PlayerPiece[MAX];
	Timer timer = new Timer(120, this);

	int count = 0, dy = 80, x, y;

	public GamePanel(GameGUI gm) {
		super();
		game = gm;
	}

	protected void paintComponent(Graphics a) {
		super.paintComponent(a);
		box.draw(a);
		Board.draw(a);

		if (count % 2 == 0) {
			game.turn_1 = true;
			game.turn_2 = false;
			game.turn_C = false;
			pieceColor = c1;
		} else {
			if (game.HvsH == true) {
				game.turn_1 = false;
				game.turn_2 = true;
			} else if (game.HvsC == true) {
				double choose = Math.random() * 10;
				int l = 0;
				game.turn_1 = false;
				game.turn_C = true;
				while (l < 1) {
					System.out.println("choosing");
					if (choose <= 1) {
						if (game.y1M > -40) {
							game.drop1.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 2) {
						if (game.y2M > -40) {
							game.drop2.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 3) {
						if (game.y3M > -40) {
							game.drop3.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 4) {
						if (game.y4M > -40) {
							game.drop4.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 5) {
						if (game.y5M > -40) {
							game.drop5.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 6) {
						if (game.y6M > -40) {
							game.drop6.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 7) {
						if (game.y7M > -40) {
							game.drop7.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 8) {
						if (game.y8M > -40) {
							game.drop8.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else if (choose <= 9) {
						if (game.y9M > -40) {
							game.drop9.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					} else {
						if (game.y10M > -40) {
							game.drop10.doClick();
							l++;
						} else {
							choose = Math.random() * 10;
							l = 0;
						}
					}
				}
			}
			pieceColor = c2;
		}

		PP[count] = new PlayerPiece(x, y, pieceColor);
		PP[count].paint(a);
		for (int j = 0; j < count; j++) {
			PlayerPiece drawPiece = PP[j];
			drawPiece.paint(a);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (y < game.y_max) {
			y += 80;
			game.repaint();
		} else {
			timer.stop();
			int winner = testForWinner();
			if (winner == 1) {
				game.play = false;
				String w = "Player 1";
				new Winner(w);
			} else if (winner == 2) {
				game.play = false;
				String w = "Player 2";
				new Winner(w);
			} else if (winner == 3) {
				game.play = false;
				String w = "Computer";
				new Winner(w);
			}
			count += 1;
			x = 0; y = 0;
		}
		repaint();
	}

	public int testForWinner() {
		// Check for vertical win
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (game.grid[i][j] == 1 && game.grid[i + 1][j] == 1 && game.grid[i + 2][j] == 1
						&& game.grid[i + 3][j] == 1) {
					return 1;
				} else if (game.grid[i][j] == 2 && game.grid[i + 1][j] == 2 && game.grid[i + 2][j] == 2
						&& game.grid[i + 3][j] == 2) {
					return 2;
				} else if (game.grid[i][j] == 3 && game.grid[i + 1][j] == 3 && game.grid[i + 2][j] == 3
						&& game.grid[i + 3][j] == 3) {
					return 3;
				}
			}
		}
		
		// Check for Diagonal win
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (game.grid[i][j] == 1 && game.grid[i + 1][j + 1] == 1 && game.grid[i + 2][j + 2] == 1
						&& game.grid[i + 3][j + 3] == 1) {
					return 1;
				} else if (game.grid[i][j] == 1 && game.grid[i + 1][j - 1] == 1 && game.grid[i + 2][j - 2] == 1
						&& game.grid[i + 3][j - 3] == 1) {
					return 1;
				} else if (game.grid[i][j] == 2 && game.grid[i + 1][j + 1] == 2 && game.grid[i + 2][j + 2] == 2
						&& game.grid[i + 3][j + 3] == 2) {
					return 2;
				} else if (game.grid[i][j] == 2 && game.grid[i + 1][j - 1] == 2 && game.grid[i + 2][j - 2] == 2
						&& game.grid[i + 3][j - 3] == 2) {
					return 2;
				} else if (game.grid[i][j] == 3 && game.grid[i + 1][j + 1] == 3 && game.grid[i + 2][j + 2] == 3
						&& game.grid[i + 3][j + 3] == 3) {
					return 3;
				} else if (game.grid[i][j] == 3 && game.grid[i + 1][j - 1] == 3 && game.grid[i + 2][j - 2] == 3
						&& game.grid[i + 3][j - 3] == 3) {
					return 3;
				}
			}
		}

		// Check for Horizontal wins
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (game.grid[i][j] == 1 && game.grid[i][j + 1] == 1 && game.grid[i][j + 2] == 1
						&& game.grid[i][j + 3] == 1) {
					return 1;
				} else if (game.grid[i][j] == 2 && game.grid[i][j + 1] == 2 && game.grid[i][j + 2] == 2
						&& game.grid[i][j + 3] == 2) {
					return 2;
				} else if (game.grid[i][j] == 3 && game.grid[i][j + 1] == 3 && game.grid[i][j + 2] == 3
						&& game.grid[i][j + 3] == 3) {
					return 3;
				}
			}
		}
		
		// Check for self-designing wins
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (game.grid[i][1] == 1 && game.grid[i][8] == 1 && game.grid[i][9] == 1 && game.grid[i][10] == 1) {
					return 1;
				} else if (game.grid[i][1] == 1 && game.grid[i][2] == 1 && game.grid[i][9] == 1
						&& game.grid[i][10] == 1) {
					return 1;
				} else if (game.grid[i][1] == 1 && game.grid[i][2] == 1 && game.grid[i][3] == 1
						&& game.grid[i][10] == 1) {
					return 1;
				}
				if (game.grid[i][1] == 2 && game.grid[i][8] == 2 && game.grid[i][9] == 2 && game.grid[i][10] == 2) {
					return 2;
				} else if (game.grid[i][1] == 2 && game.grid[i][2] == 2 && game.grid[i][9] == 2
						&& game.grid[i][10] == 2) {
					return 2;
				} else if (game.grid[i][1] == 2 && game.grid[i][2] == 2 && game.grid[i][3] == 2
						&& game.grid[i][10] == 2) {
					return 2;
				}
				if (game.grid[i][1] == 3 && game.grid[i][8] == 3 && game.grid[i][9] == 3 && game.grid[i][10] == 3) {
					return 3;
				} else if (game.grid[i][1] == 3 && game.grid[i][2] == 3 && game.grid[i][9] == 3
						&& game.grid[i][10] == 3) {
					return 3;
				} else if (game.grid[i][1] == 3 && game.grid[i][2] == 3 && game.grid[i][3] == 3
						&& game.grid[i][10] == 3) {
					return 3;
				}
			}
		}
		return 0;
	}
}
