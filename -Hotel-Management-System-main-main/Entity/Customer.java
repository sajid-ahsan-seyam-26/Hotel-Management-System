package Entity;

import java.time.LocalDate;
import java.lang.*;

public class Customer extends Person{
    private String customerId;
    private int totalDays;
    private double totalPrice;

    public Customer() {}

    public Customer(String name, int age,String contactNum,
					String customerId, int totalDays) {
						
		super(name, age, contactNum);				
        this.customerId = customerId;
		this.totalDays = totalDays;
        this.totalPrice = calculateTotalPrice();
    }
	
	public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
	public String getCustomerId() {
        return customerId;
    }

    public int getTotalDays() {
        return totalDays;
    }
	
	public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
	
    public double getTotalPrice() {
        return totalPrice;
    }
	
    private double calculateTotalPrice() {
        return totalDays * 2500;
    }

    public void showInfo() {
		
		//System.out.println("--------Customer Info---------");
		super.showInfo();
        System.out.println("Customer ID: " + customerId);
			System.out.println("Total days stayed: " + totalDays);
			System.out.println("Per Night Cost: 5000 Taka");
			System.out.println("Total price: " + totalPrice + " taka");
		
        
    }
}
