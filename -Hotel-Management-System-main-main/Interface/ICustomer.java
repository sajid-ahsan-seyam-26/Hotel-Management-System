package Interface;

import EntityList.*;
import Entity.*;

import java.lang.*;

public interface ICustomer {
	public void insert(Customer a);
    public void remove(Customer a);
	public Customer getCustomerById(String ID);
	
    public void showAll();
}
