package fibonacci;

import java.util.*;
/*This is the fibonacci class file
 * This is for java class Only
 * Made by Hsin Han Wu
 * 403530026
 * 2015/3/19
 */
public class fibonacci {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		int input;//an int which user will type number in
		
		System.out.println("**This is the fibonacci system**");
		System.out.println("Please enter an integer for the time you want to display:");
		input = scanner.nextInt();
		
		for(int i=0;i<=input;i++){//the place where numbers will show untill it reaches the number which user just typed
			System.out.println("The no." + i + " of fibonacci is " + fibon(i));
		}
		
		System.out.println("========End of fibonacci system========");
	}//end of main



    public static long fibon(int a){
    	if(a == 0){
    		return 0;//the first number has to be 0
    	}else if(a == 1 || a == 2){
    		return 1;//the second and third number are 1
    	}else{
    		return fibon(a-1)+fibon(a-2);//the fibon method will become a circle to calculate the number
    	}
    }

}