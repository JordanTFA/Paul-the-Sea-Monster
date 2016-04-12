package factory;

import java.util.Arrays;
import javax.swing.ImageIcon;

// The board that the user uses to play
public class Board
{		
	// Tiles
	ImageIcon water = new ImageIcon("../Underwater Game/src/img/Water-128.png");			// Default icon
	ImageIcon Fight1 = new ImageIcon("../Underwater Game/src/img/128-Fight1.png");		// Sea Monster is fighting 1 enemy
	ImageIcon Fight2 = new ImageIcon("../Underwater Game/src/img/128-Fight2.png");		// Sea Monster is fighting 2 enemies (AKA Dead)

	public ImageIcon getMonsterVs2()
	{
		return Fight2;
	}

	public ImageIcon getMonsterVs1()
	{
		return Fight1;
	}

	public ImageIcon getWater()
	{
		return water;
	}
	

	// A maximum grid size of 5x5 is hardcoded
	// This means it's not FULLY variable
	// Users can set grids lower, but the characters
	// Can go out of bounds if they feel like it.
	private int X = 10;
	private int Y = 10;
	private String[][] grid = new String[X][Y]; ;
	private static Board instance = null;

	public static Board getInstance()
	{
		if(instance == null)
		{
			instance = new Board();
		}
		return instance;
	}

	public Board()
	{
		this.grid = Arrays.copyOf(grid, grid.length);
	}

	public int getY()
	{
		return Y;
	}

	public void setY(int y)
	{
		Y = y;
	}

	public int getX()
	{
		return X;
	}

	public void setX(int x)
	{
		X = x;
	}

	public String[][] getGrid()
	{
		return Arrays.copyOf(grid, grid.length);
	}
	
}