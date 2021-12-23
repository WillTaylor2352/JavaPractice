package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		//MyFrame frame = new MyFrame("Hello"); // construct a MyFrame object
		//frame.setVisible( true );             // ask it to become visible
		JFrame myframe = new JFrame();
		myframe.setVisible(true);
		//JPanel mypanel;
		JLabel mylabel;
		
		myframe.setSize(300, 450);
		myframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    
	    myframe.setLayout( new FlowLayout() );       // set the layout manager
	    mylabel = new JLabel("Hello Swing!");  // construct a JLabel
	    myframe.add( mylabel );                        // add the label to the JFrame
	    ImageIcon ii = new ImageIcon();
	    BufferedImage bi = new BufferedImage(150,300,BufferedImage.TYPE_INT_RGB);
	    int rgb = 0;
	    int Red = 0, Green = 0, Blue = 0;
	    int red = 255, green = 255, blue = 0;	    
	    Color c1, c2;
	    for (int y = 0; y < bi.getHeight(); y++) {
	    	for(int x = 0; x < bi.getWidth(); x++) {
	    		/*
	    		Red = (red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff 
	    	    Green = (green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
	    	    Blue = blue & 0x000000FF; //Mask out anything not blue.

	    	    rgb =  (0xFF000000 | Red | Green | Blue);
	    	    */
	    		c1 = Color.cyan;
	    		c2 = Color.cyan;
	    		rgb = averageColors(c1, c2);
	    		//System.out.println(rgb);
	    		
	    		bi.setRGB(x, y, Color.cyan.getRGB());//Color.white.getRGB());
	    	}
	    }
	    //int colorinttest = Color.red.getRGB();
	    //System.out.println(colorinttest);
	    ii.setImage(bi);
	    
	    mylabel.setIcon(ii);
	}
	private static int averageColors(Color color1, Color color2) {
		int red1=0, green1=0, blue1=0;
		int red2=0, green2=0, blue2=0;
		int squarehold1=0, squarehold2=0;
		long adddivhold=0;
		int[] rgbaverageval = new int[3];
		
		red1 = color1.getRed();
		green1 = color1.getGreen();
		blue1 = color1.getBlue();
		int[] mycolors1 = {red1, green1, blue1};
		
		red2 = color2.getRed();
		green2 = color2.getGreen();
		blue2 = color2.getBlue();
		int[] mycolors2 = {red2, green2, blue2};
		
		for(int i = 0; i < mycolors1.length - 1; i++) {
			squarehold1 = mycolors1[i] * mycolors1[i];
			squarehold2 = mycolors2[i] * mycolors2[i];
			
			adddivhold = squarehold1 + squarehold2;
			//System.out.println(adddivhold);
			adddivhold = adddivhold / 2;
			//System.out.println(adddivhold);			
			rgbaverageval[i] = (int) Math.sqrt(adddivhold);
		}
		
		return RGBtoInt(rgbaverageval[0], rgbaverageval[1], rgbaverageval[2]);
	}
	private static int RGBtoInt(int red, int green, int blue) {
		//int thisint = 0;
		int redhold, greenhold, bluehold;
		redhold = (red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
	    greenhold = (green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
	    bluehold = blue & 0x000000FF; //Mask out anything not blue.

	    return 0xFF000000 | redhold | greenhold | bluehold; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
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