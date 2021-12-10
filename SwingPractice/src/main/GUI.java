package main;

import java.awt.*;

import javax.swing.*;

public class GUI {
	
	private
	JPanel mypanel;
	JLabel mylabel;
	int width = 300, height = 500;
	static int currentIndex = 0;
	static ImageIcon statImgIcon;
	
	public GUI() {
	
	}
	
	public void MakeFrame(String title) {
		//super(title);
		
		//setSize(width, height);
		setBounds(50, 50, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		try {
			//this.add(thisPanel);
			JPanel thisPanel = new JPanel();
			JLabel jLabel = new JLabel();
			JButton bLeft = new JButton("<-");
			JButton bRight = new JButton("->");
			
			this.add(thisPanel);
			this.getContentPane().add(jLabel);
			this.getContentPane().add(bLeft);
			this.getContentPane().add(bRight);
			
			//this.getContentPane().setLayout(null);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension size = new Dimension(getPreferredSize());
			
			bLeft.setBounds(width-60, height-30, size.width, size.height);
			bRight.setBounds(width-30, height-30, size.width, size.height);
			
			
			//bLeft.setLocation(width-60, height-30);
			//bRight.setLocation(width-30, height-30);
			
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
