

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * FleetManagament class is the overall class in the program.
 * FleetManagement class can access the Fleet class trough the Boat ArrayList.
 * Use to create instance of FLeetManagement and access Fleet class.
 * All of the FleetManagement behaviours available from this class.
 * 
 */

import java.util.ArrayList;

public class FleetManagementCompany
{
	private String COMPANYNAME = "Fleet Mgm Ltd";
	private ArrayList<Fleet>list = new ArrayList<>();
	private schedule sc;//use to access schedule only
	private Boat b = new Boat("i" , 0);//use to access static Boat counter variable only.

	//constructor
	public FleetManagementCompany()
	{
		sc = new schedule();
		list = new ArrayList<>();//add Fleet ArrayList to the company to store Fleets
		addCompaniname(COMPANYNAME);
	}
	
	//assign company name
	public void addCompaniname(String COMPANYNAME)
	{
		this.COMPANYNAME = COMPANYNAME;
	}
	//fleet details
	public String fleetDetails(int companyPosition)
	{
		return list.get(companyPosition).toString();
	}
	
	//check if the company in the system
	public String checkFleetName(int companyPosition)
	{
		return list.get(companyPosition).getCompanyName();
	}
	
	//get given fleet name
	public String getFleetName(int company)
	{
		return this.list.get(company).getCompanyName() + list.get(company).getIdentificationNumber();
	}
	
	//set destination
	public void setBoatDestination(int company, int boatPosition, String destination)
	{
		list.get(company).setSingleBoatDestination(boatPosition, destination);
	}
	
	//set schedule time
	public void setBoatSchedule(int company, int boatPosition, String scheduleTime)
	{
		list.get(company).setSingleBoatSchedule(boatPosition, scheduleTime);
	}
	
	//get schedule times from schedule class
	public String[] scheduleTimesArray(int position)
	{
		return sc.getSchedulesTimes(position);
	}
	
	//add Fleet to the company can call the methode with the company name
	public void addFleetToCompany(Fleet obj)
	{
		list.add(obj);
	}
	
	//remove given object boats from counter in boat class
	private void decreaseBoatCoiunter(int boatListSize)
	{
		b.boatCounter(boatListSize);
	}
	
	//method to remove Fleet(company) from Management system
	public void removeFleet(int fleetPosition)
	{
		decreaseBoatCoiunter(list.get(fleetPosition).getBoatlistSize());
		list.remove(fleetPosition);
	}
	
	//add boat to Fleet list send Boat object to Fleet class
	public void addBoatToFleetList(int companyvalue, Boat obj)
	{
		list.get(companyvalue).addToFleet(obj);
	}
	
	//remove Boat from the given corresponding Fleet(company)
	public void removeBoat(int fleetPosition, int boatPos)
	{
		decreaseBoatCoiunter(1);
		list.get(fleetPosition).removeBoat(boatPos);
		
	}
	
	//get names of the boats from the Fleet(company)
	public String[] getBoatList(int company)
	{
		return list.get(company).getBoatNames(company);
	}
	
	//get boat list size corresponding company
	public int getBoatListSize(int company)
	{
		return list.get(company).getBoatNames(company).length;
	}
	
	//return boat list as array for corresponding company from fleet class
	public String[] getBoatListArray(int company)
	{
		String[]list3 = new String[list.get(company).getBoatlistSize()];
		list3 = list.get(company).getBoatNames(company);
		return list3;
	}
	
	//get full size of all of the boats from all of the companies	
	public int getAllBoatsFromAllCompanies()
	{
		return b.fullSizeBoatListFromBoatClass();
	}
	
	//returning the Fleet list size
	public int getFleetListSize()
	{
		return list.size();
	}
	
	//returning the full list of the Fleet company names
	public String getFleetList()
	{
		String str = "";
		for(int i=0;i<list.size();i++)
		{
			str = str + "\nFleet name : " + list.get(i).getCompanyName() + "  " + list.get(i).getIdentificationNumber() + "\n";
		}
		return str;
	}
	
	//get single boat name 
	public String singleBoatName(int company, int boatpos)
	{
		return list.get(company).detailsOfBoatsName(boatpos);
	}
	
	//returning the details of the single boats of the corresponding Fleet
	public String getSingleBoatDetails(int company, int boatPos)
	{
	
		return list.get(company).detailsOfBoats(boatPos);
	
	}
	
	//return list as array to drop down box
	public String[]  getListOfFleet()
	{
		String[]list2 = new String[list.size()];
		for(int i=0;i<list.size();i++)
		{
			list2[i] = list.get(i).getCompanyName();
		}
		return list2;
	}
	
	//return ArrayList if need
	public ArrayList<Fleet> getList()
	{
		return list;
	}
	
	//override toString()
	public String toString()
	{
		return "Company name is " + COMPANYNAME + " list size " + list.size() + "The list \n" + getFleetList();
	}
}
