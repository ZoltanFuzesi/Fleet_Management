

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * Boat class is the superclass for Passenger boat and the Freight boat classes.
 * Use to create instance of Boat
 * All of the boats behaviours available from this class.
 * 
 */

import java.util.ArrayList;

public class Boat 
{
	private String boatName;
	private int numberOfStaff;
	private static int countBoats = -2;
	private String destination;
	private String schedule;
	
	//constructor
	public Boat(String boatName, int numberOfStaff)
	{
		setBoatName(boatName);
		setNumberOfStaff(numberOfStaff);
		setDestination("Not Set");
		setSchedule("Not Set");
		countBoats++;
	}
	
	//set boat name
	private void setBoatName(String boatName)
	{
		this.boatName = boatName;
	}
	
	//set number of staff
	private void setNumberOfStaff(int numberOfStaff)
	{
		this.numberOfStaff = numberOfStaff;
	}
	
	//set destination for a corresponding boat
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	//set schedule time
	public void setSchedule(String schedule)
	{
		this.schedule = schedule;
	}
	
	//return full size of the list
	public int fullSizeBoatListFromBoatClass()
	{
		return countBoats;
	}
	
	//make selection of the object type
	public String boatDetails()
	{
		String str = "";
		if(this instanceof PassengerBoat)
		{
			str = str +  this.boatDetails();
		}
		if(this instanceof FreigthBoat)
		{
			str = str +  this.boatDetails();
		}
		return str;
	}
	
	//return type of boat
	public String typeOfBoat()
	{
		String str ="";
		if(this instanceof PassengerBoat)
		{
			str =  "Passenger";
		}
		if(this instanceof FreigthBoat)
		{
			str = "Freigth";
		}
		return str;
	}
	
	//take away passed value from class boat counter
	public void boatCounter(int numberOfBoatsToRemove)
	{
		countBoats -= numberOfBoatsToRemove;
	}
	
	//return Boat name
	public String getBoatName()
	{
		return this.boatName;
	
	}
	
	//return number of staff
	private int getNumnberOfStaff()
	{
		return numberOfStaff;
	}
	
	//override toString
	public String toString()
	{
		return "\nBoat name : " + getBoatName() + "\nNumber of staff : " + getNumnberOfStaff() + "\nDestination :  " + destination + "\nSchedule time : " + schedule;
	}
}
