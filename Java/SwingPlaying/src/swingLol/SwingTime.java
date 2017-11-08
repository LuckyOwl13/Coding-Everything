
package swingLol;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class SwingTime extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	public SwingTime(){
		super("Look at me !! :D");
		
		setSize(350,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelPlay panel1 = new PanelPlay(); 
		add(panel1);
		
		
		
		//JLabel label1 = new JLabel("#gitgud");
		//panel1.add(label1, BorderLayout.CENTER);
		
		Container contain1 = new Container();
		Container contain2 = new Container();
		Container contain3 = new Container();
		
		contain1.setLayout(new FlowLayout());
		contain2.setLayout(new GridLayout(3,1));
		contain3.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("not this");
		JButton b2 = new JButton("not this");
		JButton b3 = new JButton("not this");
		JButton b4 = new JButton("this");
		JButton b5 = new JButton("not this");
		JButton b6 = new JButton("not this");
		JButton b7 = new JButton("not this");
		
		
		contain1.add(b1);
		contain1.add(b2);
		contain2.add(b3);
		contain2.add(b4);
		contain2.add(b5);
		contain3.add(b6);
		contain3.add(b7);
		
		panel1.add(contain1, BorderLayout.NORTH);	
		panel1.add(contain2, BorderLayout.WEST);	
		panel1.add(contain3, BorderLayout.SOUTH);	
		//panel1.add(b5, BorderLayout.EAST);
		
		b4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				panel1.setBackground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
			}
		});
		
		
		
		setVisible(true);
	}
	
	
	
}
