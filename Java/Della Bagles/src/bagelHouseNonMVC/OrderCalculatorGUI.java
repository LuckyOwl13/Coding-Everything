package bagelHouseNonMVC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 *  The OrderCalculatorGUI class creates the GUI for the
 *  Brandi's Bagel House application.
 */

public class OrderCalculatorGUI extends JFrame
{
   // The following constant is for the sales tax rate.
   private final double TAX_RATE = 0.06;

   // The following variables will reference the
   // custom panel objects.
   private BagelPanel bagelPanel;      // Bagel panel
   private ToppingPanel toppingsPanel; // Topping panel
   private CoffeePanel coffeePanel;    // Coffee panel
   private GreetingPanel bannerPanel;  // To display a greeting
   private CostPanel costPanel;        // To display the subtotals and the buttons
   private DonutPanel donutPanel;	   // Donut Panel

   // The following variables will reference objects
   // needed to add the Calculate and Exit buttons.
   private JPanel buttonPanel;    // To hold the buttons
   private JButton calcButton;    // To calculate the cost
   private JButton exitButton;    // To exit the application


   /**
    *  Constructor
    */

   public OrderCalculatorGUI()
   {
      // Display a title.
      super("Order Calculator");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager for
      // the content pane.
      setLayout(new BorderLayout());

      // Create the custom panels.
      bannerPanel = new GreetingPanel();
      bagelPanel = new BagelPanel();
      toppingsPanel = new ToppingPanel();
      coffeePanel = new CoffeePanel();
      costPanel = new CostPanel();
      donutPanel = new DonutPanel();
      
      
      // Make a container to hold the four middle panels.
      // Add those panels to the container.
      Container container = new Container();
      container.setLayout(new GridLayout(1,4));
      container.add(bagelPanel);
      container.add(toppingsPanel);
      container.add(coffeePanel);
      container.add(donutPanel);
      
      
      
      // Add the components to the content pane.
      add(bannerPanel, BorderLayout.NORTH);
      add(container, BorderLayout.CENTER);
      add(costPanel, BorderLayout.SOUTH);
      
      // Set the Listener of the Calculate button
      costPanel.getCalcButton().addActionListener(new CalcButtonListener());

      // Pack the contents of the window and display it.
      pack();
      setVisible(true);
   }

  
   /**
    *  Private inner class that handles the event when
    *  the user clicks the Calculate button.
    */

   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double subtotal;  // The order subtotal
         double tax;       // The amount of sales tax
         double total;     // The order total

         // Calculate the subtotal.
         subtotal = bagelPanel.getBagelCost() + 
                    toppingsPanel.getToppingCost() +
                    coffeePanel.getCoffeeCost() +
                    donutPanel.getDonutCost();

         // Calculate the sales tax.
         tax = subtotal * TAX_RATE;

         // Calculate the total.
         total = subtotal + tax;

         // Create a DecimalFormat object to format
         // the total as a dollar amount.
         DecimalFormat dollar = new DecimalFormat("0.00");

         // Display the charges.
         costPanel.getLabSub().setText("Subtotal:  $" + dollar.format(subtotal));
         costPanel.getLabTax().setText("Tax:  $" + dollar.format(tax));
         costPanel.getLabTotal().setText("Total:  $" + dollar.format(total));
      }
   }

   /**
    *  Private inner class that handles the event when
    *  the user clicks the Exit button. 
    */

   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Exit the application.
          System.exit(0);
      }
   }
}