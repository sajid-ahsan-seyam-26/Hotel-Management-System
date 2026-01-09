package Entity;

import java.lang.*;

public class Person {
    private String name;
    private int age;
	private String contactNum;
    
	public Person(){}
	
    public Person(String name, int age,String contactNum) {
        this.name = name;
        this.age = age;
		this.contactNum = contactNum;
    }
    
	public void setName(String name) {
        this.name = name;
    }
	
    public String getName() {
        return name;
    }
    
	public void setAge(int age) {
		this.age = age;
	}
	
    public int getAge() {
        return age;
    }
	
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	
    public String getContactNum() {
        return contactNum;
    }
	
	
	public void showInfo() {
		System.out.println("Name: "+ getName());
		System.out.println("Age: "+ getAge());
		System.out.println("Contact Number: "+ getContactNum());
	}
}

