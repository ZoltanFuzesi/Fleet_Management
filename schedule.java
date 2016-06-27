

/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * Schedule class holds all of the information for schedule times.
 * Use to create instance of schedule including (aggregate) instance in FleetManagement class to access schedule times.
 * All of the schedules available from this class.
 * 
 */

public class schedule
{
	private String[]Rosslare_Cherburg ={"Friday 21.30 - 16.30", "Wednesday 18.00 - 14.00"};
	private String[]Cherburg_Rosslare = {"Sunday 18.00 - 14.00", "Wednesday 21.30 - 16.30" };
	private String[]Dublin_Holyhead = {"Daily 01.55 - 05.25" , "Daily 08.05 - 11.30", "Daily 15.15 - 17.45" , "Daily 20.55 - 00.20"};
	private String[]Holyhead_Dublin = {"Daily 02.40 - 05.55" , "Daily 08.00 - 11.30", "Daily 14.10 - 17.25" , "Daily 20.0 - 23.15"};
	private String[]Rosslare_Pembroke = {"Daily 08.45 - 12.46", "Daily 20.45 - 00.46"};
	private String[]Pembroke_Rosslare = {"Daily 02.45 - 06.46", "Daily 14.15 - 18.46"};
	
	//constructor
	public schedule()
	{
		
	}
	
	//get schedule times
	public String[] getSchedulesTimes(int position)
	{
		String[]str = new String[5];
		
		if(position==0)
		{
			str = copyArray(Rosslare_Cherburg);
		}
		else if(position==1)
		{
			str = copyArray(Cherburg_Rosslare);
		}
		else if(position==2)
		{
			str = copyArray(Dublin_Holyhead);
		}
		else if(position==3)
		{
			str = copyArray(Holyhead_Dublin);
		}
		else if(position==4)
		{
			str = copyArray(Rosslare_Pembroke);
		}
		else if(position==5)
		{
			str = copyArray(Pembroke_Rosslare);
		}

		return str;
	}
	
	//copy array
	public String[] copyArray(String[]array)
	{
		String[]st = new String[array.length];
		for(int i = 0 ; i < st.length ; i++ )
		{
			st[i] = array[i];
		}
		
		return st;
	}
}
