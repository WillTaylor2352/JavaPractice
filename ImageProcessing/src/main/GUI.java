package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	
	private static JFrame myframe;
	JPanel mypanel;
	JLabel mylabel;
	int width = 300, height = 500;
	static int currentIndex = 0;
	static ImageIcon statImgIcon;
	private ImageFiles myfiles = null;
	
	public void setImageFiles(ImageFiles myfiles) {this.myfiles = myfiles;}
	public ImageFiles getImageFiles() {return myfiles;}
	
	public GUI() {
		myframe = new JFrame();
		myframe.setVisible(true);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setLayout(new FlowLayout());
		myframe.setBounds(50, 50, width, height);
	}
	
	
	
	public void MakeFrame(String title) {
				
		try {
			JPanel thisPanel = new JPanel();
			JLabel jLabel = new JLabel();
			JButton bLeft = new JButton("<-");
			JButton bRight = new JButton("->");
			
			thisPanel.setBackground(Color.pink);
			thisPanel.setSize(myframe.getSize());
			
			myframe.add(thisPanel);
			thisPanel.add(jLabel);
			thisPanel.add(bLeft);
			thisPanel.add(bRight);
			
			
			bLeft.setSize(30, 30);
			bRight.setSize(30, 30);
			
			statImgIcon = new ImageIcon(myfiles.getImageList().get(currentIndex));
			jLabel.setText(myfiles.getFileList().get(currentIndex).getName());
			jLabel.setIcon(statImgIcon);
			
			jLabel.setHorizontalTextPosition(JLabel.CENTER);
			jLabel.setVerticalTextPosition(JLabel.BOTTOM);
			
			bLeft.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon i = myfiles.PreviousImage(currentIndex);
					if(currentIndex-1<0) 
						currentIndex = myfiles.getImageList().size()-1;
					else
						currentIndex--;
					
					jLabel.setIcon(i);
					jLabel.setText(myfiles.getFileList().get(currentIndex).getName());
				}
			});
			
			bRight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ImageIcon i = myfiles.NextImage(currentIndex);
					if(currentIndex+1>myfiles.getImageList().size()-1) 
						currentIndex = 0;
					else
						currentIndex++;
					
					jLabel.setIcon(i);
					jLabel.setText(myfiles.getFileList().get(currentIndex).getName());
				}
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
