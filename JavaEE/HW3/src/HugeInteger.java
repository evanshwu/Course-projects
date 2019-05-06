/*
 *  Created Apr. 10th 2017
 *  Arthor: Hsin Han Wu
 *  ID: 403530026
 */
public class HugeInteger {
	// Setup variables
	int[] arrayOfDigits = new int[40];
	
	// Constructor
	public HugeInteger(String args){
		parse(args);
	}// end of constructor HugeInteger
	
	public String showAsStringFormat(){
		String str="{";
		for(int i : arrayOfDigits){
			str += String.valueOf(i)+", ";
		}// end of for loop
		str += "}";
		return str;
	}// end of showAsStringFormat
	
	void parse(String inputStream){
		for(int i=0;i<inputStream.length();i++){
			// I set the maximum limit of size as 40, and any action that doesn't reach 40 will be added 0s.
			if(inputStream.length() == 40){
				// Simple
				arrayOfDigits[i] = Character.getNumericValue(inputStream.charAt(i));
			}else if(inputStream.length() > 40){
				// Then we have to drop the rest.
				if(i<40){
					arrayOfDigits[i] = Character.getNumericValue(inputStream.charAt(i));
				}else{
					break;
				}
			}else if(inputStream.length() < 40){
				// This time we re-stock 0s.
				int HowMuchLeft = 40 - inputStream.length();// Which means how much 0s we need to add.
				arrayOfDigits[i] = Character.getNumericValue(inputStream.charAt(i));
				if(i==inputStream.length()-1){
					for(int j=1;j<=HowMuchLeft;j++){
						arrayOfDigits[i+j] = 0;
					}// end of inner for-loop
				}// end of inner if-else statement
			}// end of outer if-else statement
		}// end of for-loop
	}// end of parse
	
	public String toString(){
		String str="";
		for(int i : arrayOfDigits){
			str += String.valueOf(i);
		}// end of for-loop
		
		return str;
	}// end of toString
	
	public static HugeInteger add(HugeInteger hi1, HugeInteger hi2){
		String str = "";
		for(int i=0;i<40;i++){
			str += String.valueOf(hi1.arrayOfDigits[i] + hi2.arrayOfDigits[i]);
		}// end of for-loop
		
		return new HugeInteger(str);
	}// end of add
	
	public static HugeInteger subtract(HugeInteger hi1, HugeInteger hi2){
		String str = "";
		for(int i=0;i<40;i++){
			str += (hi1.arrayOfDigits[i] - hi2.arrayOfDigits[i]);
		}// end of for-loop
		
		return new HugeInteger(str);
	}// end of subtract
	
	public static HugeInteger multiply(HugeInteger hi1, HugeInteger hi2){
		String str = "";
		for(int i=0;i<40;i++){
			str += (hi1.arrayOfDigits[i] * hi2.arrayOfDigits[i]);
		}// end of for-loop
		
		return new HugeInteger(str);
	}// end of multiply
	
	public static HugeInteger divide(HugeInteger hi1, HugeInteger hi2){
		String str = "";
		for(int i=0;i<40;i++){
			if(hi2.arrayOfDigits[i] == 0){
				str += 0;
			}else{
				str += (hi1.arrayOfDigits[i] / hi2.arrayOfDigits[i]);
			}// end of if-else statement
		}// end of for-loop
		
		return new HugeInteger(str);
	}// end of divide
	
	public static HugeInteger remainder(HugeInteger hi1, HugeInteger hi2){
		String str = "";
		for(int i=0;i<40;i++){
			if(hi2.arrayOfDigits[i] == 0){
				str += 0;
			}else{
				str += (hi1.arrayOfDigits[i] % hi2.arrayOfDigits[i]);
			}// end of if-else statement
		}// end of for-loop
		
		return new HugeInteger(str);
	}// end of remainder
	
	public boolean isEqualTo(HugeInteger hi1, HugeInteger hi2){
		for(int i=0;i<40;i++){
			if(hi1.arrayOfDigits[i] != hi2.arrayOfDigits[i]){
				return false;
			}// end of if statement
		}// end of for-loop
		
		return true;
	}// end of isEqualTo
	
	public boolean isNotEqualTo(HugeInteger hi1, HugeInteger hi2){
		// The opposite of isEqualTo()
		return !isEqualTo(hi1, hi2);
	}// end of isNotEqualTo
	
	public boolean isGreaterThan(HugeInteger hi1, HugeInteger hi2){
		// is hi1 greater than hi2 ??
		for(int i=0;i<40;i++){
			if(hi1.arrayOfDigits[i] < hi2.arrayOfDigits[i]){
				return false;
			}// end of if statement
		}// end of for-loop
		
		return true;
	}// end of isGreaterThan
	
	public boolean isLessThan(HugeInteger hi1, HugeInteger hi2){
		// The opposite of isGreaterThan()
		return !isGreaterThan(hi1, hi2);
	}// end of isLessThan
	
	public boolean isGreaterThanOrEqualTo(HugeInteger hi1, HugeInteger hi2){
		for(int i=0;i<40;i++){
			if(hi1.arrayOfDigits[i] < hi2.arrayOfDigits[i] || hi1.arrayOfDigits[i] != hi2.arrayOfDigits[i]){
				return false;
			}// end of if statement
		}// end of for-loop
		
		return true;
	}// end of isGreaterThanOrEqualTo
	
	public boolean isLessThanOrEqualTo(HugeInteger hi1, HugeInteger hi2){
		for(int i=0;i<40;i++){
			if(hi1.arrayOfDigits[i] > hi2.arrayOfDigits[i] || hi1.arrayOfDigits[i] != hi2.arrayOfDigits[i]){
				return false;
			}// end of if statement
		}// end of for-loop
		
		return true;
	}// end of isLessThanOrEqualTo
	
	public boolean isZero(HugeInteger hi){
		for(int i : hi.arrayOfDigits){
			if(i != 0){
				return false;
			}// end of if statement
		}// end of for loop
		
		return true;
	}// end of isZero
	
	// A main function for testing...
	/*
	public static void main(String args[]){
		HugeInteger hi1 = new HugeInteger("1234567890123456789012345678901234567890");
		HugeInteger hi2 = new HugeInteger("0987654321098765432109876543210987654321");
		HugeInteger hiadd = HugeInteger.add(hi1, hi2);
		System.out.println(new HugeInteger("1234567890123456789012345678901234567890").toString());
		System.out.println(new HugeInteger("1234567890123456789012345678901234567890").showAsStringFormat());
		System.out.println(hiadd.showAsStringFormat());
	}// end of main
	*/
}
