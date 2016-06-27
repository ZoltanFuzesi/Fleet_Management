

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * Fleet class can access the Boat class trough the Boat ArrayList.
 * Use to create instance of Fleet.
 * All of the Fleet behaviours available from this class.
 * 
 */
import java.util.ArrayList;

public class Fleet
{
	private String companyName;//eg Irish Ferries
	private int identificationNumber;//eg assign to auto number
	private static int autoIdentificatyioNumber = 500;//class variable
	private ArrayList<Boat>boatList = new ArrayList<>();//Boat ArrayList for individual objects

	//constructor
	public Fleet(String companyName)
	{
		boatList = new ArrayList<>();
		setCompanyName(companyName);
		setIdentificatioNumber(autoIdentificatyioNumber);
		autoIdentificatyioNumber++;		
	}
	
	//set company name 
	private void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	//set identification Number
	private void setIdentificatioNumber(int identificationNumber)
	{
		this.identificationNumber = identificationNumber;
	}
	
	//set boat destination for a single boat
	public void setSingleBoatDestination(int boatPosition, String destination)
	{
		boatList.get(boatPosition).setDestination(destination);
	}
	
	//get full boats list
	public int fullSizeBoatList()
	{
		if(boatList.size()>0)
			return boatList.get(0).fullSizeBoatListFromBoatClass();
		else
			return 0;
	}
	
	//set boat destination for a single boat
	public void setSingleBoatSchedule(int boatPosition, String scheduleTime)
	{
		boatList.get(boatPosition).setSchedule(scheduleTime);
	}
	

	//remove Boat from list
	public void removeBoat(int fleetPosition)
	{
		if(boatList.size()>0)
		{
			boatList.remove(fleetPosition);
		}
		
	}
		
	//add Boat to the Fleet arrayList
	public void addToFleet(Boat objt)
	{
		boatList.add(objt);
	}
	
	//return boat list size for corresponding company
	public int getBoatlistSize()
	{
		if(this.boatList.size()<0)
		{
			return 0;
		}
		else
		{
			return this.boatList.size();
		}
		
	}
	
	//Return type of boat on by one
	private String fleetBoats()
	{
		String strPasseneger = "Passenger boats";
		int numberOfPassengerBoats = 0;
		String strFreigth = "Freigth boats ";
		int numberOfFreigthBoats = 0;
		for(int i = 0 ; i < this.boatList.size() ; i++)
		{
			if(boatList.get(i) instanceof PassengerBoat)
			{
				strPasseneger += "\n" + "Boat name : " + boatList.get(i).getBoatName();
				numberOfPassengerBoats++;
			}
			if(boatList.get(i) instanceof FreigthBoat)
			{
				strFreigth += "\n" + "Boat name : " + boatList.get(i).getBoatName();
				numberOfFreigthBoats++;
			}
		}
		return "Number of Passenger boat : " + " " + numberOfPassengerBoats + " " + strPasseneger + "\nNumber of Freigth boats : " 
				+ " " + numberOfFreigthBoats + " " + strFreigth;
	}
	
	//get the details for a given Boat 
	public String detailsOfBoats(int boatPos)
	{
		return boatList.get(boatPos).boatDetails();
	}
	
	//return Boats list with the corresponding Fleet 
	public String[] getBoatNames(int company)
	{
		String[] str = new String[this.getBoatlistSize()];
		for(int i=0;i<this.getBoatlistSize();i++)
		{
			str[i] =  this.boatList.get(i).getBoatName()+ " : " + this.boatList.get(i).typeOfBoat();
		}
		return str;
	}
	
	//get single boat name
	public String detailsOfBoatsName(int boatpos)
	{
		return boatList.get(boatpos).getBoatName();
	}
	
	//Returning Fleet(company) name
	public String getCompanyName() {
		return companyName;
	}
	
	//returning the fleet identification number
	public String getIdentificationNumber()
	{
		return "\nFleet identification No :" + identificationNumber;
	}
	
	
	//return the name of the company and the corresponding Boat names
	public String toString()
	{
		return "Fleet Details :" + "\nFleet name : " + getCompanyName() + getIdentificationNumber()
		+ "\nNumber of boats : " + this.getBoatlistSize() + "\n" + this.fleetBoats();
	}
	
}
