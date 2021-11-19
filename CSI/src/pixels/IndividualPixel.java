
package pixels;

public class IndividualPixel {

	private int red;
	private int green;
	private int blue;
	
	//private ArrayList<Integer> PixelArrayList = new ArrayList<Integer>();	
	
	public IndividualPixel(){}
	
	public IndividualPixel(int red, int green, int blue){
		
		this.red = red;
		this.green = green;
		this.blue = blue;
		
		int[] values = new int[3];
		values[0] = red;
		values[1] = green;
		values[2] = blue;
	
	}
	
	public int getRed() {return this.red;}
	public int getGreen() {return this.green;}
	public int getBlue() {return this.blue;}
	
	@Override
	public String toString(){
		
		return "red: " + red + ", blue: " + blue + ", green: " + green;
	}
	
}
