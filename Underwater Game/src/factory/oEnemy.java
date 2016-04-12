package factory;

// Represents each Observer that is monitoring changes in the subject
public class oEnemy implements Observer
{
	private int Rows;
	private int Columns;

	// Static used as a counter
	private static int observerIDTracker = 0;

	// Used to track the observers
	private int observerID;

	// Will hold reference to the StockGrabber object
	private Subject EnemyGrabber;

	public oEnemy(Subject EnemyGrabber)
	{
		// Store the reference to the stockGrabber object so
		// I can make calls to its methods
		this.EnemyGrabber = EnemyGrabber;

		// Assign an observer ID and increment the static counter
		this.observerID = ++observerIDTracker;

		// Message notifies user of new observer
		System.out.println("Turns:" + this.observerID);

		// Add the observer to the Subjects ArrayList
		EnemyGrabber.register(this);

	}

	// Called to update all observers
	public void update(int Rows, int Columns)
	{
		Board m = Board.getInstance();
		Rows = m.getX();
		Columns = m.getY();
		this.Rows = Rows;
		this.Columns = Columns;

		printBoard();
	}

	public void printBoard()
	{
		Board m = Board.getInstance();
		for (int i = 0; i < m.getX(); i++)
		{
			for (int j = 0; j <m.getY(); j++)
			{
				m.getGrid()[i][j] = m.getGrid()[i][j];
				System.out.print("[" + m.getGrid()[i][j] + "]");
			}
			System.out.print("\n");
		}
	}
}