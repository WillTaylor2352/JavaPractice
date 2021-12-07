package main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

	private static ImageFiles myfiles; 
	int width = 300, height = 500;
	static int currentIndex = 0;
	static ImageIcon statImgIcon;
	
	public static void main(String[] args) {
	
		myfiles = new ImageFiles();
		myfiles.setImagePath("Images");
		
		final File folder = new File(myfiles.getImagePath());
		myfiles.ReadImageFiles(folder);
		
		MakeFrame();
		
		//JFrame myframe = new JFrame();
		//myframe.setVisible(true);
		
		/*
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        new Main().setVisible(true);
		    }
		});		
		//*/
	}
	
	public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);
 
        JButton b1 = new JButton("one");
        JButton b2 = new JButton("two");
        JButton b3 = new JButton("three");
 
        pane.add(b1);
        pane.add(b2);
        pane.add(b3);
 
        Insets insets = pane.getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25 + insets.left, 5 + insets.top,
                     size.width, size.height);
        size = b2.getPreferredSize();
        b2.setBounds(55 + insets.left, 40 + insets.top,
                     size.width, size.height);
        size = b3.getPreferredSize();
        b3.setBounds(150 + insets.left, 15 + insets.top,
                     size.width + 50, size.height + 20);
    }
	
	public static void MakeFrame() {
		 //Create and set up the window.
        JFrame frame = new JFrame("AbsoluteLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Size and display the window.
        Insets insets = frame.getInsets();
        frame.setSize(300 + insets.left + insets.right,
                      125 + insets.top + insets.bottom);
        frame.setVisible(true);
		/*
		JFrame myframe = new JFrame();
		myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myframe.setSize(300,500);
		//myframe.setLayout(null);
		
		JPanel mypanel = new JPanel();
		//mypanel.setLayout(null);
		
		JLabel myJLabel = new JLabel("I am a label");
		
		Button btn1 = new Button("hello");
		
		mypanel.add(myJLabel);
		mypanel.add(btn1);
		
		myframe.add(mypanel);
		
		
		myframe.setVisible(true);
	//*/
	}
	
	public Main() {
	
		JPanel thisPanel = new JPanel();
		this.setLayout(new GridBagLayout());
		//this.setLayout(null);
		this.setSize(width, height);
		
        try {
        	//this.add(thisPanel);
        	
        	JLabel jLabel = new JLabel();
        	Button bLeft = new Button("<-");
        	Button bRight = new Button("->");
        	
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
			
			this.getContentPane().add(jLabel);
			this.getContentPane().add(bLeft);
			this.getContentPane().add(bRight);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
