package factory;

import java.util.Random;
import javax.swing.ImageIcon;

//Class for Seamonster
public class SeaMonster extends WaterInstance
{
	ImageIcon monsterTile = new ImageIcon("../Underwater Game/src/img/128-SeaMonster.png");

	public ImageIcon getMonster()
	{
		return monsterTile;
	}

	public void setMonster(ImageIcon monster)
	{
		monsterTile = monster;
	}

	public SeaMonster()
	{
		this.setName("Paul");
	}

	public void obJectInfo()
	{
		Random random = new Random();
		Board m = Board.getInstance();
		int randRow = random.nextInt(m.getX());
		int randColumn = random.nextInt(m.getY());

		//Paul is put on a space which is not located in the top left corner
		while (randRow == 0 || randColumn == 0)
		{
			randRow = random.nextInt(m.getX());
			randColumn = random.nextInt(m.getY());
		}

		if (randRow > 0 || randColumn > 0)
		{
			System.out.println("Paul's Position: " + (randRow + 1) + "," + (randColumn + 1));
			m.getGrid()[randRow][randColumn] = "Paul";
		}
	}
}