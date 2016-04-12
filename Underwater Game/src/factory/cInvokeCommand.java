package factory;

public class cInvokeCommand
{
	cICommand theCommand;

	public cInvokeCommand(cICommand newCommand)
	{
		theCommand = newCommand;
	}

	public void move()
	{
		theCommand.execute();
	}
}