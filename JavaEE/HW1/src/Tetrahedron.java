
public class Tetrahedron extends ThreeDimensionalShape{

	double[] sides = new double[3];
	double[] vertex = new double[12];
	public Tetrahedron(double[] vertex) {
		super.setVertex(vertex);
		this.vertex = vertex;
	}

	public double calArea(){
		sides[0] = Math.sqrt(Math.abs(this.vertex[1] - this.vertex[4])+Math.abs(this.vertex[0] - this.vertex[3])+Math.abs(this.vertex[2] - this.vertex[5]));
		sides[1] = Math.sqrt(Math.abs(this.vertex[0] - this.vertex[6])+Math.abs(this.vertex[1] - this.vertex[7])+Math.abs(this.vertex[2] - this.vertex[8]));
		sides[2] = Math.sqrt(Math.abs(this.vertex[3] - this.vertex[6])+Math.abs(this.vertex[4] - this.vertex[7])+Math.abs(this.vertex[5] - this.vertex[8]));
		double all = sides[0] + sides[1] + sides[2];
		double lowerArea = 	Math.sqrt( all * (Math.abs(all-sides[0])) * (Math.abs(all-sides[1])) * (Math.abs(all-sides[2])) );
		return 0.3 * lowerArea * this.vertex[11];
	}
	
	public double calVol(){
		double bu = sides[0];
		double su = Math.sqrt(Math.abs(this.vertex[0] - this.vertex[9])+Math.abs(this.vertex[1] - this.vertex[10])+Math.abs(this.vertex[2] - this.vertex[11]));
		double bv = sides[1];
		double sv = Math.sqrt(Math.abs(this.vertex[3] - this.vertex[9])+Math.abs(this.vertex[4] - this.vertex[10])+Math.abs(this.vertex[5] - this.vertex[11]));
		double bw = sides[2];
		double sw = Math.sqrt(Math.abs(this.vertex[6] - this.vertex[9])+Math.abs(this.vertex[7] - this.vertex[10])+Math.abs(this.vertex[8] - this.vertex[11]));
		
		double bx = Math.abs(sw-bu+sv) * Math.abs(bu+sv+sw);
		double sx = Math.abs(bu-sv+sw) * Math.abs(sv-sw+bu);
		double by = Math.abs(su-bv+sw) * Math.abs(bv+sw+su);
		double sy = Math.abs(bv-sw+su) * Math.abs(sw-su+bv);
		double bz = Math.abs(sv-bw+su) * Math.abs(bw+su+sv);
		double sz = Math.abs(bw-su+sv) * Math.abs(su-sv+bw);
		
		double a = Math.sqrt(sx * by * bz);
		double b = Math.sqrt(bx * sy * bz);
		double c = Math.sqrt(bx * by * sz);
		double d = Math.sqrt(sx * sy * sz);
				
		//double lowerArea = 	Math.sqrt( all * (all-sides[0]) * (all-sides[1]) * (all-sides[2]) );
		System.out.println(Math.sqrt( Math.abs(b+c+d-a) * Math.abs(a-b+c+d) * Math.abs(a+b-c+d) * Math.abs(a+b+c-d) ));
		return (Math.sqrt( Math.abs(b+c+d-a) * Math.abs(a-b+c+d) * Math.abs(a+b-c+d) * Math.abs(a+b+c-d) )) / (192*su*sv*sw);
	}

	@Override
	public double getVolume() {
		return this.calVol();
	}

	@Override
	public double getArea() {
		return this.calArea();
	}

	@Override
	public String getResult() {
		return this.getClass().getName() + ": Area" + this.calArea() + " Volume" + this.getVolume();
	}
}
