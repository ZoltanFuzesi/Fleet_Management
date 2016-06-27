


/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * PassengerBoat class is child class of Boat class.
 * Use to create instance of PassengerBoat.
 * All of the PassengerBoats behaviours available from this class.
 * 
 */

public class PassengerBoat extends Boat
{
	private int passengerCapacity;
	private String carryCars;
	private String typeOfBoat = "Passenger";
	
	//constructor
	public PassengerBoat(String boatName, int numberOfStaff, int passengerCapacity, String carryCars)
	{
		super(boatName, numberOfStaff);
		this.typeOfBoat();
		setCapacity(passengerCapacity);
		setCarryCars(carryCars);	
	}
	
	//used toString method returning details of passenger capacity
	private int getPassengerCapacity()
	{
		return passengerCapacity;
	}
	
	//set passenger capacity
	private void setCapacity(int passengerCapacity)
	{
		this.passengerCapacity = passengerCapacity;
	}
	
	//set carry cars
	private void setCarryCars(String carryCars)
	{
		this.carryCars = carryCars;
	}
	
	//return type of boat
	public String getTypeOfBoat()
	{
		return typeOfBoat;
	}
	
	//used toString method returning details of carrying cars
	private String getCarryCars()
	{
		return carryCars;
	}
	
	//used from Boat class to trigger toString metod
	public String boatDetails()
	{
		return this.toString();
	}
	
	//override toString
	public String toString()
	{
		return super.toString() + "\nPassenger capacity : " + getPassengerCapacity() + "\nCarry cars :  " + getCarryCars() + "\nType of boat :  " + getTypeOfBoat();
	}
}
