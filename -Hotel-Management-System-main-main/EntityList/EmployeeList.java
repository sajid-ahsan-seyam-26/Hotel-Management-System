package EntityList;

import Entity.*;
import Interface.*;

import java.lang.*;

public class EmployeeList implements IEmployee {
	
	private Employee[] employeeList = new Employee[100];
	
	
	public void insert(Employee a){
		boolean flag = false;
		
		for(int i=0; i<employeeList.length; i++)
		{
			if(employeeList[i] == null)
			{
				employeeList[i] = a;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("Added");}
		else {System.out.println("Can Not Add");}
	}
	
	
	public void remove(Employee a)
	{
		boolean flag =false;
		for(int i=0; i<employeeList.length; i++)
		{
			if(employeeList[i] == a)
			{
				employeeList[i] = null;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("-----Employee Removed-----");}
		else{System.out.println("-----Can Not Remove-----");}
	}
	
	
	public Employee getEmployeeById(String ID)
	{
		Employee a = null;
		
		for(int i=0; i<employeeList.length; i++)
		{
			if(employeeList[i] != null)
			{
				if(employeeList[i].getEmployeeId().equals(ID))
				{
					a=employeeList[i];
					break;
				}
			}
		}
		return a;
	}
	
	public void showAll()
	{
		for(int i=0; i<employeeList.length; i++)
		{
			if(employeeList[i] != null)
			{
				System.out.println("-----------------------");
				employeeList[i].showInfo();
				System.out.println();
			}
		}
	
	}
	
	public Employee[] getAllEmployees(){return employeeList;}
	public void setAllEmployees(Employee[] employees){employeeList= employees;}
	
}