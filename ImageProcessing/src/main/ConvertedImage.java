package main;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ConvertedImage {

	public BufferedImage oldimage, newimage;
	
	public void setOldImage(BufferedImage old) {oldimage = old;}
	
	public ConvertedImage() {
		oldimage = null; 
		newimage = null;
	}
	
	public ConvertedImage(BufferedImage oi) {
		oldimage = oi;
		newimage = convertImage(oi);
	}
	
	public  BufferedImage convertImage(BufferedImage oi) {
		BufferedImage thisconversion = new BufferedImage(oi.getWidth(), oi.getHeight(), BufferedImage.TYPE_INT_RGB);
		Color c = new Color(0);
		int red= 0, green = 0, blue = 0;
		double[] myhsv = {0,0,0};
		try {
			for(int y = 0; y < oi.getHeight(); y++) {
				for(int x = 0; x < oi.getWidth(); x++) {
					c = new Color(oi.getRGB(x, y));
					red = 	c.getRed();
					green = c.getGreen();
					blue = 	c.getBlue();
					
					myhsv = RGBtoHSV(red, green, blue);
					
					//System.out.println("hue: " + myhsv[0] + ", sat: " + myhsv[1] + ", vib: " + myhsv[2] + " --- pixel @ loc: " + x + ", " + y + " ");
					//System.out.print(" --- pixel @ loc: " + x + ", " + y + " ");
					
					c = truecolor(myhsv[0], myhsv[1], myhsv[2]);
					thisconversion.setRGB(x, y, c.getRGB());
					
				}
			}
			
		}
		catch(Exception e) {
			
		}
		
		return thisconversion;
	}
	
	private  Color truecolor(double hue, double saturation, double vibrancy) {
		Color c = hueTest(hue);
		c = greyCheck(c, saturation, vibrancy);
		
		
		return c;
	}
	
	private  Color hueTest(double hue) {
		
		if(0 < hue && hue < 25)
			return Color.red;//red
		else if (25 <= hue && hue < 40)
			return Color.orange; // orange
		else if (40 <= hue && hue < 80)
			return Color.yellow; // yellow
		else if (80 <= hue && hue < 150)
			return Color.green; // green
		else if (150<= hue && hue < 200)
			return Color.cyan;// cyan
		else if (200<= hue && hue < 270)
			return Color.blue;// blue
		else if (270<= hue && hue < 330)
			return Color.magenta;// purple 
		else if (330<= hue && hue <=360)
			return Color.red;//red
		else 
			return Color.GRAY;
		
	}
	
	private Color greyCheck(Color colorfromhue, double saturation, double vibrancy) {
		//TODO should I flip the list? Do a vibrancy check first then do a saturation check? 
		if(vibrancy < 20) 
			return Color.black;
		else if (vibrancy < 30) 
			return Color.darkGray;
		else if (vibrancy < 45 && saturation < 25)
			return Color.gray;
		else if (vibrancy < 45 && saturation >= 25)
			return colorfromhue;
		else if (vibrancy >= 45 && vibrancy < 75 && saturation < 20)
			return Color.gray;
		else if (vibrancy >= 45 && vibrancy < 75 && saturation >= 20)
			return colorfromhue;
		else if (vibrancy >= 75 && vibrancy < 90 && saturation < 20)
			return Color.gray;
		else if (vibrancy >= 75 && vibrancy < 90 && saturation >= 20)
			return colorfromhue;
		else if (vibrancy >= 90 && saturation < 20)
			return Color.white;
		else 
			return colorfromhue;
		
		
/*
		if (saturation < 5) {
			if (vibrancy < 15)
				return Color.black;
			else if (vibrancy < 30)
				return Color.DARK_GRAY;
			else if (vibrancy < 55)
				return Color.gray;
			else if (vibrancy < 80)
				return Color.LIGHT_GRAY;
			else 
				return Color.white;
		}
		else if (saturation < 30) {
			if (vibrancy < 15)
				return Color.black;
			else if (vibrancy < 30) 
				return Color.darkGray;
			else if (vibrancy < 55)
				return Color.gray; //return new Color(average);
			else 
				return colorfromhue;
		}
		else if (saturation < 50) {
			if (vibrancy < 15)
				return Color.black;
			else if (vibrancy < 30) 
				return Color.darkGray;
			else 
				return colorfromhue;
		}
		else
			return colorfromhue;
//*/	
	}
//*/
	public  double[] RGBtoHSV(double red, double green, double blue) {

        double hue, saturation, vibrancy;

        double min, max, delta;

        min = Math.min(Math.min(red, green), blue);
        max = Math.max(Math.max(red, green), blue);

        // V
        vibrancy = max;

        delta = max - min;

        // S
        if (max != 0)
            saturation = delta / max;
        else {
            saturation = 0;
            hue = -1;
            return new double[] { hue, saturation, vibrancy };
        }

        // H
        if (red == max)
            hue = (green - blue) / delta; // between yellow & magenta
        else if (green == max)
            hue = 2 + (blue - red) / delta; // between cyan & yellow
        else
            hue = 4 + (red - green) / delta; // between magenta & cyan

        hue *= 60; // degrees

        if (hue < 0)
            hue += 360;

        hue = hue * 1.0;
        saturation = saturation * 100.0;
        vibrancy = (vibrancy / 256.0) * 100.0;
        return new double[] { hue, saturation, vibrancy };
    }
	
	private int RGBtoInt(int red, int green, int blue) {
		//int thisint = 0;
		int redhold, greenhold, bluehold;
		redhold = (red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
	    greenhold = (green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
	    bluehold = blue & 0x000000FF; //Mask out anything not blue.

	    return 0xFF000000 | redhold | greenhold | bluehold; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
	}
}
