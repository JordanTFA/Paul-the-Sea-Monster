package factory;

import java.util.Random;

public class cMovement implements cIMove, Runnable
{
	Board map = Board.getInstance();
	WaterInstance Paul = new SeaMonster();
	Random random = new Random();

	public void run()
	{
		move();
	}

	public cICommand move()
	{
		monster();
		Swordfish();
		Diver();
		Dolphin();
		return null;
	}

	public boolean monster()
	{
		// randomly determine the moving direction
		// -1 means move left, 1 means move right
		int horizontal_direction = Math.random() > 0.5 ? -1 : 1;
		// -1 means move up, 1 mean move down
		int vertical_direction = Math.random() > 0.5 ? -1 : 1;

		for (int i = 0; i < map.getGrid().length; i++)
		{
			for (int j = 0; j < map.getGrid()[i].length; j++)
			{

				if (map.getGrid()[i][j].equals(Paul.getName()))
				{
					map.getGrid()[i][j] = "water"; // replace Paul's current position with water

					// if the newRow exceeds the boundaries, don't move in that direction
					int newRow = i + horizontal_direction;
					if (newRow < 0 || newRow == map.getGrid().length)
						newRow = i;

					// if the newCol exceeds the boundaries, don't move in that direction
					int newCol = j + vertical_direction;
					if (newCol < 0 || newCol == map.getGrid()[i].length)
						newCol = j;
					if (map.getGrid()[newRow][newCol] == "water")
					{
						map.getGrid()[newRow][newCol] = Paul.getName(); //Move Paul to the new position
						System.out.println(newRow + "     " + newCol);
					}
					else
						map.getGrid()[newRow][newCol] = "MonsterVs1";
					return true;
				}
			}
		}
		return false;
	}

	public boolean Swordfish()
	{
		int horizontal_direction = Math.random() > 0.5 ? -1 : 1;
		// -1 means move up, 1 mean move down
		int vertical_direction = Math.random() > 0.5 ? -1 : 1;

		for (int i = 0; i < map.getGrid().length; i++)
		{
			for (int j = 0; j < map.getGrid()[i].length; j++)
			{

				if (map.getGrid()[i][j].equals("Swordfish"))
				{
					map.getGrid()[i][j] = "water"; // replace Swordfish's current position with water

					// if the newRow exceeds the boundaries, don't move in that direction
					int newRow = i + horizontal_direction;
					if (newRow < 0 || newRow == map.getGrid().length)
						newRow = i;

					// if the newCol exceeds the boundaries, don't move in that direction
					int newCol = j + vertical_direction;
					if (newCol < 0 || newCol == map.getGrid()[i].length)
						newCol = j;

					if (map.getGrid()[newRow][newCol].equals("Swordfish") || map.getGrid()[newRow][newCol].equals("Diver") || map.getGrid()[newRow][newCol].equals("Dolphin"))
					{
						return true;
					}
					else if (map.getGrid()[newRow][newCol] == "water")
					{
						map.getGrid()[newRow][newCol] = "Swordfish"; // move Swordfish to new position
						System.out.println(newRow + "     " + newCol);
						return true;
					}
					else
						return true;
					/*else

						if (map.getGrid()[newRow][newCol] == "MonsterVs1")
						{
							map.getGrid()[newRow][newCol] = "MonsterVs2";
							return true;
						}
						else
							map.getGrid()[newRow][newCol] = "MonsterVs1";
					return true;*/
				}
			}
		}
		return false;
	}

	public boolean Diver()
	{
		int horizontal_direction = Math.random() > 0.5 ? -1 : 1;
		// -1 means move up, 1 mean move down
		int vertical_direction = Math.random() > 0.5 ? -1 : 1;

		for (int i = 0; i < map.getGrid().length; i++)
		{
			for (int j = 0; j < map.getGrid()[i].length; j++)
			{

				if (map.getGrid()[i][j].equals("Diver"))
				{
					map.getGrid()[i][j] = "water"; // replace diver's current position with water

					// if the newRow exceeds the boundaries, don't move in that direction
					int newRow = i + horizontal_direction;
					if (newRow < 0 || newRow == map.getGrid().length)
						newRow = i;

					// if the newCol exceeds the boundaries, don't move in that direction
					int newCol = j + vertical_direction;
					if (newCol < 0 || newCol == map.getGrid()[i].length)
						newCol = j;
					if (map.getGrid()[newRow][newCol].equals("Swordfish") || map.getGrid()[newRow][newCol].equals("Diver") || map.getGrid()[newRow][newCol].equals("Dolphin"))
					{
						return true;
					} else

						if (map.getGrid()[newRow][newCol] == "water")
						{
							map.getGrid()[newRow][newCol] = "Diver"; // move diver to new position
							System.out.println(newRow + "     " + newCol);
						}
						else
							return true;
						/*else if (map.getGrid()[newRow][newCol] == "MonsterVs1")
						{
							map.getGrid()[newRow][newCol] = "MonsterVs2";
							return true;
						}
						else
							map.getGrid()[newRow][newCol] = "MonsterVs1";
					return true;*/
				}
			}
		}
		return false;
	}

	public boolean Dolphin()
	{
		int horizontal_direction = Math.random() > 0.5 ? -1 : 1;
		// -1 means move up, 1 mean move down
		int vertical_direction = Math.random() > 0.5 ? -1 : 1;

		for (int i = 0; i < map.getGrid().length; i++)
		{
			for (int j = 0; j < map.getGrid()[i].length; j++)
			{
				if (map.getGrid()[i][j].equals("Dolphin"))
				{
					map.getGrid()[i][j] = "water"; // replace Dolphin's current position with water

					// if the newRow exceeds the boundaries, don't move in that direction
					int newRow = i + horizontal_direction;
					if (newRow < 0 || newRow == map.getGrid().length)
						newRow = i;

					// if the newCol exceeds the boundaries, don't move in that
					// direction
					int newCol = j + vertical_direction;
					if (newCol < 0 || newCol == map.getGrid()[i].length)
						newCol = j;
					if (map.getGrid()[newRow][newCol].equals("Swordfish") || map.getGrid()[newRow][newCol].equals("Diver") || map.getGrid()[newRow][newCol].equals("Dolphin"))
					{
						return true;
					}
					else
						if (map.getGrid()[newRow][newCol] == "water")
						{
							map.getGrid()[newRow][newCol] = "Dolphin"; // move to new position
							System.out.println(newRow + "     " + newCol);
						}
						else
							return true;
					/*if (map.getGrid()[newRow][newCol] == "MonsterVs1")
					{
						map.getGrid()[newRow][newCol] = "MonsterVs2";
						return true;
					}
					else
						map.getGrid()[newRow][newCol] = "MonsterVs1";
					return true;*/
				}
			}
		}
		return false;
	}
}