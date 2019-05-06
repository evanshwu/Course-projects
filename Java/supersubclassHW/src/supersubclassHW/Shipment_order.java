package supersubclassHW;
import java.io.*;
import java.util.*;
/*
 * This is the super-sub class homework
 * Made by Hsin Han Wu 430530026
 * 作者:資管一吳信翰
 * 2015/4/10
 */
public class Shipment_order extends Shipment_setup{
	public static void main(String args[]) throws IOException{
		BufferedReader order = new BufferedReader(new InputStreamReader(System.in));//i use bufferedreader instead of scanner to avoid errors when typing spcae
		Scanner sc = new Scanner(System.in);
		Shipment_setup ss = new Shipment_setup();//new for my sub class
		String name, address, cargotype, phonenum;
		boolean pickup;
		int cont = 1;//this integer "continue" is a number for the user to decide if they want to quit the program or not
		int count = 0;//a number to notice the user how many times they have entered the program
		
		for(int i = 1;i < 10;i++){//in order to keep the program going over and over again, I decided to use "for"
		count++;
		System.out.println("=====================");
		System.out.println("**This is the VGA ordering system**");
		System.out.println("Note: this is the " + count +" time you've entered.");
		System.out.println("Please follow the instruction and type in datas:");
		//below is the code which user will type data
		System.out.println("Enter name(eg. Calvin Ethen):");
		name = order.readLine();
		System.out.println("Enter address(eg. DongXing Rd,Taipei City):");
		address = order.readLine();
		System.out.println("Enter the cargo type(eg. EVGA GTX 750 Gaming):");
		cargotype = order.readLine();
		System.out.println("Enter phone number(eg. 0277889988):");
		phonenum = order.readLine();
		System.out.println("Enter if the cargo will pickup by themselves(eg. true or false):");
		pickup = sc.nextBoolean();//because this type is boolean, so i use scanner
		//below is the code which data will be show on the screen
		ss.setdata(name,address,cargotype,phonenum,pickup);
		System.out.println("=====================");
		System.out.println("You have entered:");
		System.out.println("Name:      " + ss.getname());
		System.out.println("Address:   " + ss.getaddress());
		System.out.println("Phone num: " + ss.getnum());
		System.out.println("Cargo type:" + ss.getcargo());
		System.out.println("Pickup:    " + ss.getpickup());
		
		System.out.println("=====================");
		System.out.println("Please enter if you want to keep entering data(max up to 10):");
		System.out.println("Enter 1 for continuing and 2 for leaving:");//now time for the user to decide to leave or not
		cont = sc.nextInt();
		
		if(cont == 2){
			break;//if the user want to leave, they choose number 2
		}
		}
		System.out.println("======End of program======");//just a sign that you've left the program
	}//end of main
}
