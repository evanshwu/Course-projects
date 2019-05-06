
public class Triangle extends TwoDimensionalShape{
	
	public Triangle(double width, double length) {
		super(width, length);
	}

	public double getArea(){
		return super.getLength() * super.getWidth() * 0.5;
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.getArea();
	}
}
