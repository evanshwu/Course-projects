
public class Square extends TwoDimensionalShape{

	public Square(double width, double length) {
		super(width, length);
	}

	@Override
	public double getArea() {
		return super.getWidth() * super.getLength();
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.getArea();
	}
}
