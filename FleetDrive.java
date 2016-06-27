

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;






class FleetDrive extends JFrame implements ActionListener, FleetSource{

	
	
		

	private Container contentPane;
       	private JPanel first = new JPanel();//holder
        private JPanel top = new JPanel();//buttons
        private JPanel main = new JPanel();//main working
        private JPanel left = new JPanel();//left side for details
        private JPanel center = new JPanel();//for center drop downs and buttons
        
        private JPanel one = new JPanel();
        private JPanel two = new JPanel();
        private JPanel three = new JPanel();
        private JPanel four = new JPanel();
        private JPanel five = new JPanel();
        private JPanel six = new JPanel();
        
        private JLabel fleetLabel = new JLabel("Fleet Name :");
        private JLabel boatLabel = new JLabel("Boats in the Fleet : ");
        private JLabel scheduleLabel = new JLabel("Schedule :");
        private JLabel inputField = new JLabel("Add Fleet / Enter the name to the new Fleet:");
        private JLabel staff = new JLabel("Staff number : ");
        private JTextField staffNumber = new JTextField();
        private JLabel container = new JLabel("Container capacity : ");
        private JTextField containerCapacity = new JTextField();
        
        private JCheckBox carryCar = new JCheckBox();
        private JLabel car = new JLabel("Carry car");
        private JCheckBox freigth = new JCheckBox();
        private JLabel freigthLabel = new JLabel("Freigth");
        private JLabel infoMessage = new JLabel("Manage Fleets");
        private JLabel emtyMessage = new JLabel("");
        
        private JTextArea detailsPanel = new JTextArea(22,28);
        private JScrollPane scrollPane = new JScrollPane(detailsPanel);
        
        private JButton add = new JButton("Add Fleet");
        private JButton remove = new JButton("Remove Fleet");
  	 	private JButton Details = new JButton("Fleet Details");
  	 	private FleetManagementCompany mainCompany = new FleetManagementCompany();
  	 	private  int companyValue = -1;//used for get the position from the fleet dropdown list
  	 	private  int companyboatValue = -1;//used for get the position from the boat dropdown list
  	 	private  int checkFleets = 0;//used for check if any fleets added
  	 	private  int loopcount = 0;//control drop down list looping
  	 	private  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  		private  JFrame addFrame;
  		private  JTextArea detailsPane;
  		private String carryCars;
  	 	
        JTextField input = new JTextField();
   	 
        Dimension d = new Dimension(300, 20);
   
        public FleetDrive(){
           super("Fleet Mgmt Ltd");
           setLayout(new BorderLayout());
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
           setMinimumSize(new Dimension(800,470));
           setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
           setResizable(false);
           contentPane=getContentPane();
           createFirstPanel();
        }
        
