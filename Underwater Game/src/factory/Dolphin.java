package factory;

import javax.swing.ImageIcon;

//Class for Dolphin
public class Dolphin extends WaterInstance
{
	public Dolphin()
	{
		this.setName("Dolphin");
		this.setImage(new ImageIcon("../Underwater Game/src/img/128-Dolphin.png"));
	}	
}