package v1.views;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class BottomPanel extends JPanel {
	
	JLabel bottomText;
	
	public BottomPanel(){
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout());
		
		bottomText = new JLabel("Matching Sections");
		add(bottomText);
	}

	public JLabel getBottomText() {
		return bottomText;
	}
	
	
}
