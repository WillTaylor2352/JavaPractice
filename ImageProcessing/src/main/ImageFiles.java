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
	    	ResizePreserve(imgList, targetImageWidth, targetImageHeight);
	    	ConvertedImage ci = new ConvertedImage();
		    ci.setOiList(imgList);
		    ci.multiConvert();
	    	processedImages = new ArrayList<BufferedImage>();
	    	LoadProcessedImageList(ci.getProcessedImages());	
	    	//processedImages.add(ci.getProcessedImages().get());
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
	private void LoadProcessedImageList(ArrayList<BufferedImage> thesefiles){
		for (BufferedImage f: thesefiles) {
			try {
				processedImages.add(f);
			} catch (Exception e) {
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
	private void ResizePreserve(ArrayList<BufferedImage> originalImages, int targetWidth, int targetHeight) throws IOException {
		int index = 0; 
		BufferedImage resizedImage;
		for (BufferedImage bi: originalImages) {
			resizedImage = new BufferedImage(
					(int)Math.floor(bi.getWidth()), 
					(int)Math.floor(bi.getHeight()), 
					BufferedImage.TYPE_INT_RGB
					);
			if(bi.getWidth() > targetWidth || bi.getHeight() > targetHeight) {
				
				do {
				resizedImage = new BufferedImage(
						(int)Math.floor(resizedImage.getWidth()*.95), 
						(int)Math.floor(resizedImage.getHeight()*.95), 
						BufferedImage.TYPE_INT_RGB
						);
					//Math.round(Math.floor(targetWidth*.9));
			    	Graphics2D graphics2D = resizedImage.createGraphics();
			    	graphics2D.drawImage(bi, 0, 0, (int)Math.floor(resizedImage.getWidth()*.95), (int)Math.floor(resizedImage.getHeight()*.95), null);
			    	graphics2D.dispose();
			    	System.out.println(resizedImage.getHeight());
				}while (resizedImage.getWidth() > targetWidth || resizedImage.getHeight() > targetHeight);
				imgList.set(index, resizedImage);
			}
			else if(bi.getWidth() < targetWidth || bi.getHeight() < targetHeight) {
				do {
					resizedImage = new BufferedImage(
							(int)Math.floor(resizedImage.getWidth()*1.05), 
							(int)Math.floor(resizedImage.getHeight()*1.05), 
							BufferedImage.TYPE_INT_RGB
							);
						//Math.round(Math.floor(targetWidth*.9));
				    	Graphics2D graphics2D = resizedImage.createGraphics();
				    	graphics2D.drawImage(bi, 0, 0, (int)Math.floor(resizedImage.getWidth()*1.05), (int)Math.floor(resizedImage.getHeight()*1.05), null);
				    	graphics2D.dispose();
				    	//System.out.println(resizedImage.getHeight());
					}while (resizedImage.getWidth() < targetWidth && resizedImage.getHeight() < targetHeight);
					imgList.set(index, resizedImage);	
			}
			
			index++;
		}
	}
	
	public ImageIcon NextOriginalImage(int currIndex) {
		ImageIcon i;
		if(currIndex+1 > imgList.size()-1)
			i = new ImageIcon(imgList.get(0));
		else 
			i = new ImageIcon(imgList.get(currIndex+1));
		
		return i;
	}
	public ImageIcon PreviousOriginalImage(int currIndex) {
		ImageIcon i;
		if (currIndex-1 < 0)
			i = new ImageIcon(imgList.get(imgList.size()-1));
		else
			i = new ImageIcon(imgList.get(currIndex-1));
		
		return i;
	}
	public ImageIcon NextProcessedImage(int currIndex) {
		ImageIcon i;
		if(currIndex+1 > imgList.size()-1)
			i = new ImageIcon(processedImages.get(0));
		else 
			i = new ImageIcon(processedImages.get(currIndex+1));
		
		return i;
	}
	public ImageIcon PreviousProcessedImage(int currIndex) {
		ImageIcon i;
		if (currIndex-1 < 0)
			i = new ImageIcon(processedImages.get(processedImages.size()-1));
		else
			i = new ImageIcon(processedImages.get(currIndex-1));
		
		return i;
	}
	
}
