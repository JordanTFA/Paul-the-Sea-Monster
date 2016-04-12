package factory;

public class cMovePlayer implements cICommand
{
	cIMove thePlayer;

	public cMovePlayer( cIMove newMovement)
	{
		thePlayer = newMovement;   
	}
	public void undo()
	{
	}

	public void execute()
	{
		thePlayer.move();
	}
}