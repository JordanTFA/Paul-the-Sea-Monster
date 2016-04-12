package factory;

import javax.swing.ImageIcon;

public class Enemies
{
	fEnemyFactory theFactory;
	private String name;

	public Enemies()
	{
		setTheFactory(new fEnemyFactory());
	}

	public void addToBoard(String name)
	{
		WaterInstance Enemys;
		Enemys = this.theFactory.createEnemy(name);
		Enemys.setPosition();
	}

	public void playGame(String name)
	{
		WaterInstance Enemys;
		Enemys = this.theFactory.createEnemy(name);
		Enemys.obJectInfo();
	}

	public void Remove(String name)
	{
		WaterInstance Enemys;
		Enemys = this.theFactory.createEnemy(name);

		Enemys.remove();
	}

	public ImageIcon getImage(String name)
	{
		WaterInstance Enemies;
		Enemies = this.theFactory.createEnemy(name);
		Board m = Board.getInstance();
		Enemies.getImage();

		return Enemies.getImage();	
	}

	public void setTheFactory(fEnemyFactory theFactory)
	{
		this.theFactory = theFactory;
	}

	public String getName()
	{
		return name;
	}
}