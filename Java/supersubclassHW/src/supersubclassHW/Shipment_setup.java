package supersubclassHW;
/*
 * This is the super-sub class homework
 * Made by Hsin Han Wu 430530026
 * 作者:資管一吳信翰
 * 2015/4/10
 */
public class Shipment_setup extends Shipment_settings{//i decided this class to be my "子類別"
	public String getname(){//these "get-" methods are going to return data and show them on the screen
		return name;
	}
	public String getaddress(){
		return address;
	}
	public String getcargo(){
		return cargotype;
	}
	public String getnum(){
		return phonenum;
	}
	public boolean getpickup(){
		return pickup;
	}
	public void set(){//this method is to call the "setdata" using super
		super.setdata(name, address, cargotype, phonenum, pickup);
	}
	
}
