
public class Sphere extends ThreeDimensionalShape{
	
	public Sphere(double length) {
		super(length);
	}

	public double getArea(){
		return 4 * 3.14 * super.getLength() * super.getLength();
	}
	
	public double getVolume(){
		return (4/3) * 3.14 * super.getLength() * super.getLength() * super.getLength();
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.getArea() + " Volume" + this.getVolume();
	}
}
