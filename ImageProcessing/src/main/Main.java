package main;

import java.io.File;

public class Main {

	private static ImageFiles myfiles; 

	public static void main(String[] args) {
		
		myfiles = new ImageFiles();
		myfiles.setImagePath("Images");
		
		final File folder = new File(myfiles.getImagePath());
		myfiles.ReadImageFiles(folder);

	}

}
