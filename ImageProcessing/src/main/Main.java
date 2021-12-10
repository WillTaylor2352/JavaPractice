package main;

import java.io.File;

public class Main{

	private static ImageFiles myfiles; 
	
	public static void main(String[] args) {
		
		myfiles = new ImageFiles();
		myfiles.setImagePath("Images");
		
		final File folder = new File(myfiles.getImagePath());
		myfiles.ReadImageFiles(folder);
		
		GUI mygui = new GUI();
		mygui.setImageFiles(myfiles);
		mygui.MakeFrame("Gibbeh");
		
		/*SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		    	
		    }
		});		
		//*/
	}
	
	
	
}
