package supersubclassHW;
/*
 * This is the super-sub class homework
 * Made by Hsin Han Wu 430530026
 * 作者:資管一吳信翰
 * 2015/4/10
 */

public class Shipment_settings {// I decided this class to be my "父類別"
	String name, address, cargotype, phonenum;
	boolean pickup;
	//this class do two things, one is to set attributes, and the other is to set data
	public void setdata(String name,String ad,String ct,String num,boolean p){
		this.name = name;
		this.address = ad;
		this.cargotype = ct;
		this.phonenum = num;
		this.pickup = p;
	}//end of Shipment_settings class

}
