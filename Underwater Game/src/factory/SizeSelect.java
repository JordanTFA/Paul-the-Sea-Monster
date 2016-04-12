package factory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//Class that handles starting the game
public class SizeSelect implements ActionListener
{
	//Items needed to draw game window
	protected JFrame Ocean;
	protected JPanel boardSize, grid, actionList;
	protected JTextField Y, X;
	protected JButton move;
	protected JScrollPane map;
	protected ImageIcon icon;
	SeaMonster paulTheMonster = new SeaMonster();

	//Constructor for this class
	public SizeSelect()
	{
		getInputFromUser();
	}
	
	//Prompt the user to enter the desired grid size
	public void getInputFromUser()
	{
		Y = new JFormattedTextField(10);
		X = new JFormattedTextField(10);
		X.setColumns(3);
		Y.setColumns(3);
		Y.setText("");
		X.setText("");
		boardSize = new JPanel();
		boardSize.add(new JLabel(""));
		boardSize.add(Box.createHorizontalStrut(15));
		boardSize.add(new JLabel("Rows:"));
		boardSize.add(Y);
		boardSize.add(Box.createHorizontalStrut(15));
		boardSize.add(new JLabel("Columns:"));
		boardSize.add(X);

	}
	
	//Create the ocean for Paul
	public void Ocean()
	{
		Ocean = new JFrame("Ocean");

		Ocean.setResizable(false);													
		Ocean.setBounds(400, 100, 1000, 900);										
		Ocean.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						
		Ocean.getContentPane().setLayout(new GridLayout(1, 0));

		theBoard();

		Ocean.setVisible(true);
	}
	
	//Generates the map with the positions of the characters in the game
	public void theBoard()
	{
		Board ocean = Board.getInstance();

		JLayeredPane layeredPane = new JLayeredPane();
		Ocean.getContentPane().add(layeredPane);
		
		//Draws button to move the characters
		ActionListener actionButton = new Move();
		move = new JButton("Move");
		move.setBounds(10, 800, 200, 50);
		layeredPane.add(move);
		move.addActionListener(actionButton);
		
		//Creates the grid for the map
		grid = new JPanel();
		grid.setLayout(new GridLayout(((Board) ocean).getY(), ocean.getX()));
		Enemies enemies = new Enemies();
		
		//Add the correct graphics and character to each spot as per the map
		for (int i = 0; i < ocean.getY(); i++)
		{
			for (int n = 0; n < ocean.getX() ; n++)
			{
				if (ocean.getGrid()[i][n] == "monsterVs1")
				{
					grid.add(new JLabel(ocean.getMonsterVs1()));
				}
				if (ocean.getGrid()[i][n] == "water")
				{
					grid.add(new JLabel(ocean.getWater()));
				}
				if (ocean.getGrid()[i][n] == "monsterVs2")
				{
					grid.add(new JLabel(ocean.getMonsterVs2()));
				}
				if (ocean.getGrid()[i][n] == "Paul")
				{
					grid.add(new JLabel(paulTheMonster.getMonster()));
				}
				if (ocean.getGrid()[i][n] == "Swordfish")
				{
					grid.add(new JLabel(enemies.getImage("Swordfish")));
				}
				if (ocean.getGrid()[i][n] == "Diver")
				{
					grid.add(new JLabel( enemies.getImage("Diver")));
				}
				if (ocean.getGrid()[i][n] == "Dolphin") 
				{
					grid.add(new JLabel(enemies.getImage("Dolphin")));
				}
			}
		}
		
		//Creates the pane is which the map is shown
		map = new JScrollPane();
		map = new JScrollPane(grid);
		map.setBounds(24, 27, 700, 700);
		layeredPane.add(map);
	}
	
	//Method for the prompt that asks the user to enter a grid size
	public void actionPerformed(ActionEvent e)
	{
		Board m = Board.getInstance();

		int result = JOptionPane.showConfirmDialog(null, boardSize,"Underwater", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION)
		{
			if (Y.getText().matches("\\d+"))
			{
				m.setY(Integer.parseInt(Y.getText()));
				m.setX(Integer.parseInt(X.getText()));
			}

			if (Y.getText().equals("1") || Y.getText().equals("0"))
			{
				m.setY(4);
			}

			if (X.getText().equals("1") || X.getText().equals("0"))
			{
				m.setX(4);
			}

			WaterInstance characters = new SeaMonster();
			String name = null;

			//Fills array with water as per grid size entered
			for (String[] row: m.getGrid())
			{
				Arrays.fill(row,"water");
			}

			//Generates the characters
			Enemies Monster = new Enemies();
			name = characters.getName();
			Monster.playGame(name);

			//Gives the player an ObserverID
			oDisplay observer = new oDisplay();
			oEnemy eo = new oEnemy(observer);
			observer.register(eo);
			eo.update(m.getY(), m.getX());

			this.Ocean();
		}
	}
}