
public class Cube extends ThreeDimensionalShape{

	public Cube(double length) {
		super(length);
	}

	@Override
	public double getVolume() {
		return super.getLength() * super.getLength() * super.getLength();
	}

	@Override
	public double getArea() {
		return super.getLength() * super.getLength() * 6;
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.getArea() + " Volume" + this.getVolume();
	}

}
