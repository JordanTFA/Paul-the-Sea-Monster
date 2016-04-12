package factory;

import javax.swing.ImageIcon;

//Class for Diver
public class Diver extends WaterInstance
{
	public Diver()
	{
		this.setName("Diver");
		this.setImage(new ImageIcon("../Underwater Game/src/img/128-Diver.png"));
	}
}