package EntityList;

import Entity.*;
import Interface.*;

import java.lang.*;

public class RoomList implements IRoom {
	
	private Room[] roomList = new Room[100];
	
	
	public void insert(Room a){
		boolean flag = false;
		
		for(int i=0; i<roomList.length; i++)
		{
			if(roomList[i] == null)
			{
				roomList[i] = a;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("Added");}
		else {System.out.println("Can Not Add");}
	}
	
	
	public void remove(Room a)
	{
		boolean flag =false;
		for(int i=0; i<roomList.length; i++)
		{
			if(roomList[i] == a)
			{
				roomList[i] = null;
				flag = true;
				break;
			}
		}
		
		if(flag){System.out.println("-----Room Removed-----");}
		else{System.out.println("-----Can Not Remove-----");}
	}
	
	
	public Room getRoomById(String ID)
	{
		Room a = null;
		
		for(int i=0; i<roomList.length; i++)
		{
			if(roomList[i] != null)
			{
				if(roomList[i].getRoomID().equals(ID))
				{
					a=roomList[i];
					break;
				}
			}
		}
		return a;
	}
	
	public void showAll()
	{
		for(int i=0; i<roomList.length; i++)
		{
			if(roomList[i] != null)
			{
				System.out.println("-----------------------");
				roomList[i].showInfo();
				System.out.println();
			}
		}
	
	}
	
	public Room[] getAllRooms(){return roomList;}
	public void setAllRooms(Room[] rooms){roomList = rooms;}
}