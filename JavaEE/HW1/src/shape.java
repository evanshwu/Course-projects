
public abstract class shape{
	private double width;
	private double length;
	private double height;
	private double[] vertex;
	
	public shape(){
		
	}
	
	public shape(double length){
		// why length only? the shape cube is length = height = width, so technically they are all the same
		// which means, this one is for circle, sphere, and cube only LOL what a pitty
		this.setLength(length);
	}
	
	public shape(double width, double length){
		// 2D shapes
		this.setWidth(width);
		this.setLength(length);
	}
	
	// ...and again, if I add this one, which is a 3D shape only function, those 2D guys will be required to 
	// assign this function, so um, yup....looks like we gotta add this dude into ThreeDimensionShape.java
	/*
	public shape(double width, double length, double height){
		this.setWidth(width);
		this.setLength(length);
		this.setHeight(height);
	}
	*/
	
	public void setWidth(double width){
		this.width = width;
	}
	
	public void setLength(double length){
		this.length = length;
	}
	
	public void setHeight(double height){
		this.height= height;
	}
	
	public void setVertex(double[] vertex){
		this.vertex = vertex;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getLength(){
		return this.length;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public double[] getVertex(){
		return this.vertex;
	}
	
	public abstract double getArea();
	public abstract String getResult();
	//public abstract double getVolume();
	
}
