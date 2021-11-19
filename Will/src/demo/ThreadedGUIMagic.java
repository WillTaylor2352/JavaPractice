package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ThreadedGUIMagic extends Thread {
	
	private Graphics g;
	
	public ThreadedGUIMagic(Graphics g){this.g = g;}
	
	public void run() {
		PerformGraphicalMagic();
	}
	private void PerformGraphicalMagic() {
		int xStart = 50, yStart = 50;
		int width = 20, height = 20;
		int xIncrement = 10;
		int yIncrement = 10;
		Rectangle blarp = new Rectangle(xStart, yStart, width, height);
	    g.setColor(Color.black);  
		for (int i = 0; i < 15; i++) {
			g.drawRect((int) blarp.getX(), (int) blarp.getY(), width, height);
    		g.fillRect((int) blarp.getX(), (int) blarp.getY(), width, height);	  
			width += xIncrement;
			height += yIncrement;
		
			
		}
		
		
	}
}
