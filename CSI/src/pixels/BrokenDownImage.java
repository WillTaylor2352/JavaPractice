package pixels;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BrokenDownImage {

	private ArrayList<BufferedImage> tenByTenCollector; 	
	
	public BrokenDownImage(BufferedImage tmpBufferedImage){
		
		BufferedImage tenByTen;
		
		for (int i = 0; i < tmpBufferedImage.getHeight() * tmpBufferedImage.getWidth(); i++){
			
			tenByTenCollector.add(new BufferedImage(10, 10,BufferedImage.TYPE_INT_RGB));
			
		}
		
		
		
	}
	
	
}
