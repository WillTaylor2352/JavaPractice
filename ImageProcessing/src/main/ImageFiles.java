package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageFiles {
	
	private static ArrayList<File> fileList;
	private ArrayList<BufferedImage> imgList;
	private String imagePath;
	
	public void setImagePath(String imagePath) {this.imagePath = imagePath;}
	public String getImagePath() {return imagePath;}
	
	public static ArrayList<File> getFileList() {return fileList;}
	
	public ImageFiles(){
		fileList = new ArrayList<File>();
		imgList = new ArrayList<BufferedImage>();
	}
	
	
	public void ReadImageFiles(final File folder){
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) { 					// if folder is found, 
	        	ReadImageFiles(fileEntry); 					// read contents of folder
	        } else {										// otherwise
	        	fileList.add(fileEntry);					// add fileEntry to fileList
	            System.out.println(fileEntry.getName());	// print the name
	        }
	    }
	    System.out.println(fileList);
	}
}
