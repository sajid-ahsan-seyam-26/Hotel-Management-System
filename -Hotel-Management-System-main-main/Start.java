import Entity.*;
import EntityList.*;
import Interface.*;

import GUI.*;

import java.lang.*;
import java.time.LocalDate;

public class Start{
    public static void main(String[] args) {
		
		Employee empObj1 = new Employee("Ashfak Miya", 25,"01685858369","12345", 30000);
		Employee empObj2 = new Employee("Seyam Kaku", 24,"01664713489","13698", 40000);
		Employee empObj3 = new Employee("Nishat Appa", 23,"0162574364","17412", 10000);
		Employee empObj4 = new Employee("Toufiq Bhai", 21,"016253149","96352", 50000);
		
		
		Customer cusObj1 = new Customer("Lulli bhai", 35,"01693655",
										"12345",10);
		Customer cusObj2 = new Customer("Hululu bhai", 25,"016944545",
										"54321",9);
		Customer cusObj3 = new Customer("Dugudugu bhai", 35,"01654654115",
										"43215",8);
		Customer cusObj4 = new Customer("Ululu bhai", 31,"01645464615",
										"42586",7);


        Room roomObj1 = new Room("1234","President","Available",20000);
        Room roomObj2 = new Room("3698","VVIP","Available",15000);
        Room roomObj3 = new Room("4321","VIP","Not Available",7000);
        Room roomObj4 = new Room("8521","Normal","Available",2000);
		
		
		EmployeeList emplist = new EmployeeList();
		CustomerList cuslist = new CustomerList();
		RoomList roomlist = new RoomList();
		
		
		emplist.insert(empObj1);
		emplist.insert(empObj2);
		emplist.insert(empObj3);
		emplist.insert(empObj4);
		
		cuslist.insert(cusObj1);
		cuslist.insert(cusObj2);
		cuslist.insert(cusObj3);
		cuslist.insert(cusObj4);
		
		roomlist.insert(roomObj1);
		roomlist.insert(roomObj2);
		roomlist.insert(roomObj3);
		roomlist.insert(roomObj4);
		
		/*
		System.out.println("Showing All Employees: ");
        emplist.showAll();
        
		System.out.println("Showing All Customers: ");
		cuslist.showAll();
		
		System.out.println("Showing All Rooms: ");
        roomlist.showAll();
		
		emplist.remove(empObj3);
        cuslist.remove(cusObj3);
        roomlist.remove(roomObj3);
		
		emplist.remove(emplist.getEmployeeById("12345"));
		cuslist.remove(cuslist.getCustomerById("12345"));
		roomlist.remove(roomlist.getRoomById("1234"));
		
		
		emplist.showAll();
        cuslist.showAll();
        roomlist.showAll();
		*/
		
		Login login = new Login(emplist, cuslist, roomlist);
		
		//RoomManagerFrame rFrame = new RoomManagerFrame(roomlist);
		//CustomerManagerFrame rFrame = new CustomerManagerFrame(cuslist);
		//EmployeeManagerFrame f1 = new EmployeeManagerFrame(emplist);
		
    }
}