        public void chageButtonText(int number)
        {
       	 if(number == 1)
    	 {
       		 infoMessage.setText( "Manage Fleets");
    		 add.setText("Add Fleet");
    		 remove.setText("Remove Fleet");
    		 Details.setText("Fleet Details");
    		 inputField.setText("Add Fleet / Enter the name to the new Fleet:");
    		 fleetLabel.setText("Fleet Name :");
    		 boatLabel.setText("Boats in the Fleet : ");
    		 input.setEditable(true);
    		 input.setVisible(true);
    		 car.setText("");
    		 carryCar.setVisible(false);
    		 carryCar.setSelected(false);
    		 freigth.setSelected(false);
    		 staff.setText("");
    		 staffNumber.setVisible(false);
    		 destinationList.setVisible(false);
    		 scheduleList.setVisible(false);
    		 container.setText("");
    		 containerCapacity.setVisible(false);
    		 freigthLabel.setText("");
    		 freigth.setVisible(false);
    		 input.setText("");
    		 scheduleLabel.setText("");
    	 }
    	 if(number == 2)
    	 {
    		 infoMessage.setText("Manage Boats");
    		 add.setText("Add Boat to Fleet");
    		 remove.setText("Remove Boat from Fleet");
    		 Details.setText("Boat Details");
    		 inputField.setText("Add Boat / Enter the name to the new Boat :");
    		 fleetLabel.setText("Select Fleet : ");
    		 boatLabel.setText("Boats in the Fleet : ");
    		 input.setEditable(true);
    		 input.setVisible(true);
    		 car.setText("Car option :");
    		 carryCar.setEnabled(true);
    		 carryCar.setSelected(true);
    		 carryCar.setVisible(true);
    		 staff.setText("Staff number  ");
    		 staffNumber.setEditable(true);
    		 staffNumber.setVisible(true);
    		 container.setText("Passengers Number ");
    		 containerCapacity.setEditable(true);
    		 containerCapacity.setVisible(true);
    		 freigthLabel.setText("Freigth");
    		 freigth.setEnabled(true);
    		 freigth.setVisible(true);
    		 containerCapacity.setText("");
    		 staffNumber.setText("");
    		 input.setText("");
    		 scheduleList.setVisible(false);
    		 destinationList.setEnabled(false);
    		 destinationList.setVisible(false);
    		 scheduleLabel.setText("");
    	 }
    	 if(number == 3)
    	 {
    		 infoMessage.setText("Manage Schedule");
    		 add.setText("Set Schedule");
    		 remove.setText("Remove Schedule");
    		 Details.setText("Boat Schedule Details");
    		 fleetLabel.setText("Select Fleet : ");
    		 boatLabel.setText("Select Boat : ");
    		 scheduleLabel.setText("Select destination adn schedule time :");
    		 inputField.setText("");
    		 input.setVisible(false);
    		 car.setText("");
    		 carryCar.setVisible(false);
    		 staff.setText("");
    		 container.setText("");
    		 containerCapacity.setEditable(false);
    		 freigthLabel.setText("");
    		 freigth.setVisible(false);
    		 containerCapacity.setVisible(false);
    		 staffNumber.setVisible(false);
    		 carryCar.setSelected(false);
    		 freigth.setSelected(false);
    		 input.setText("Can't use here");
    		 scheduleList.setEnabled(true);
    		 destinationList.setEnabled(true);
    		 destinationList.setVisible(true);
    		 scheduleList.setVisible(true);
 
    	 }
        }
        
