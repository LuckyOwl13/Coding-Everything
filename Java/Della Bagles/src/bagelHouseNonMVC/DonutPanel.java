package bagelHouseNonMVC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *  The BagelPanel class allows the user to select either
 *  a white or whole wheat bagel.
 */

public class DonutPanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of each type of bagel.
   public final double NO_DONUT = 0.00;
   public final double GLAZED = 1.25;
   public final double CHOCOLATE_FROSTED = 1.50;
   public final double DOUBLE_CHOCOLATE = 1.75;
   public final double APPLE_PIE = 2.00;

   // The following variables will reference ComboBox entries
   // for the types of donuts available.
   private ComboItem none;
   private ComboItem glazed;
   private ComboItem chocolateFrosted;
   private ComboItem doubleChocolate;
   private ComboItem applePie;
    
   private double selectedDonutPrice = 0.00; 

   // The following variable will reference a
   // JComboBox object to group the strings.
   private JComboBox<ComboItem> donuts;

   /**
    *  Constructor
    */

   public DonutPanel()
   {
      // Create a BorderLayout manager with 
      // the ComboBox set at its center.
      setLayout(new BorderLayout());

      // Instantiate the ComboItems that
      // will be added to the ComboBox
      none = new ComboItem("None",0.00);
      glazed = new ComboItem("Glazed",1.25);
      chocolateFrosted = new ComboItem("Chocolate Frosted",1.50);
      doubleChocolate = new ComboItem("Double Chocolate",1.75);
      applePie = new ComboItem("Apple Pie",2.00);
      
      
      
      // Group the ComboBox elements.
      donuts = new JComboBox<ComboItem>();
      donuts.addItem(none);
      donuts.addItem(glazed);
      donuts.addItem(chocolateFrosted);
      donuts.addItem(doubleChocolate);
      donuts.addItem(applePie);

      // Add a border around the panel.
      setBorder(BorderFactory.createTitledBorder("Donut"));

      // Add the ComboBox to the panel.
      add(donuts);
      
      // Add an ActionListener to the ComboBox to store 
      //which donut is currently selected
      donuts.addActionListener(new ActionListener(){
		// sets the selected donut's price as the price 
    	// to be returned when asked for.
    	@Override
		public void actionPerformed(ActionEvent arg0) {
			selectedDonutPrice = ((ComboItem) donuts.getSelectedItem()).getValue();
		}   	  
      });
      
   }

   class ComboItem
	{
	    private String key;
	    private double value;

	    public ComboItem(String key, double value)
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

	    public double getValue()
	    {
	        return value;
	    }
	}
   
   
   /**
    *  The getDonutCost method returns the cost of
    *  the selected donut.
    */

   public double getDonutCost()
   {
      // return the selected donut's cost.
      return selectedDonutPrice;
   }
}