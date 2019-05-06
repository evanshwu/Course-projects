import java.util.*;//import the API for scanner

public class addressbookMain {

	public static void main(String args[]){
		/*This is the addressbook main part
	     * Made for my java class Only
	     * this is made by HSIN HAN WU
	     * 製作by 資管一 吳信翰 403530026
	     * Copyright 2015/3/19 Hsin Han Wu.All rights reserved.
	     */
		addressbook ab1 = new addressbook();//I set up two different addressbook to set two datas
		addressbook ab2 = new addressbook();
		Scanner scanner = new Scanner(System.in);//scanner
		String name1, bloodtype1, address1;
		int age1;
		
		System.out.println("***This is the addressbook system***");
		System.out.println("***This class is made by HSIN HAN WU***");
		//user will start to input datas include four elements the addressbook requires
		System.out.println("Please type name for the first data:");
		name1 = scanner.next();
		
		System.out.println("Please type age for the first data:");
		age1 = scanner.nextInt();
		
		System.out.println("Please type bloodtype for the first data:");
		bloodtype1 = scanner.next();
		
		System.out.println("Please type address for the first data:");
		address1 = scanner.next();
		
		ab1.setdata(name1, address1, bloodtype1, age1);//after we finish typing the first data, the first book will be stored
		
		
		System.out.println("================Second Data==============");
		System.out.println("Please type name for the second data:");
		name1 = scanner.next();
		
		System.out.println("Please type age for the second data:");
		age1 = scanner.nextInt();
		
		System.out.println("Please type bloodtype for the second data:");
		bloodtype1 = scanner.next();
		
		System.out.println("Please type address for the second data:");
		address1 = scanner.next();
		
		ab2.setdata(name1, address1, bloodtype1, age1);
		//same as the first one, store data after typing
		
		System.out.println("The first data:");
		System.out.println("Name: " + ab1.getname());
		System.out.println("Age: " + ab1.getage());
		System.out.println("Address: " + ab1.getaddress());
		System.out.println("Bloodtype: " + ab1.getbloodtype());
		System.out.println("========================");
		System.out.println("The second data:");
		System.out.println("Name: " + ab2.getname());
		System.out.println("Age: " + ab2.getage());
		System.out.println("Address: " + ab2.getaddress());
		System.out.println("Bloodtype: " + ab2.getbloodtype());

	}//end of main
}
