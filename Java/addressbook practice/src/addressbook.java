
public class addressbook {
    /*This is the addressbook class
     * Made for my java class Only
     * this is made by HSIN HAN WU
     * 製作by 資管一 吳信翰 403530026
     * Copyright 2015/3/19 Hsin Han Wu.All rights reserved.
     */
	String name, address, bloodtype;
	int age;
	
	public void setdata(String n,String ad,String bt,int a){
		//this setdata is to store data in the memory
		name = n;
		age = a;
		bloodtype = bt;
		address = ad;
	}
	
	public String getname(){
		//same as the four get** below, this is used to pull the data I stored before 
		return name;
	}
	
	public String getaddress(){
		return address;
	}

	public int getage(){
		return age;
	}

	public String getbloodtype(){
		return bloodtype;
	}

}
