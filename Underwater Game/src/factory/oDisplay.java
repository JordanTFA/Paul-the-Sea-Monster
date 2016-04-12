package factory;

import java.util.ArrayList;

// Uses the Subject interface to update all Observers
public class oDisplay implements Subject
{
	private ArrayList<Observer> observers;
	private int Rows;
	private int Columns;

	public oDisplay()
	{
		// Creates an ArrayList to hold all observers
		observers = new ArrayList<Observer>();
	}

	public void register(Observer newObserver)
	{
		// Adds a new observer to the ArrayList
		observers.add(newObserver);
	}

	public void unregister(Observer deleteObserver)
	{
		// Get the index of the observer to delete
		int observerIndex = observers.lastIndexOf(deleteObserver);

		// Print out message (Have to increment index to match)
		System.out.println("Observer " + (observerIndex+1) + " deleted");

		// Removes observer from the ArrayList
		observers.remove(observers.size() - 1);
	}

	public void notifyObserver()
	{
		for(Observer observer : observers)
		{
			observer.update(Rows,Columns);
		}
	}

	public void setRows(int newRows)
	{
		this.Rows = newRows;
		notifyObserver();
	}

	public void setCols(int newColumns)
	{
		this.Columns = newColumns;
		notifyObserver();
	}
}