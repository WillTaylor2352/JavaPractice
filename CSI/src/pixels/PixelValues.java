
package pixels;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import demo.*;

public class PixelValues {

	//private ArrayList<Object> List1;
	private int red, green, blue;
	private int imageSize;
	private static int collectionCounter = 0;
	private static int getFilePos = 0; // used for testing
	
	private static ArrayList<ArrayList<IndividualPixel>> CollectionOfPixels = new ArrayList<ArrayList<IndividualPixel>>(); // referred to as s1 in notes (each image in the s1's)
	private ArrayList<IndividualPixel> IndvPixelList = new ArrayList<IndividualPixel>(); // referred to as s2 in notes (each pixel of s1's in here)

	private static ArrayList<File> tmpFileList = ImageProcessing.getFileList();  // code used for testing (Ensuring that it is capturing pixels from each picture properly)
		
	// getters for above
	public int getRed() {return this.red;}
	public int getGreen() {return this.green;}
	public int getBlue() {return this.blue;}

	// these are referred to later by ratios for human understanding of how color works
	private static int redTest;
	private static int orangeTest;
	private static int yellowTest;
	private static int greenTest;
	private static int blueTest;
	private static int purpleTest;
	private static int pinkTest;
	private static int brownTest;
	private static int blackTest;
	private static int whiteTest;
	private static int grayTest;
	
	public int getRedTest()		{return this.redTest;}
	public int getOrangeTest()	{return this.orangeTest;}
	public int getYellowTest()	{return this.yellowTest;}
	public int getGreenTest()	{return this.greenTest;}
	public int getBlueTest()	{return this.blueTest;}
	public int getPurpleTest()	{return this.purpleTest;}
	public int getPinkTest()	{return this.pinkTest;}
	public int getBrownTest()	{return this.brownTest;}
	public int getBlackTest()	{return this.blackTest;}
	public int getWhiteTest()	{return this.whiteTest;}
	public int getGrayTest()	{return this.grayTest;}
		
	public void setRedTest		(int newRed)	{this.redTest = newRed;}
	public void setOrangeTest	(int newOrange)	{this.orangeTest = newOrange;}
	public void setYellowTest	(int newYellow)	{this.yellowTest = newYellow;}
	public void setGreenTest	(int newGreen)	{this.greenTest = newGreen;}
	public void setBlueTest		(int newBlue)	{this.blueTest = newBlue;}
	public void setPurpleTest	(int newPurple)	{this.purpleTest = newPurple;}
	public void setPinkTest		(int newPink)	{this.pinkTest = newPink;}
	public void setBrownTest 	(int newBrown)	{this.brownTest = newBrown;}
	public void setBlackTest	(int newBlack)	{this.blackTest = newBlack;}
	public void setWhiteTest	(int newWhite)	{this.whiteTest = newWhite;}
	public void setGrayTest		(int newGray)	{this.grayTest = newGray;}
	
	public PixelValues(){}
	
	public PixelValues(BufferedImage tmpBufferedImage){
	
		try{	

		System.out.println("This is the file being processed: " + tmpFileList.get(getFilePos).getName());
		
		for (int i = 0; i < tmpBufferedImage.getWidth(); i++) {
			for (int j = 0; j < tmpBufferedImage.getHeight(); j++) {
				
				int color;
				color = tmpBufferedImage.getRGB(i, j);
				Color c  = new Color(color);
				//color is the RGB components of color
				
				this.red = c.getRed();
				this.green = c.getGreen();						
				this.blue = c.getBlue();
				
				IndvPixelList.add(new IndividualPixel(this.red, this.green, this.blue)); // adds IndividualPixel Object to IndvPixel List
				
				ColorCounter temp = new ColorCounter();
				temp.colorCounter(this.red, this.green, this.blue);
				
				imageSize++; // keeps track of how many pixels have been processed
				try{
					if(imageSize == (tmpBufferedImage.getWidth() * tmpBufferedImage.getHeight())){ // only if the full file has been processed will these instances occur (this is more for testing than anything else)
						getFilePos++;
					//	System.out.println("This is how many pixels out of " + (tmpBufferedImage.getWidth() * tmpBufferedImage.getHeight()) + " have been processed: " + imageSize);
						System.out.println("This is how many pixels there are : "+ imageSize);

					}
					
				} catch (Exception E){
					E.printStackTrace();
				}
				
				
			}
		}
		
	/*	
		CollectionOfPixels.add(IndvPixelList);
	/*	System.out.println("This is the number of images currently processed: " + CollectionOfPixels.size());
		System.out.println("These are the values for the first pixel of each image: " + CollectionOfPixels.get(collectionCounter).get(0).toString());
		System.out.println("This is the ratio of the pixels: " + CollectionOfRatios.get(collectionCounter).get(0).toString());
		//System.out.println(this.gcd);
		if (collectionCounter == 0 ){
			System.out.println("\rThese Images are all only one color (with the exception of the Vending machine).");
		} 
	*/
	//	System.out.println(CollectionOfPixels.get(collectionCounter).size());
		
		System.out.println("yellow: " + yellowTest + "\rorange: " + orangeTest + 
						   "\rred: " + redTest + "\rwhite: " + whiteTest);
		
		redTest = 0; orangeTest = 0; yellowTest = 0; greenTest = 0; blueTest = 0; purpleTest = 0; blackTest = 0; whiteTest = 0; grayTest = 0;
		
		System.out.println("\r---------------------------------------------------\r");
		collectionCounter++; // this is here to advance between the images in the Pixel and Ratio s1 arrays
	
		}catch(Exception E){
			E.printStackTrace();
		}
		//gcd(214, 210);
	}
	
	/*public int gcd(int a, int b){
		
		try{
		// this if in the case of one or more values being 0, otherwise a stack Overflow error will be  thrown
		if(a == 0 || b == 0){
			if (this.red == 0 || this.green == 0 || this.blue == 0){
				if (this.red == 0) this.red += 2;
				if (this.green == 0) this.green += 2;
				if (this.blue == 0) this.blue += 2;
			}
			if (a == 0) a += 2;
			if (b == 0) b += 2;
			gcd(a , b);
		} 
		
		if (a % 2 != 0 || b % 2 != 0){
			if (a % 2 != 0) a++;
			if (b % 2 != 0) b++;
			gcd(a , b);
		}
		
		if (((double) a / (double) b) == 1.0){
			this.gcd = a;
		} else {
			this.gcd = gcd(Math.max(a, b) - Math.min(a, b), Math.min(a, b));
		}
		} catch(StackOverflowError e){e.printStackTrace();}
		return this.gcd;
	
	}*/
}
