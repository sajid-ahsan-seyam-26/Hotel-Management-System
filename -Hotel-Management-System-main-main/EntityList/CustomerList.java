package EntityList;

import Entity.*;
import Interface.*;

import java.lang.*;

public class CustomerList implements ICustomer {
	
	private Customer[] customerList = new Customer[100];
	
	
	public void insert(Customer a){
		boolean flag = false;
		
		for(int i=0; i<customerList.length; i++)
		{
			if(customerList[i] == null)
			{
				customerList[i] = a;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("Added");}
		else {System.out.println("Can Not Add");}
	}
	
	
	public void remove(Customer a)
	{
		boolean flag =false;
		for(int i=0; i<customerList.length; i++)
		{
			if(customerList[i] == a)
			{
				customerList[i] = null;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("-----Customer Removed-----");}
		else{System.out.println("-----Can Not Remove-----");}
	}
	
	
	public Customer getCustomerById(String ID)
	{
		Customer a = null;
		
		for(int i=0; i<customerList.length; i++)
		{
			if(customerList[i] != null)
			{
				if(customerList[i].getCustomerId().equals(ID))
				{
					a=customerList[i];
					break;
				}
			}
		}
		return a;
	}
	
	public void showAll()
	{
		for(int i=0; i<customerList.length; i++)
		{
			if(customerList[i] != null)
			{
				System.out.println("-----------------------");
				customerList[i].showInfo();
				System.out.println();
			}
		}
	
	}
	
	public Customer[] getAllCustomers(){return customerList;}
	public void setAllCustomers(Customer[] customers)
	{customerList = customers;}
}
