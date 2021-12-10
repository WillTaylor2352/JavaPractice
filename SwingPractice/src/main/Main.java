package main;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("Hello"); // construct a MyFrame object
		frame.setVisible( true );             // ask it to become visible
		
	}

}

class MyFrame extends JFrame{
	JPanel mypanel;
	JLabel mylabel;
	
	MyFrame(String title){
		super(title);
		setSize(300, 450);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    
	    setLayout( new FlowLayout() );       // set the layout manager
	    mylabel = new JLabel("Hello Swing!");  // construct a JLabel
	    add( mylabel );                        // add the label to the JFrame
		
	}
}