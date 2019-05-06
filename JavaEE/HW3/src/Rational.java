/*
 *  Created Apr. 10th 2017
 *  Arthor: Hsin Han Wu
 *  ID: 403530026
 */
public class Rational {
	// Setup variables
	private int numerator=0;// This is upper
	private int denominator=0;// ...and this is down
	
	// Cunstructor
	public Rational(int arg1, int arg2){
		doTheCalculation(arg1, arg2);
	}// end of Rational
	
	private void doTheCalculation(int arg_num, int arg_den){
		int theMagicNumber = gcd(arg_num, arg_den);
		
		// Abacadaba!
		numerator = arg_num / theMagicNumber;
		denominator = arg_den / theMagicNumber;
	}// end of doTheCalculation
	
	private int gcd(int first, int second){
		if(second == 0){
			return first;
		}else{
			return gcd(second, first%second);
		}// end of if-else statement
	}// end of gcd
	
	public static Rational add(Rational r1, Rational r2){
		// The easiest way is to CROSS multiply numbers.
		// b/a + d/c = (b*c+a*d)/a*c

		int result_up = (r1.numerator * r2.denominator) + (r1.denominator * r2.numerator);
		int result_down = r1.denominator * r2.denominator;
		
		return new Rational(result_up, result_down);
	}// end of add
	
	public static Rational subtract(Rational r1, Rational r2){
		// The easiest way is still CROSS multipling numbers.
		// b/a - d/c = (b*c-a*d)/a*c

		int result_up = (r1.numerator * r2.denominator) - (r1.denominator * r2.numerator);
		int result_down = r1.denominator * r2.denominator;
		
		return new Rational(result_up, result_down);
	}// end of subtract
	
	public static Rational multiply(Rational r1, Rational r2){
		// Easy peasy lemon squeezy.

		int result_up = r1.numerator * r2.numerator;
		int result_down = r1.denominator * r2.denominator;
		
		return new Rational(result_up, result_down);
	}// end of multiply
	
	public static Rational divide(Rational r1, Rational r2){
		// Take down the second one!

		int result_up = r1.numerator * r2.denominator;
		int result_down = r1.denominator * r2.numerator;
		
		return new Rational(result_up, result_down);
	}// end of divide
	
	public String getResultByString(){
		return String.valueOf(numerator)+"/"+String.valueOf(denominator);
	}// end of getResultByString
	
	public String getResultByDouble(){
		return String.valueOf((double)numerator/denominator);
	}// end of getResultByDouble
	
	public String getResultByFloat(){
		return String.valueOf((float)numerator/denominator);
	}// end of getResultByFloat
	
	// A main function for testing...
	
	public static void main(String args[]){
		Rational r = new Rational(6,8);
		Rational rr = new Rational(1,3);
		Rational adding = Rational.divide(r, rr);
		System.out.println(adding.getResultByDouble());
	}// end of main
	
}
