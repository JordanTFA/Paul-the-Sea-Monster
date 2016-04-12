package factory;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public abstract class WaterInstance
{
	private String name;
	private ImageIcon image;
	private int x;
	private int y;
	private int ID;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ImageIcon getImage()
	{
		return image;
	}

	public void setImage(ImageIcon image)
	{
		this.image = image;
	}

	public void setPosition()
	{
		Board m = Board.getInstance();

		if (m.getGrid()[0][0] == "water")
		{
			m.getGrid()[0][0] = getName();
			ID = ID + 1;
		}
	}

	public void obJectInfo()
	{
		Board m = Board.getInstance();

		for (int i = 0; i < m.getX(); i++)
		{
			for (int j = 0; j < m.getY(); j++)
			{

				if (m.getGrid()[i][j] == getName())
				{
					x = i;
					y = j;
					getImage();
				}
			}
		}
		System.out.println("ID:"+ID+"     Name:"+getName()+"     Positon:"+x+","+y);
	}

	public void remove()
	{
		Board m = Board.getInstance();

		for (int i = 0; i < m.getX(); i++)
		{
			for (int j = 0; j < m.getY(); j++)
			{
				if (m.getGrid()[i][j] == getName())
				{
					x = i;
					y = j;
					getImage();
				}
			}
		}
		System.out.println("ID:" + ID + "     Name:" + getName() + "     Positon:" + x + "," + y + " Has been Deleted");	
		m.getGrid()[this.x][this.y] = "water";
	}
}