package main;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

	private static ImageFiles myfiles; 
	int width = 300, height = 450;
	static int currentIndex = 0;
	static ImageIcon statImgIcon;
	
	public static void main(String[] args) {
	
		myfiles = new ImageFiles();
		myfiles.setImagePath("Images");
		
		final File folder = new File(myfiles.getImagePath());
		myfiles.ReadImageFiles(folder);
		
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        new Main().setVisible(true);
		    }
		});		

	}
	
	public Main() {
		
		
		this.setLayout(new FlowLayout());
		this.setSize(width, height);
		
        try {
        	JLabel jLabel = new JLabel();
        	Button bLeft = new Button("<-");
        	Button bRight = new Button("->");
        	
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
			
			this.add(jLabel);
			this.add(bLeft);
			this.add(bRight);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
