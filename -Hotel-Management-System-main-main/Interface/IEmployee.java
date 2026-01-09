package Interface;

import EntityList.*;
import Entity.*;

import java.lang.*;

public interface IEmployee {
	public void insert(Employee a);
    public void remove(Employee a);
	public Employee getEmployeeById(String ID);
	
    public void showAll();
}
