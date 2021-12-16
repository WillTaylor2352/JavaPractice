package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.File;
import javax.swing.*;

public class Main{

	private static ImageFiles myfiles; 
	
	private static void createAndShowGUI() {
		JFrame myframe = new JFrame();
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = myframe.getContentPane();
		pane.setLayout(null);
		
		JLabel mylabel = new JLabel("Hello World");
		Insets insets = myframe.getContentPane().getInsets();
		
		pane.add(mylabel);
		
		Dimension size = mylabel.getPreferredSize();
		mylabel.setBounds(100 + insets.left, 250 + insets.top, size.width+20, size.height+20);
		//*/
		myframe.setSize(300 + insets.left + insets.right, 500 + insets.top + insets.bottom);
		
		//myframe.pack();
		myframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		myfiles = new ImageFiles();
		myfiles.setImagePath("Images");
		
		final File folder = new File(myfiles.getImagePath());
		myfiles.setTargetImageSize(150, 300);
		myfiles.ReadImageFiles(folder);
		
		
		/*
		GUI mygui = new GUI();
		mygui.setImageFiles(myfiles);
		mygui.MakeFrame("Gibbeh");
		//*/ 
	
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		    	//createAndShowGUI();
		
				GUI mygui = new GUI();
				mygui.setImageFiles(myfiles);
				mygui.MakeFrame("Gibbeh");
		//*/
		    
		    }
		});		
	}
	
	
	
}
