
public class dubsteps {
	public static void main(String args[]){
		shape shapesssss[] = new shape[6];
		
		double[] _vertex = {0, 0, 0, 0, 1, 0, 1, 0, 0, 0.5, 0.5, 1};
		
		// circle, square, triangle, sphere, cube, tetrahedron 
		shapesssss[0] = new Circle(7);
		shapesssss[1] = new Square(8, 7);
		shapesssss[2] = new Triangle(8, 7);
		shapesssss[3] = new Sphere(7);
		shapesssss[4] = new Cube(7);
		shapesssss[5] = new Tetrahedron(_vertex);
		
		for(shape index : shapesssss){
			if(shapesssss[0] instanceof TwoDimensionalShape){
				// 2D
				System.out.println( index.getResult() );
			}else{
				// 3D
				System.out.println( index.getResult() );
			}
		}
	}
}
