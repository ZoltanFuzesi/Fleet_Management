

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * FleetSource interface hold different resources to the program.
 * 
 */
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public interface FleetSource
{
	FleetManagementCompany mainCompany = new FleetManagementCompany();
	String[]list = mainCompany.getListOfFleet();
	DefaultComboBoxModel model = new DefaultComboBoxModel(list);
	JComboBox fleetList = new JComboBox();
	DefaultComboBoxModel model1 = new DefaultComboBoxModel();
	JComboBox boatList = new JComboBox();
	String [] destinations =  {"Rosslare - Cherburg","Cherburg - Rosslare","Dublin - Holyhead","Holyhead - Dublin","Rosslare - Pembroke","Pembroke - Rosslare" };
	DefaultComboBoxModel dest = new DefaultComboBoxModel(destinations);	
	JComboBox destinationList = new JComboBox();
	String [] schedules =  mainCompany.scheduleTimesArray(0);//{"No Destination selected"};
	DefaultComboBoxModel sched = new DefaultComboBoxModel(schedules);
	JComboBox scheduleList = new JComboBox();
	//String [] emptyList =  {""};
	//DefaultComboBoxModel empty = new DefaultComboBoxModel(schedules);
	
	final int SHORTCUT_MASK = 0;
	static int companyValue = -1;//used for get the position from the fleet dropdown list
	static int companyboatValue = -1;//used for get the position from the boat dropdown list
	static int checkFleets = 0;//used for check if any fleets added
	static int loopcount = 0;//control drop down list looping
}
