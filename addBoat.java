
/*Author Zoltan FUzesi		Date : 30/03/2016
 * 
 * Add boat class creating the the frame to add specific boat (Passenger or Freight) to fleet.
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class addBoat extends FleetDrive
{
	
	private  JFrame addFrame;
		private  JTextField addName;
		private  JTextField addNumberOfStaff;
		private  JTextField addCapacity;
		private  JTextField addCarryeCar;
		private  JCheckBox freight;
  		private  JTextArea detailsPane;
  		private  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public  void createAddBoatFrame(int companyValue)
	{
		addFrame = new JFrame("Add Boat");
		JPanel addmain = new JPanel();
		addmain.setLayout(new GridLayout(5,1));
		JPanel one = new JPanel();
		JPanel two = new JPanel();
		JPanel three = new JPanel();
		JPanel four = new JPanel();
		JPanel five = new JPanel();
		addFrame.getContentPane().add(addmain);
		addmain.add(one);
		addmain.add(two);
		addmain.add(three);
		addmain.add(four);
		addmain.add(five);
		addName = new JTextField();
		JLabel name = new JLabel("Name");
		addNumberOfStaff = new JTextField();
		JLabel staff = new JLabel("Staff");
		addCapacity = new JTextField("Passengers");
		JLabel capacity = new JLabel("Capacity");
		addCarryeCar = new JTextField();
		JLabel car = new JLabel("Car");
		addName.setColumns(20);
		name.setPreferredSize(new Dimension(80,15));
		staff.setPreferredSize(new Dimension(80,15));
		capacity.setPreferredSize(new Dimension(80,15));
		car.setPreferredSize(new Dimension(80,15));
		addNumberOfStaff.setColumns(20);
		addCapacity.setColumns(20);
		addCarryeCar.setColumns(20);
		addCarryeCar.setText("YES");
		addCarryeCar.setEditable(false);
		JButton addBoat = new JButton("Add to fleet");
		addBoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(companyValue>=0)
				{
					addBoatWindows(companyValue);
				}
			}
		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addFrame.dispose();
				JOptionPane.showMessageDialog(null, "Cancelled" );
			}
		});
		JCheckBox carOption= new JCheckBox("Carry car", true);
		freight= new JCheckBox("Freigth boat", false);
		one.add(name);
		one.add(addName);
		two.add(staff);
		two.add(addNumberOfStaff);
		three.add(capacity);
		three.add(addCapacity);
		four.add(car);
		four.add(addCarryeCar);
		five.add(carOption);
		five.add(freight);
		five.add(addBoat);
		five.add(cancel);
		addFrame.setSize(600, 200);
		addFrame.setLocation(dim.width/2-addFrame.getSize().width/2, dim.height/2-addFrame.getSize().height/2);
		addFrame.setVisible(true);
		addFrame.getRootPane().setDefaultButton(addBoat);
	
	//********************************** ItemListeners *************************
	
	
	//Car check box ItemListner
	carOption.addItemListener(new ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
			  boolean state = carOption.isSelected();
			  if(state)
			  {
				  addCarryeCar.setText("YES");
			      freight.setSelected(false);
			  }
			  else
			  {
				  addCarryeCar.setText("NO");
			  }
	      }
	 });
				
	//Freight check box ItemListner
	freight.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			boolean state = freight.isSelected();
			if(state)
			{
				carOption.setSelected(false);
				addCapacity.setText("Container");
				car.setText("");
				addCarryeCar.setText("");
			}
			else
			{
				car.setText("Car");
				capacity.setText("Capacity");
				addCapacity.setText("Passengers");
				addCarryeCar.setText("NO");
			}
		}
	});
	
	}
}

