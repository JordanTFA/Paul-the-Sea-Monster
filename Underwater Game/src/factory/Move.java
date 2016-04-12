package factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Move implements ActionListener
{
	public void actionPerformed(ActionEvent arg0)
	{
		Board m = Board.getInstance();
		Random random = new Random();
		int pickEnemy,rollEnemy;
		String name = null;
		WaterInstance Swordfish = new Swordfish();
		WaterInstance Diver = new Diver();
		WaterInstance Dolphin = new Dolphin();
		Enemies Enemy = new Enemies();

		//If user press enter make random variable for the enemies spawning
		pickEnemy =  random.nextInt(3);
		rollEnemy = random.nextInt(3);

		if(rollEnemy == 0)
		{
			if(pickEnemy == 0)
			{
				name = Swordfish.getName();
			}
			if(pickEnemy == 1)
			{
				name = Diver.getName();
			}
			if(pickEnemy == 2)
			{
				name = Dolphin.getName();
			}

			//add the new enemy to the map and gives them a observer id       		
			Enemy.playGame(name);

			Enemies Monster = new Enemies();
			Monster.addToBoard(name);
			Monster.playGame(name);

			for( int i = 0; i< m.getX(); i++)
			{
				for( int j = 0; j< m.getY(); j++)
				{
					if(m.getGrid()[i][j]== name)
					{
						System.out.println(name +" Position: " + (i + 1) + "," + (j + 1)+ "\n");
					}
				}
			}
		}

		Runnable monster = new cMovement();

		monster.run();

		oDisplay observer = new oDisplay();
		oEnemy eo = new oEnemy(observer);
		observer.register(eo);

		eo.update(m.getX(), m.getY());
		pickEnemy =  random.nextInt(3);
		SizeSelect update = new SizeSelect();

		update.Ocean();
	}
}