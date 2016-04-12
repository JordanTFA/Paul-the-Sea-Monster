package factory;

public class cTheMapcommand
{
	public static cIMove getDevice()
	{
		return new cMovement(); 
	}   
}