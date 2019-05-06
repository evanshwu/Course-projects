
public abstract class ThreeDimensionalShape extends shape{
	
	public ThreeDimensionalShape() {
	
	}
	
	public ThreeDimensionalShape(double width, double length) {
		super(width, length);
	}
	
	public ThreeDimensionalShape(double width, double length, double height) {
		super(width, length);
		super.setHeight(height);
	}

	public ThreeDimensionalShape(double length) {
		super(length);
	}
	
	public abstract double getVolume();
}
