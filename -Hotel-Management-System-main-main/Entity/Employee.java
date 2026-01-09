package Entity;

import java.lang.*;

public class Employee extends Person{
    private String employeeId;
	private int empSalary;
    
    public Employee(String name, int age,String contactNum,
					String employeeId, int empSalary) {
						
        super(name, age, contactNum);
        this.employeeId = employeeId;
        this.empSalary = empSalary;
    }
    
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
    public String getEmployeeId() {
        return employeeId;
    }
	
	public void setEmployeeSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
    public int getEmployeeSalary() {
        return empSalary;
    }
	
	public void showInfo() {
		
		//System.out.println("--------Employee Info---------");
		super.showInfo();
		System.out.println("Employee ID: "+ employeeId);
		System.out.println("Employee Salary: "+ empSalary);
		}
}