package pixels;

import demo.*;

public class ColorCounter {
	
	PixelValues pixelValues = new PixelValues();
	
/* int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);
 * int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);
 * int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);
 * int newGreen = pixelValues.getGreenTest(); newGreen++; pixelValues.setGreenTest(newGreen);
 * int newBlue = pixelValues.getBlueTest(); newBlue++; pixelValues.setBlueTest(newBlue);
 * int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);
 * int newPink = pixelValues.getPinkTest(); newPink++; pixelValues.setPinkTest(newPink);
 * int newBrown = pixelValues.getBrownTest(); newBrown++; pixelValues.setBrownTest(newBrown);
 * int newBlack = pixelValues.getBlackTest(); newBlack++; pixelValues.setBlackTest(newBlack);
 * int newWhite = pixelValues.getWhiteTest(); newWhite++; pixelValues.setWhiteTest(newWhite);
 * int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);
 * */	
	
	public ColorCounter(){}
	
	public void colorCounter(int red, int green, int blue){
		
		if (red > 250){
			if (green > 250){
				if 		(blue > 230){int newWhite = pixelValues.getWhiteTest(); newWhite++; pixelValues.setWhiteTest(newWhite); }
				else if	(blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 240){
				if 		(blue > 250){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 230){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 230){
				if 		(blue > 250){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 220){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 200){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 220){
				if 		(blue > 240){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 180){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 210){
				if 		(blue > 230){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 200){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 90)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 200){
				if 		(blue > 220){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 200){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 80)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 190){
				if 		(blue > 230){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 200){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 180){
				if		(blue > 210){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 170){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 170){
				if 		(blue > 215){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 170){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 160){
				if 		(blue > 215){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 145){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 150){
				if 		(blue > 200){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 135){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 140){
				if 		(blue > 185){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 130){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 130){
				if 		(blue > 170){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 120){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 120){
				if 		(blue > 165){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 100){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 110){
				if 		(blue > 150){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 90){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 100){
				if 		(blue > 150){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 90)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 90 ){
				if 		(blue > 140){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 85)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 80 ){
				if 		(blue > 135){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 70)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 70 ){
				if 		(blue > 130){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 65)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 60 ){
				if 		(blue > 120){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 50)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 50 ){
				if 		(blue > 110){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 45)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0)	{int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 40 ){
				if 		(blue > 100){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 0)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
			}
			else if (green > 0  ){
				if 		(blue > 100){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 0)	{int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
			}
		}
		else if (red > 240){
			if (green > 250){
				if 		(blue > 250){int newWhite = pixelValues.getWhiteTest(); newWhite++; pixelValues.setWhiteTest(newWhite);}
				else if (blue > 230){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 240){
				if 		(blue > 220){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 230){
				if 		(blue > 250){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 215){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 220){
				if 		(blue > 245){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 205){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 210){
				if 		(blue > 240){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 205){int newGray = pixelValues.getGrayTest(); newGray++; pixelValues.setGrayTest(newGray);}
				else if (blue > 180){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 200){
				if 		(blue > 220){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 160){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}				
			}
			else if (green > 190){
				if 		(blue > 220){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 195){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 110){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 180){
				if 		(blue > 210){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 175){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 100){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 170){
				if 		(blue > 180){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 170){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 90){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 160){
				if 		(blue > 160){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 120){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 50){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
				else if (blue > 0)	{int newYellow = pixelValues.getYellowTest(); newYellow++; pixelValues.setYellowTest(newYellow);}
			}
			else if (green > 150){
				if 		(blue > 160){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 120){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 140){
				if 		(blue > 135){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 110){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
			else if (green > 130){
				if 		(blue > 135){int newPurple = pixelValues.getPurpleTest(); newPurple++; pixelValues.setPurpleTest(newPurple);}
				else if (blue > 110){int newRed = pixelValues.getRedTest(); newRed++; pixelValues.setRedTest(newRed);}
				else if (blue > 0){int newOrange = pixelValues.getOrangeTest(); newOrange++; pixelValues.setOrangeTest(newOrange);}
			}
		}
	}
}