        public void createFirstPanel()
        {
        	destinationList.setModel(dest);
        	scheduleList.setModel(sched);
        	destinationList.setVisible(false);
        	scheduleList.setVisible(false);
        	fleetList.setModel(model);//Initialise Fleet list drop down box
        	boatList.setModel(model1);//Initialise Boats drop down box
        	scheduleLabel.setText("");
    		JMenuBar bar = new JMenuBar();
    		JMenu menu = new JMenu("All Details");
    		JMenuItem closeProgram = new JMenuItem("Exit");
    		closeProgram.addActionListener(this);
    		menu.add(closeProgram);
    		JMenuItem firstItem = new JMenuItem("Fleet Names");
    		firstItem.addActionListener(this);
    		menu.add(firstItem);
    		JMenuItem fleetsM = new JMenuItem("Number of Fleets");
    		fleetsM.addActionListener(this);
    		menu.add(fleetsM);
    		JMenuItem boatsM = new JMenuItem("Number of Boats");
    		boatsM.addActionListener(this);
    		menu.add(boatsM);
    		JMenuItem clear = new JMenuItem("Clear Activity panel");
    		clear.addActionListener(this);
    		menu.add(clear);
    		bar.add(menu);
    		contentPane.add(bar, BorderLayout.NORTH);
        	JButton change = new JButton("Manage Fleets");
        	change.addActionListener(this);
       	 	JButton change1 = new JButton("Manage Boats");
       	 	change1.addActionListener(this);
       	 	JButton change2 = new JButton("Manage Schedules");
       	 	change2.addActionListener(this); 
       	 	add.addActionListener(this);
       	 	remove.addActionListener(this);
       	 	Details.addActionListener(this);
       	 	staffNumber.setColumns(5);
       	 	containerCapacity.setVisible(false);
       	 	staffNumber.setVisible(false);
        	 first = new JPanel();
        	 top = new JPanel();
        	 top.setLayout( new FlowLayout(FlowLayout.LEFT));//for buttons
        	 JPanel firstTop = new JPanel();
        	 firstTop.setLayout(new GridLayout(1,5));//hold buttons
        	 first.setLayout(new BorderLayout());    
        	 
        	 fleetList.setPreferredSize(new Dimension(405,20));
        	 boatList.setPreferredSize(new Dimension(405,20));
        	 //main working panel
        	 main.setLayout(new BorderLayout());
        	 center.setLayout(new GridLayout(6,1));
        	
        	 JPanel inner1 = new JPanel();
        	 inner1.setLayout(new GridLayout(2,1));
        	 one.add(inner1);
        	 inner1.add(fleetLabel);
        	 inner1.add(fleetList);
        	 center.add(one);
        	 
       
        	 
        	 JPanel inner2 = new JPanel();
        	 inner2.setLayout(new GridLayout(2,1));
        	 two.add(inner2);
        	 inner2.add(boatLabel);
        	 inner2.add(boatList);
        	 center.add(two);
        	 destinationList.setPreferredSize(new Dimension(200,20));
        	 scheduleList.setPreferredSize(new Dimension(200,20));
        	 
        	 
        	 JPanel inner = new JPanel();
        	 inner.setLayout(new GridLayout(2,1));
        	 JPanel inn1 = new JPanel();
        	 inn1.add(scheduleLabel);
        	 inner.add(inn1);
        	 JPanel inn = new JPanel();
        	 
        	 inn.add(destinationList);
        	 inn.add(scheduleList);
        	 inner.add(inn);
        	 three.add(inner);
        	 input.setPreferredSize(new Dimension(405,20));
        	 JPanel inner3 = new JPanel();
        	 inner3.setLayout(new GridLayout(2,1));
        	 four.add(inner3);
        	 inner3.add(inputField);
        	 inner3.add(input);
        	 center.add(three);
        	 JPanel fiveInner = new JPanel();
        	 fiveInner.setLayout(new GridLayout(2,3));
        	 fiveInner.add(staff);
        	 fiveInner.add(staffNumber);
        	 JPanel innerCar = new JPanel();
        	 innerCar.setLayout(new GridLayout(1,2));
        	 innerCar.add(car);
        	 innerCar.add(carryCar);
        	 fiveInner.add(innerCar);
        	 fiveInner.add(container);
        	 fiveInner.add(containerCapacity);
        	 JPanel innerFreigth = new JPanel();
        	 innerFreigth.setLayout(new GridLayout(1,2));
        	 innerFreigth.add(freigthLabel);
        	 innerFreigth.add(freigth);
        	 carryCar.setVisible(false);
        	 carryCar.addItemListener(new ItemListener() {
        			public void itemStateChanged(ItemEvent e) {
        				 boolean state = carryCar.isSelected();
        				  if(state)
        				  {
        					 container .setText("Passengers Number");
        					  freigth.setSelected(false);
        					  carryCars = "YES";
        				  }
        				  else
        				  {
        					  carryCars= "NO";
        				  }
        			}
        		});
        	 
        	//Freight check box ItemListner
        	 freigth.setVisible(false);
        	 freigth.addItemListener(new ItemListener() {
        			public void itemStateChanged(ItemEvent e) {
        				boolean state = freigth.isSelected();
        				if(state)
        				{
        					carryCar.setSelected(false);
        					container.setText("Containers Number");
        					carryCars = "YES";
        				}
        				else
        				{
        					staff.setText("Staff number");
        					carryCars= "NO";
        				}
        			}
        		});

    		   destinationList.addItemListener(new ItemListener() {//assigning companyValue to selected item
    	            public void itemStateChanged(ItemEvent event) {            
    	                int dindex = destinationList.getSelectedIndex();
    	                refresScheduleDropDown(dindex);	                
    	            }
    	        });
        	 fiveInner.add(innerFreigth);
        	 five.add(fiveInner);
        	 six.add(add);
        	 six.add(remove);
        	 six.add(Details);
        	 center.add(four);
        	 center.add(five);
        	 center.add(six);
        	 
        	
        	 detailsPanel.setPreferredSize(new Dimension(250, 55000));
        	 left.add(scrollPane);
             first.add(top, BorderLayout.NORTH);
             top.add(firstTop);
             main.add(left, BorderLayout.WEST);
             main.add(center, BorderLayout.CENTER);
             first.add(main, BorderLayout.CENTER);
             firstTop.add(change);
             firstTop.add(change1);
             firstTop.add(change2);
             firstTop.add(emtyMessage);
             firstTop.add(infoMessage);
             contentPane.add(first, BorderLayout.CENTER);
             car.setText("");
    		 carryCar.setEnabled(false);
    		 staff.setText("");
    		 staffNumber.setEditable(false);
    		 container.setText("");
    		 containerCapacity.setEditable(false);
    		 freigthLabel.setText("");
    		 freigth.setEnabled(false);
    		
             setVisible(true);
             fleetList.addItemListener(new ItemListener() {
    			 public void itemStateChanged(ItemEvent event) {   
    				 int ind = fleetList.getSelectedIndex();
    				 
    				 companyboatValue = -1;
    				 setcompanyValue(ind);//assign companyValue to selected item
    				 	if(loopcount==0)//control combo box unexpected looping behaviour 
    	             	{
    				 		refresBoatsDropDown(companyValue);
    				 		if(mainCompany.getFleetListSize()==0)
    				 			refresBoatsDropDown(companyValue);
    				 			
    				 		loopcount = 1;
    	                }
    				 	else
    				 	{
    				 		loopcount = 0;
    				 	}
    	            }
    	      });
             
             boatList.addItemListener(new ItemListener() {//assigning companyValue to selected item
 	            public void itemStateChanged(ItemEvent event) {  
 	                int ind = boatList.getSelectedIndex();
 	                	if(ind>=0)
 	                	{
 	                		setcompanyboatValue(ind);
 	                	}
 	            }
 	        });
    		 
        }
             
    


        
        public static void main(String args[])
        {
        	new FleetDrive();
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			
			if (command.equals("Manage Fleets"))
			{
				chageButtonText(1);
			}
			
			if (command.equals("Manage Boats"))
			{
				chageButtonText(2);
			}
			
			if (command.equals("Manage Schedules"))
			{
				chageButtonText(3);
			}

			//Close program Button
			if (command.equals("Close program"))
			{
				int answear = JOptionPane.showConfirmDialog(null, "Close application ?  " , "Exit", JOptionPane.YES_NO_OPTION );
				if(answear == 0)
				{
					System.exit(0);
				}
			}
			
			//Exit menu item
			if (command.equals("Exit"))
			{
				int answear = JOptionPane.showConfirmDialog(null, "Close application ?  " , "Exit", JOptionPane.YES_NO_OPTION );
				if(answear == 0)
				{
					System.exit(0);
				}
			}
			
			//Fleet Names Menu Item Listener
			if (command.equals("Fleet Names"))
			{
				
				if(companyValue<0)
	            	error("There is no Fleet in the Company");
	            else
	            	showFleetWindow(-100);
			}
			
			//Number of Fleets Menu Item Listener
			if (command.equals("Number of Fleets"))
			{
				error("Number of Fleets in the company : " + mainCompany.getFleetListSize());
			}
			
			//Number of Boats Menu Item Listener
			if (command.equals("Number of Boats"))
			{
				if(checkFleets>0)
	           		error("Number of Boats in all Fleets : " + mainCompany.getAllBoatsFromAllCompanies());
	            	else
	           		error("There is no boat in the Fleets");
			}
			
			//Add Fleet button ActionListner
			if (command.equals("Add Fleet"))
			{
				addFleet();	
			}
			
			//Delete Fleet Button ActionListner
			if (command.equals("Remove Fleet"))
			{
				deleteFleet();
			}
			
			//Remove Boat ActionListner
			if (command.equals("Remove Boat from Fleet"))
			{
				if(companyValue<0||companyboatValue<0)//check is there any value for boat or fleet
				{
					error("There is no boat in the list");
				}
				else
				{
					removeBoatWindows(companyValue, companyboatValue);
				}
			}
			
			//Set time and destination Button ActionListner
			if (command.equals("Set Schedule"))
			{
				if(companyboatValue>=0)
	            {
					String sched = scheduleList.getSelectedItem().toString();
	                mainCompany.setBoatSchedule(companyValue, companyboatValue,sched);
	            }
				int dindex = destinationList.getSelectedIndex();
	            String destination = destinations[dindex];
					
	            	if(companyboatValue>=0)
					{
						mainCompany.setBoatDestination(companyValue, companyboatValue,destination);
						updateDetailPane("\nBoat Schedule time Updated ! " + mainCompany.getSingleBoatDetails(companyValue, companyboatValue));
					}
			}
			
			//Remov time and destination Button ActionListner
			if (command.equals("Remove Schedule"))
			{
				if(companyboatValue>=0)
	            {
					String sched = "NOT SET";
	                mainCompany.setBoatSchedule(companyValue, companyboatValue,sched);
	            }
				int dindex = destinationList.getSelectedIndex();
	            String destination = "NOT SET";
					
	            	if(companyboatValue>=0)
					{
						mainCompany.setBoatDestination(companyValue, companyboatValue,destination);
						updateDetailPane("\nBoat Schedule time Updated ! " + mainCompany.getSingleBoatDetails(companyValue, companyboatValue));
					}
			}
			
			//Show boat details ActionListner
			if (command.equals("Boat Details"))
			{
				if(companyValue>=0&&companyboatValue>=0)
				{
					showWindow(companyValue, companyboatValue);	
				}
			}
			//Show boat details ActionListner
			if (command.equals("Boat Schedule Details"))
			{
				if(companyValue>=0&&companyboatValue>=0)
				{
					showWindow(companyValue, companyboatValue);	
				}
			}
			
			
			//Show boat details ActionListner
			if (command.equals("Fleet Details"))
			{
				if(companyValue>=0)
				{
					showFleetWindow(companyValue);
				}
			}
			
			//cancel button
			if (command.equals("Cancel"))
			{
				addFrame.dispose();
				JOptionPane.showMessageDialog(null, "Cancelled" );
			}
			
			//clear details panel
			if (command.equals("Clear Activity panel"))
			{	
				longDetails = "";
				detailsPanel.setText("*************************  Activity Panel *************************");
			}
			
			
			
			//Add Boat Button ActionListner
			if (command.equals("Add Boat to Fleet"))
			{
				String boatName = input.getText();//get companyValuest to build object
				String boatstaff = staffNumber.getText();
				String boatcapacity = containerCapacity.getText();
				String boatcar = carryCars;
				int errorcheck = 0;
				if(companyValue>=0)
				{
					for(int i = 0 ; i < mainCompany.getBoatListSize(companyValue) ; i++)
					{
						if(mainCompany.singleBoatName(companyValue, i).equalsIgnoreCase(boatName))
						{
							error("The boat name already in the Fleet : " + boatName);
							errorcheck = 1;
						}
					}
				
					if(checkInputInteger(boatstaff)&&checkInputInteger(boatcapacity)&&errorcheck==0)
					{
						int bstaff = Integer.parseInt(boatstaff);
						int bcapacity =Integer.parseInt(boatcapacity);
						if(freigth.isSelected()==false)
						{
							Boat passenger = new PassengerBoat(boatName, bstaff, bcapacity , boatcar);//create new Passenger object
							mainCompany.addBoatToFleetList(companyValue, passenger);//add object to company fleet
							refresBoatsDropDown(companyValue);//refres boat drop down 
							//addFrame.dispose();
							JOptionPane.showMessageDialog(null, "The boat : " + boatName + " added !" );
							updateDetailPane("\nNew boat added !!" + "\nCompany name : " + mainCompany.getFleetName(companyValue) + "\nBoatname : "
							+ boatName +"\nPassenger boat" + "\nNumber of staff : " + boatstaff + "\nPassenger capacity : " + bcapacity + "\nCarry car : " + boatcar);
							input.setText("");
							staffNumber.setText("");
							containerCapacity.setText("");
						}
						else
						{
							Boat freigth = new FreigthBoat(boatName, bstaff, bcapacity);//creating new freigth boat
							mainCompany.addBoatToFleetList(companyValue, freigth);
							refresBoatsDropDown(companyValue);//refres boat drop down 
							//addFrame.dispose();
							JOptionPane.showMessageDialog(null, "The boat : " + boatName + " added !" );
							updateDetailPane("\nNew boat added !!" + "\nCompany name : " + mainCompany.getFleetName(companyValue) + "\nBoatname : "
									+ boatName + "\nFreigth boat " + "\nNumber of staff : " + boatstaff + "\nContainer capacity : " + boatcapacity);
							input.setText("");
							staffNumber.setText("");
							containerCapacity.setText("");
						}
						
					}
					else
					{
						errorcheck = 0;
					}
				}
			}
		}
		public int getcompanyValue()
		{
			return companyValue;
		}
		
