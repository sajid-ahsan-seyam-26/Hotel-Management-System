package GUI;
 
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;
public class RoomManagerFrame extends JFrame implements ActionListener
{	
	JPanel panel;
	
	JLabel label;	
	
	JTextField roomID, price, searchField;
	JComboBox roomType, availibility;
	JButton add, delete, clear, update, search;
	
	DefaultTableModel model;
	JTable table;
	RoomList roomlist;
	
	Font font2 = new Font("cambria", Font.BOLD, 35);
	Font font = new Font("cambria", Font.BOLD, 20);
	Font font1 = new Font("cambria", Font.BOLD, 25);
	
	public RoomManagerFrame(RoomList roomlist){
		super("Room Manager");
		
        this.roomlist = roomlist;
		initializeFrame();
		
		createTable();
		
		this.setVisible(true);
	}
	
	public void initializeFrame(){
		this.setSize(1200, 700);
        this.setLocation(150, 70);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creating a Panel Container
		panel = new JPanel();
		panel.setBounds(0,0,1200,700);
				
		panel.setOpaque(false);
		panel.setLayout(null);
		this.add(panel);
		
		//BackGround Example
		ImageIcon image = new ImageIcon("Resources/room.jpg");
		JLabel background = new JLabel();
		background.setBounds(0,0,1200,700);
		background.setIcon(image);
		this.add(background);
		
		
		
		//Crating a Labels
		label = new JLabel("Add Room Information");
		label.setBounds(90,90,400,70);
		label.setForeground(new Color(255,255,255));
		label.setFont(font2);
		
		JLabel roomIDLable = new JLabel("Room ID");
		roomIDLable.setFont(font1);
		roomIDLable.setForeground(new Color(255,255,255));
		roomIDLable.setBounds(30,190,200,40);
		
		JLabel roomTypeLable = new JLabel("Room Type");
		roomTypeLable.setFont(font1);
		roomTypeLable.setForeground(new Color(255,255,255));
		roomTypeLable.setBounds(30,270,200,40);

		JLabel roomAvailibilityLable = new JLabel("Availibility");
		roomAvailibilityLable.setFont(font1);
		roomAvailibilityLable.setForeground(new Color(255,255,255));
		roomAvailibilityLable.setBounds(30,350,200,40);
		
		JLabel roomPriceLable = new JLabel("Price per Night");
		roomPriceLable.setFont(font1);
		roomPriceLable.setForeground(new Color(255,255,255));
		roomPriceLable.setBounds(30,430,200,40);
		
		
		
		//TextFields
		roomID = new JTextField();
		roomID.setFont(font1);
		roomID.setBounds(230,190,250,40);
		
		
		String roomTypes[]={"Normal","VIP","VVIP","President"};        
		roomType = new JComboBox(roomTypes);
		roomType.setFont(font1);
		roomType.setBounds(230,270,250,40);
		
		String risAvailable[]={"Availible","Not Availible"};        
		availibility = new JComboBox(risAvailable);
		availibility.setFont(font1);
		availibility.setBounds(230,350,250,40);
		
		price = new JTextField();
		price.setFont(font1);
		price.setBounds(230,430,250,40);

		searchField = new JTextField();
        searchField.setFont(font1);
        searchField.setBounds(580, 100, 320, 40);
        
        // Search button
        search = new JButton("Search");
        search.setFont(font);
        search.setBounds(930, 100, 150, 40);
        search.addActionListener(this);
		
		//Creating Buttons
		add = new JButton("Add Room");
		add.setFont(font);
		add.setBounds(50,550,150,40);
		add.addActionListener(this);
		
		clear = new JButton("Clear");
		clear.setFont(font);
		clear.setBounds(310,550,150,40);
		clear.addActionListener(this);
		
		delete = new JButton("Delete");
		delete.setFont(font);
		delete.setBounds(610,615,150,40);
		delete.addActionListener(this);
		
		update = new JButton("Update");
		update.setFont(font);
		update.setBounds(920,615,150,40);
		update.addActionListener(this);
		
		//adding components to Panel
		panel.add(label);
		panel.add(roomIDLable);
		panel.add(roomTypeLable);
		panel.add(roomAvailibilityLable);
		panel.add(roomPriceLable);
		panel.add(roomID);
		panel.add(roomType);
		panel.add(availibility);
		panel.add(price);
		panel.add(add);
		panel.add(clear);
		panel.add(delete);
		panel.add(update);
		panel.add(search);
		panel.add(searchField);
		
	}
	
