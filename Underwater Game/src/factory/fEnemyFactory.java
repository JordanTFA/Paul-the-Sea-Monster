package factory;

public class fEnemyFactory
{
	public WaterInstance createEnemy(String name)
	{
		WaterInstance piece = null;

		if(name == ("Paul"))
		{
			piece = new SeaMonster();
		}
		else if(name == ("Swordfish"))
		{
			piece = new Swordfish();
		}
		else if(name == ("Diver"))
		{
			piece = new Diver();
		}
		else if(name == ("Dolphin"))
		{
			piece = new Dolphin();
		}
		return piece;
	}
}