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
		
		
		
		return c;
	}
	
	private  Color hueTest(double hue) {
		
		if(0 < hue && hue < 27)
			return Color.red;//red
		else if (27 <= hue && hue < 48)
			return Color.orange; // orange
		else if (48 <= hue && hue < 67)
			return Color.yellow; // yellow
		else if (67 <= hue && hue < 135)
			return Color.green; // green
		else if (135<= hue && hue < 200)
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
/*	
	private Color satChec() {
		
	}
	private Color vibCheck(Color colorfromhue, double vibrancy) {
		if(vibrancy <= 20)
			return Color.black;
		else if (vibrancy > 20 && vibrancy <= 45)
			return 
	}
*/
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
}