		public int getcompanyboatValue()
		{
			return companyboatValue;
		}

		//update details panel
		public  void updateDetailPane(String details)
		{
			
			longDetails = longDetails + "\n" + details;
			detailsPanel.setText(longDetails);
		}
		
		
		//Create add boat window
		public  void addBoatWindows(int companyValue)
		{
			//addBoat.createAddBoatFrame(companyValue);
		}
		
		
		//Create and open up show the selected boat window
		public  void showWindow(int companyvalue, int companyboatvalue)
		{
			String compName = mainCompany.getFleetName(companyvalue);
			String str = mainCompany.getSingleBoatDetails(companyvalue, companyboatvalue);
			compName = "Company Name : " + compName + "\n" + str;
			JTextArea textArea = new JTextArea(15, 50);
			textArea.setMargin(new Insets(0, 10, 0, 0));
		    textArea.setText(compName);
		    textArea.setEditable(false);
		    JFrame f = new JFrame();		      
		    JOptionPane.showMessageDialog(f, textArea);
		}
		
		//Create and open up show the selected Fleet window
		public  void showFleetWindow(int companyPosition)
		{
			String str = "";
			if(companyPosition==-100)
				str = mainCompany.getFleetList();
			else
				str = mainCompany.fleetDetails(companyPosition);
			if(companyValue>=0&&fleetList.getSelectedIndex()>=0)//show up if something is selected
			{
			      JTextArea textArea = new JTextArea(15, 50);
			      textArea.setMargin(new Insets(0, 10, 0, 0));
			      textArea.setPreferredSize(new Dimension(550, 5000));
			      textArea.setText(str);
			      textArea.setEditable(false);
			      JFrame f = new JFrame();
			      JScrollPane scrollPane = new JScrollPane(textArea);		       
			      JOptionPane.showMessageDialog(f, scrollPane);
			}
		}
		
