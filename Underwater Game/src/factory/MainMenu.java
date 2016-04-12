package factory;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Image;
import java.io.File;
import java.awt.EventQueue;


// Main Menu
public class MainMenu
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					// Start new menu
					MainMenu menu = new MainMenu();
					menu.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	// GUI for Main Menu
	protected JFrame frame;
	protected JPanel panel;
	protected JButton start;
	protected JButton exit;
	
	// Loads the background for the menu
	public class BackgroundImage extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private Image backgroundImage;

		public BackgroundImage(String fileName) throws IOException
		{
			backgroundImage = ImageIO.read(new File(fileName));
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			// Draw the background image.
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}
	
	/* 
	 * Loads the following:
	 * Menu Frame (The entire menu window)
	 * Menu Panel (The panel for the buttons)
	 * New Game Button
	 * Exit Button
	 */
	
	public MainMenu() throws IOException
	{
		Frame();
		Panel();
		newGame();
		Exit();
	}
	
	// Create Frame
	public void Frame()
	{
		frame = new JFrame();														
		frame.setTitle("Underwater");												
		frame.setResizable(false);													
		frame.setBounds(0, 0, 640, 455);//(500, 200, 800, 620);										
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Create Panel
	public void Panel() throws IOException
	{							
		frame.getContentPane().setLayout(null);
		panel = new BackgroundImage("../Underwater Game/src/img/Menu.jpg");					
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 640, 455);
		panel.setLayout(null);																						
		frame.getContentPane().add(panel);
	}
	
	// New Game
	public void newGame()
	{
		// Starts the game
		start = new JButton("New Game");
		start.setBounds(130, 100, 125, 35);																			
		panel.add(start);	

		ActionListener al = new SizeSelect();
		start.addActionListener(al);
	}
	
	// Exit Button
	// This closes the program
	public void Exit()
	{
		exit = new JButton("Exit");
		exit.setBounds(360, 200, 125, 35);																			
		panel.add(exit);	
		
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				System.exit(0);
			}
			
		});
	}
}
