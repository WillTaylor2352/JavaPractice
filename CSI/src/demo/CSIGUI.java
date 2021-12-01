
// Some help from http://www3.ntu.edu.sg/home/ehchua/programming/java/J8b_Game_2DGraphics.html

package demo;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Reads 'documents' from a folder and slides them onto the screen. Every NCIS episode I've ever seen. 
 * @author Nicholson.Bill
 *
 */
public class CSIGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int mode, mode_idle = 0, mode_magical = 1;
	private int xStart = 50, yStart = 50;
	private int width = 20, height = 20;
	private int xIncrement = 10;
	private int yIncrement = 10;
	private int frameRate = 60;    // frame rate in frames per second
	private static ImageProcessing ip;

	// The smooth-ness of the document sliding. Higher number = smoother. 1000 is too high. 100-200 is nice.
	private int loopCount = 200; // also sets how fast images appear

	// The delay between sliding steps. 50 is OK. Higher value is longer delay.
	private int delay = 200; //sets time it takes for single image to load, better to fiddle with than loopcount

	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			//---sets folder path
					ip = new ImageProcessing();
					ip.setImagePath("Images");
					final File folder = new File(ip.getImagePath());
					ip.ReadImageFiles(folder);
					//ip.ReadImageList();
			//---ends set folder path
					
					//CSIGUI frame = new CSIGUI();
					//frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CSIGUI() {
		mode = mode_idle;
		JButton btnGo = new JButton();
		btnGo.setText("Go");
		btnGo.setSize(60, 60); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bill's original: 5, 5, 5, 5
		contentPane.setLayout(null);
		//btnGo.setLocation(422, 313);
		int xx = this.getWidth() - (btnGo.getWidth() * 3/2); // Bill's original: ...... -10
		int yy = this.getHeight() - (btnGo.getHeight() * 2); // Bill's original: ...... -50
		btnGo.setLocation(xx, yy);
		
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(btnGo);
		setContentPane(contentPane);
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = mode_magical;
				PerformMagic();
			}
		});
		
	}
	private void PerformMagic() {
		Thread animationThread = new Thread () {
	         int xOrigin = 5, yOrigin = 5; // sets where the images begin to animate in frame
	        
	         @Override
	         public void run() {
	        	 for (int j = 0; j < ip.getImageList().size(); j++) {
	        		 xStart = xOrigin;
	        		 yStart = yOrigin;
	        		 xOrigin += 100;
	        		 yOrigin += 35;
	        		 JLabel picLabel = new JLabel(new ImageIcon((BufferedImage)(ip.getImageList()).get(j)));
	        		 picLabel.setBounds(xStart,  yStart,  width,  height); // changes whether pictures move across screen
	        		 picLabel.setLocation(xStart, yStart);  // changes whether pictures move across screen
	        		 picLabel.setSize(0,0);
	        		 picLabel.setVisible(true); // makes images visible
	        		 getContentPane().add(picLabel);	// Add to the JPanel
	        		 // Component with highest Z-order paints first The lower z-order paints over the higher z-order
	        		 // Causes huge flashing unless you use getContentPane()! also sets which images appear
	        		 // over others
	        		 getContentPane().setComponentZOrder(picLabel, 0 );		 
	        		 width = 0;
	        		 height = 0;
	        		 // Adjust the x and y increments according to the current image, throws images off without
	        		 xIncrement = ((BufferedImage)(ip.getImageList()).get(0)).getWidth() / loopCount;
	        		 yIncrement = ((BufferedImage)(ip.getImageList()).get(0)).getHeight() / loopCount;
		        	 for (int i = 0; i < loopCount; i++) {
		        		 repaint();  // Refresh the display
		        		 //picLabel.setBounds(xStart,  yStart,  width,  height);
		        		 picLabel.setSize(width, height);
		        		 try {
		        			 Thread.sleep(delay / frameRate); // delay and yield to other threads
		        		 } catch (InterruptedException ex) { }
		        		 width += xIncrement;
		        		 height += yIncrement;
		        	 }
	        	 }
	         }
	      };
	      animationThread.start();  // start the thread to run animation	}
	}
	
	@Override
    public void paint(Graphics g) {
	    super.paint(g);
    	switch(mode) {
    	case 0:		// Idle
    		break;
    		
    	case 1:		// Magical
    		/*
    		Rectangle blarp = new Rectangle(xStart, yStart, width, height);
    	    g.setColor(Color.black);
   			g.drawRect((int) blarp.getX(), (int) blarp.getY(), width, height);
   			*/
       		//g.fillRect((int) blarp.getX(), (int) blarp.getY(), width, height);	  

    		break;

    	}
    }  
}
