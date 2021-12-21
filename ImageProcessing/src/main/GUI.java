package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	
	private static JFrame myframe;
	//JPanel mypanel;
	//JLabel mylabel;
	int width = 1500;
	int height = 1000;
	static int currentIndex = 0;
	static ImageIcon statImgIcon;
	private ImageFiles myfiles = null;
	public static int JLabelSizeX, JLabelSizeY;
	
	public void setImageFiles(ImageFiles myfiles) {this.myfiles = myfiles;}
	public ImageFiles getImageFiles() {return myfiles;}
	public static void setJLabelSize(int x, int y) {JLabelSizeX = x; JLabelSizeY = y;}
	
	
	public GUI() {
		myframe = new JFrame();
		myframe.setVisible(true);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public void MakeFrame(String title) {
				
		try {
			//JPanel thisPanel = new JPanel();
			JLabel jLabel = new JLabel();
			JButton bLeft = new JButton("<-");
			JButton bRight = new JButton("->");
			Container pane = myframe.getContentPane();
			Insets insets = myframe.getContentPane().getInsets();
			
			pane.setLayout(null);
			myframe.setSize(insets.left + insets.right + width, insets.top + insets.bottom + height);
			
			//thisPanel.setBackground(Color.pink);
			//thisPanel.setSize(myframe.getSize());
			
			//pane.add(thisPanel);
			pane.add(jLabel);
			pane.add(bLeft);
			pane.add(bRight);
			
			Dimension size = bLeft.getPreferredSize();
			bLeft.setBounds(width/2 - size.width, insets.top + myframe.getHeight() - 100, size.width, size.height);
			
			size = bRight.getPreferredSize();
			bRight.setBounds(width/2, insets.top + myframe.getHeight() - 100, size.width, size.height);
			
			//bLeft.setSize(30, 30);
			//bRight.setSize(30, 30);
		//	
			size = jLabel.getPreferredSize();
			jLabel.setBounds(width/2 - JLabelSizeX/2, insets.top + 10, size.width+this.JLabelSizeX, size.height+this.JLabelSizeY+20);
			
			//statImgIcon = new ImageIcon(myfiles.getImageList().get(currentIndex));
			statImgIcon = new ImageIcon(myfiles.getProcessedImage().get(currentIndex));
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
		//*/
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
