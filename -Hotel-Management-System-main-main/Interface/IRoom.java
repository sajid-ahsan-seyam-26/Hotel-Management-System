package Interface;

import EntityList.*;
import Entity.*;

import java.lang.*;

public interface IRoom {
	public void insert(Room a);
    public void remove(Room a);
	public Room getRoomById(String ID);
	
    public void showAll();
}