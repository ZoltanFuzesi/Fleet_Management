

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * FreigthBoat class is child class of Boat class.
 * Use to create instance of FreigthBoat.
 * All of the FreigthBoats behaviours available from this class.
 * 
 */

public class FreigthBoat extends Boat
{
	private int containerCapacity;
	private String typeOfBoat = "Freigth";
	
	//constructor
	public FreigthBoat(String boatName, int numberOfStaff, int containerCapacity)
	{
		super(boatName, numberOfStaff);
		setType(typeOfBoat);
		this.containerCapacity = containerCapacity;
	}
	
	//set type of boat
	private void setType(String typeOfBoat)
	{
		this.typeOfBoat = typeOfBoat;
	}
	
	//return type of boat
	public String getTypeOfBoat()
	{
		return typeOfBoat;
	}
	
	//used from Boat class to trigger toString metod
	public String boatDetails()
	{
		return this.toString();
	}
	
	//used toString method returning details of passenger capacity
	public int getcontainerCapacity()
	{
		return containerCapacity;
	}
	
	//used toString method returning details of carrying cars
	public String toString()
	{
		return super.toString() + "\nContainer capacity : " + getcontainerCapacity()+ "\nType of boat : " + getTypeOfBoat();
	}
}
