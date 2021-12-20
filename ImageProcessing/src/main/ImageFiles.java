package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.*;
import javax.swing.ImageIcon;

public class ImageFiles {
	
	private static ArrayList<File> fileList;
	private ArrayList<BufferedImage> imgList;
	private ArrayList<BufferedImage> processedImages;
	private String imagePath;
	private int targetImageWidth, targetImageHeight;
	
	public void setImagePath(String imagePath) {this.imagePath = imagePath;}
	public String getImagePath() {return imagePath;}

	public static ArrayList<File> getFileList() {return fileList;}

	public ArrayList<BufferedImage> getImageList(){return imgList;}
	
	public ArrayList<BufferedImage> getProcessedImage(){return processedImages;}
	
	public void setTargetImageSize(int targetImageWidth, int targetImageHeight) {
		this.targetImageWidth = targetImageWidth; 
		this.targetImageHeight = targetImageHeight;
	}
	
	
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
	            //System.out.println(fileEntry.getName());	// print the name
	        }
	    }
	    LoadImageList(fileList);
	    try {
	    	GUI.setJLabelSize(targetImageWidth, targetImageHeight);
	    	ResizeImages(imgList, targetImageWidth, targetImageHeight);
	    	processedImages = new ArrayList<BufferedImage>();
	    	ConvertedImage ci = new ConvertedImage();
	    	processedImages.add(ci.convertImage(imgList.get(0)));
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    //System.out.println(fileList);
	}
	
	private void LoadImageList(ArrayList<File> thesefiles){
		for (File f: thesefiles) {
			try {
				imgList.add(ImageIO.read(f));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void ResizeImages(ArrayList<BufferedImage> originalImages, int targetWidth, int targetHeight) throws IOException {
		int index = 0;
	    
		for(BufferedImage bi: imgList) {
	    	BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    	Graphics2D graphics2D = resizedImage.createGraphics();
	    	graphics2D.drawImage(bi, 0, 0, targetWidth, targetHeight, null);
	    	graphics2D.dispose();
	    	imgList.set(index, resizedImage);
	    	
	    	index++;
	    }
	    
	}
	
	public ImageIcon NextImage(int currIndex) {
		ImageIcon i;
		if(currIndex+1 > imgList.size()-1)
			i = new ImageIcon(imgList.get(0));
		else 
			i = new ImageIcon(imgList.get(currIndex+1));
		
		return i;
	}
	
	public ImageIcon PreviousImage(int currIndex) {
		ImageIcon i;
		if (currIndex-1 < 0)
			i = new ImageIcon(imgList.get(imgList.size()-1));
		else
			i = new ImageIcon(imgList.get(currIndex-1));
		
		return i;
	}
	
}
