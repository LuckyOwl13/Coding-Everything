package v1.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

import v1.models.Department;
import v1.models.Section;
import v1.models.Student;
import v1.models.Term;

public class RegistrarGUI extends JFrame {
	public static final int MINDOW_HEIGHT = 120;
	public static final int MINDOW_WIDTH = 1200;
	
	private Student studen;
	private Term ter;
	private TopPanel top;
	private MiddlePanel middle;
	private BottomPanel bottom;
	
	
	
	
	public RegistrarGUI(Student studen,Term ter,TopPanel toppanel,
			MiddlePanel middlepanel,BottomPanel bottompanel){
		super("Banner Self-Service for " + studen.getLastName());
		this.studen = studen;
		this.ter = ter;
		setSize(MINDOW_WIDTH,MINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		this.top = toppanel;
		this.middle = middlepanel; 
		this.bottom = bottompanel; 
		
		add(top,BorderLayout.NORTH);
		add(middle,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		
		setVisible(true);
	} 	
	// end constructor ---------------------------------------------------------------------------------------------




	public static int getMindowHeight() {
		return MINDOW_HEIGHT;
	}
	public static int getMindowWidth() {
		return MINDOW_WIDTH;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