		//Check the input for integer use at add boat to Fleet
		public  boolean checkInputInteger(String str)
		{
			try
			   {
			      Integer.parseInt( str );
			      return true;
			   }
			   catch( Exception e )
			   {
				  error("Plese check the inputs  - Fill up boat name -  Use number for capacity and staff");
			      return false;
			   }
		}
		
		//Error window used for show error messages
		public  void error(String message)
		{
			JOptionPane.showMessageDialog(null, message );		
		}
		
		//Create and open up remove boat window
		public  void removeBoatWindows(int companyValue, int companyboatValue)
		{
			if(companyValue<0||companyboatValue<0)
			{
				//do nothing
			}
			else
			{
				String message = mainCompany.singleBoatName(companyValue, companyboatValue);
				int answear = JOptionPane.showConfirmDialog(null, "Do you want to remove boat : " + message,message, JOptionPane.YES_NO_OPTION );
				if(answear == 0)
				{
						mainCompany.removeBoat(companyValue, companyboatValue);
						setcompanyboatValue(-1);//set back to nothing
						refresBoatsDropDown(companyValue);
						JOptionPane.showMessageDialog(null, "The boat :" + message + " removed !");
						updateDetailPane("\nBoat removed from Fleet :" + mainCompany.getFleetName(companyValue)  + "\nBoat name : " + message);
				}
			}
		}
		
