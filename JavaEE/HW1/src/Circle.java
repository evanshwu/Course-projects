
public class Circle extends TwoDimensionalShape{
	
	public Circle(double length) {
		super(length);
	}

	public double getArea(){
		return 3.14 * super.getLength() * super.getLength();
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.getArea();
	}
}
