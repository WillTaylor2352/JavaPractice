package main;

import java.awt.*;
import java.awt.image.BufferedImage;

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
	    ImageIcon ii = new ImageIcon();
	    BufferedImage bi = new BufferedImage(150,300,BufferedImage.TYPE_INT_RGB);
	    int rgb = 0;
	    int Red = 0, Green = 0, Blue = 0;
	    int red = 255, green = 255, blue = 0;	    
	    for (int y = 0; y < bi.getHeight(); y++) {
	    	for(int x = 0; x < bi.getWidth(); x++) {
	    		
	    		Red = (red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff 
	    	    Green = (green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
	    	    Blue = blue & 0x000000FF; //Mask out anything not blue.

	    	    rgb =  (0xFF000000 | Red | Green | Blue);
	    	    
	    		bi.setRGB(x, y, rgb);//Color.white.getRGB());
	    	}
	    }
	    //int colorinttest = Color.red.getRGB();
	    //System.out.println(colorinttest);
	    ii.setImage(bi);
	    
	    mylabel.setIcon(ii);
	}
}