		//Refers schedule drop down list
		@SuppressWarnings("unchecked")
		public  void refresScheduleDropDown(int companyValue)
		{
			//DefaultComboBoxModel dcm = new DefaultComboBoxModel();
			sched.removeAllElements();
			String[]arr = mainCompany.scheduleTimesArray(companyValue);
			for( String newRow : arr ) {
			    sched.addElement( newRow );
			}
			scheduleList.setModel(sched);
		}
			
		//Refresh boats drop down list at drop down box selection
		@SuppressWarnings("unchecked")
		public  void refresBoatsDropDown(int selectedValue)
		{
			model1.removeAllElements();
			if(companyValue>=0)
			{
					String[]arr = mainCompany.getBoatListArray(selectedValue);
					for( String newRow : arr ) {
					model1.addElement( newRow );
			}
			}
			boatList.setModel(model1);
		}
		
		//Refresh Fleet drop down list at drop down box selection
		@SuppressWarnings("unchecked")
		public  void refresFleetDropDown(int val)
		{
			model.removeAllElements();
			if(val>=0)
			{
				String[]arr = mainCompany.getListOfFleet();
				for( String newArr : arr ) {
				    model.addElement(newArr);
				}
			}
			fleetList.setModel(model);
		}
		
		//Set selected companyValue to integer companyValue to use remove item or get selected company details
		public  void setcompanyValue(int i)
		{
			companyValue = i;
		}
		