	public void createTable(){
		//Create Model For Table
		model = new DefaultTableModel();
		model.addColumn("Room ID");
		model.addColumn("Room Type");
		model.addColumn("Availibility");
		model.addColumn("Price per Night");
		
		//Create Table with model
		table = new JTable(model);
		table.setFont(font);
		table.setBackground(new Color(174,247,255));
		table.setBounds(0, 0, 600, 400);
		table.setRowHeight(30);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.getTableHeader().setFont(font);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(550, 180, 600, 400);
		
		//copy data from box list to Model
		Room[] rooms;
		rooms = roomlist.getAllRooms();
		
		for(int i=0;i<rooms.length;i++){
			if(rooms[i]!=null){
				model.addRow(new Object[]{
					rooms[i].getRoomID(),
					rooms[i].getRoomType(),
					rooms[i].getIsAvailable(),
					rooms[i].getPricePerNight()
				});
			}
		}
		
		//add the scrollPane to panel
		panel.add(scrollPane);
	}
	
	public void actionPerformed(ActionEvent e){
		if (add == e.getSource()) {
			
        String ID = roomID.getText();
    String type = (String) roomType.getItemAt(roomType.getSelectedIndex());
    String available = (String) availibility.getItemAt(availibility.getSelectedIndex());
    String priceText = price.getText();

        if (ID.isEmpty() || priceText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please Provide All Information", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        try {
            double pricePer = Double.parseDouble(priceText);

            if (Double.parseDouble(ID) < 0 || pricePer < 0) {
                JOptionPane.showMessageDialog(this, "Invalid Number Format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Room r = new Room(ID, type, available, pricePer);
                roomlist.insert(r);

                model.addRow(new Object[]{
                        r.getRoomID(),
                        r.getRoomType(),
                        r.getIsAvailable(),
                        r.getPricePerNight()
                });
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Number Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
		else if (clear == e.getSource()) {
        // Clear button action
        roomID.setText("");
        roomType.setSelectedIndex(0);
        availibility.setSelectedIndex(0);
        price.setText("");
		}
		
		else if (delete == e.getSource()) {
        // Delete button action
        int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
            String roomID = (String) model.getValueAt(selectedRow, 0);
			Room room = roomlist.getRoomById(roomID);
				if (room != null) {
                roomlist.remove(room);
                model.removeRow(selectedRow);
				}
			}
		} 
		
		else if (update == e.getSource()) {
        // Update button action
        int rowCount = model.getRowCount();
        Room[] newRooms = new Room[rowCount];

        for (int i = 0; i < rowCount; i++) {
            String roomID = (String) model.getValueAt(i, 0);
            String roomType = (String) model.getValueAt(i, 1);
            String isAvailable = (String) model.getValueAt(i, 2);
            double pricePerNight = (double) model.getValueAt(i, 3);

            Room room = new Room(roomID, roomType, isAvailable, pricePerNight);
            newRooms[i] = room;
        }

			roomlist.setAllRooms(newRooms);
			JOptionPane.showMessageDialog(this, "Content Updated");
		}
		
		else if (search == e.getSource()) {
            String searchText = searchField.getText();
            if (searchText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search query.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            boolean found = false;
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    if (searchText.equalsIgnoreCase(table.getValueAt(row, col).toString())) {
                        table.setRowSelectionInterval(row, row);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
		
			
	}
	
}