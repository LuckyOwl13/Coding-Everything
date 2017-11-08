package v1.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

import v1.models.Department;

public class TopPanel extends JPanel {
	
	JComboBox<ComboItem> departments;
	
	public TopPanel(){

		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout());
		
		JLabel topText = new JLabel("Select a department");
		add(topText);
		
		
		departments = new JComboBox<ComboItem>();
		departments.addItem(new ComboItem(" ",Department.NONE));
		departments.addItem(new ComboItem("Art",Department.ART));
		departments.addItem(new ComboItem("Biology",Department.BIOLOGY));
		departments.addItem(new ComboItem("Chemistry",Department.CHEMISTRY));
		departments.addItem(new ComboItem("Computer Science",Department.COMPUTER_SCIENCE));
		departments.addItem(new ComboItem("Economics",Department.ECONOMICS));
		departments.addItem(new ComboItem("English",Department.ENGLISH));
		departments.addItem(new ComboItem("History",Department.HISTORY));
		departments.addItem(new ComboItem("Music",Department.MUSIC));
		departments.addItem(new ComboItem("Mathematics",Department.MATHEMATICS));
		departments.addItem(new ComboItem("Philosophy",Department.PHILOSOPHY));
		departments.addItem(new ComboItem("Physics",Department.PHYSICS));
		departments.addItem(new ComboItem("Psychology",Department.PSYCHOLOGY));		
		add(departments);
	}
	// end of constructor -------------------------------------------------------------------------
	
	
	public JComboBox<ComboItem> getDepartments(){ 
		return departments;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class ComboItem
	{
	    private String key;
	    private Department value;

	    public ComboItem(String key, Department value)
	    {
	        this.key = key;
	        this.value = value;
	    }

	    @Override
	    public String toString()
	    {
	        return key;
	    }

	    public String getKey()
	    {
	        return key;
	    }

	    public Department getValue()
	    {
	        return value;
	    }
	}
	
	
	
	
	
}