		//Set selected companyValue to integer companyValue to use get boat details of Fleet
		public  void setcompanyboatValue(int i)
		{
			companyboatValue = i;
		}
		
		//Refresh Fleet drop down box when fleet object added
		@SuppressWarnings("unchecked")
		public void refresCombobox(Fleet obj)
		{
			model.addElement(obj.getCompanyName());
		}
		
		//Delete Fleet
		public  void deleteFleet()
		{
			if(companyValue>=0&&fleetList.getSelectedIndex()>=0)
			{
				String message = mainCompany.checkFleetName(fleetList.getSelectedIndex());
				int answear = JOptionPane.showConfirmDialog(null, "Are you sure to delete Fleet : " + message,message, JOptionPane.YES_NO_OPTION );
				if(answear == 0)
				{
					if(companyValue>=0&&fleetList.getSelectedIndex()>=0)
					{
						String str = mainCompany.getFleetName(companyValue);
						mainCompany.removeFleet(companyValue);//remove the fleet from the arrayList
						model1.removeAllElements();//remove all elements from boat list
						refresFleetDropDown(companyValue);
						checkFleets--;
						JOptionPane.showMessageDialog(null, "The Flett : " + str + " removed !" );
						updateDetailPane("\nFleet removed from company ! " + "\nFleet name : " + str);
					}
					}
				}
				else
				{
					error("There is no Fleet in the list");
				}	
		}
		
		//Created and open up add Fleet window
		public void addFleet()
		{
			int errorCheck = 0;
			if(input.getText().length()>0)
			{
				String inputStr = input.getText();
				for(int i = 0 ; i < mainCompany.getFleetListSize() ; i ++)//check if the company ALREADY in the system
				{
					if(mainCompany.checkFleetName(i).equalsIgnoreCase(inputStr))
					{
						error("The company already in the system Please use different Fleet name");
						errorCheck++;
					}
				}
				
				if(errorCheck == 0)//if no error add to the system
				{
					Fleet fl = new Fleet(inputStr);
					mainCompany.addFleetToCompany(fl);
					input.setText("");
					if(companyValue<0)
						setcompanyValue(0);
					refresCombobox(fl);
					checkFleets++;
					JOptionPane.showMessageDialog(null, "The Flett : " + inputStr + " added !" );
					updateDetailPane("\nNew Fleet added ! " + "\nFleet name : " + inputStr);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please input Fleet Name" );
			}
		}
        
        
}
