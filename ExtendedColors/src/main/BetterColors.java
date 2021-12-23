package main;

import java.awt.Color;

/** Better Colors extending Java AWT Color class
 * @author Will Taylor
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BetterColors extends Color{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6655892849297301432L;
	
	
	public BetterColors(int rgb) {
		super(rgb);
	}
	public BetterColors(int red, int green, int blue) {
		super(red,green,blue);
		
	}
	public BetterColors(int alpha, int red, int green, int blue) {
		super(red, green, blue, alpha);
	}
	/** Converts a color to Hue, Saturation, and Vibrancy (sometimes called brightness). Returns a float array of these values
	 * @param c Color to be converted to HSV values
	 * @return float[] Contains the values [0]-hue | [1]-saturation | [2]-vibrancy
	 */
	public double[] colorToHSV(Color c){
		int rgb=0,r=0, g=0, b=0;
		double h, s, v;
		float min, max, delta;
		rgb=c.getRGB();//
		r = (rgb >> 16) & 0x000000FF;
		g = (rgb >> 8) 	& 0x000000FF;
		b = (rgb) 		& 0x000000FF;
		min = Math.min(Math.min(r, g), b);
		max = Math.max(Math.max(r, g), b);
		v = max;
		delta = max - min;
		
		if (max != 0)
            s = delta / max;
        else {
            s = 0;
            h = -1;
            return new double[]{h, s, v};
        }
		
		if (r == max)
            h = (g - b) / delta; // between yellow & magenta
        else if (g == max)
            h = 2 + (b - r) / delta; // between cyan & yellow
        else
            h = 4 + (r - g) / delta; // between magenta & cyan
		
		h *= 60; // degrees

        if (h < 0)
            h += 360;

        h = h * 1.0;
        s = s * 100.0;
        v = (v / 256.0) * 100.0;
        return new double[] {h, s, v};
	}
	
}
