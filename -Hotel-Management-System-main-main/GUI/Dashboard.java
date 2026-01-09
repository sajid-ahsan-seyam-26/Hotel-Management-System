package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;

public class Dashboard extends JFrame implements ActionListener
{	
	JButton btnRoom, btnEmployee, btnCustomer, btnLogOut;
	JPanel panel;
	
	Font font = new Font("cambria", Font.PLAIN, 20);
	Font font2 = new Font("cambria", Font.BOLD, 30);
	
	EmployeeList emplist;
	CustomerList cuslist;
	RoomList roomlist;
	
	public Dashboard(EmployeeList emplist,
					CustomerList cuslist,
					RoomList roomlist){
						
		super("Royal Hotel Dashboard");
		
        this.emplist = emplist; 
		this.cuslist = cuslist; 
		this.roomlist = roomlist;
		
		initializeFrame();
		
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
		ImageIcon image = new ImageIcon("Resources/Dash.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,1200,700);
		background.setIcon(image);
		this.add(background);
		
		//Creating Buttons
		btnRoom = new JButton("Room Manager");
        btnRoom.setBounds(70, 500, 300, 100);
        btnRoom.setFont(font2);
        btnRoom.addActionListener(this);
        this.add(btnRoom);
		
		btnEmployee = new JButton("Employee Manager");
        btnEmployee.setBounds(430, 500, 350, 100);
        btnEmployee.setFont(font2);
        btnEmployee.addActionListener(this);
        this.add(btnEmployee);
		
		btnCustomer = new JButton("Guest Manager");
        btnCustomer.setBounds(850, 500, 300, 100);
        btnCustomer.setFont(font2);
        btnCustomer.addActionListener(this);
        this.add(btnCustomer);
		
		btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(1000, 45, 130, 40);
        btnLogOut.setFont(font);
        btnLogOut.setBackground(new Color(92,104,214));
        btnLogOut.setForeground(new Color(255,255,255));
        btnLogOut.addActionListener(this);
        this.add(btnLogOut);
		
		
		//adding components to Panel
		panel.add(btnRoom);
		panel.add(btnEmployee);
		panel.add(btnCustomer);
		panel.add(btnLogOut);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (btnLogOut == e.getSource()) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log out?", "WARNING",
                    dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Login login = new Login(emplist, cuslist, roomlist);
                this.setVisible(false);
            }
        }
		
		else if(btnRoom == e.getSource()){
			RoomManagerFrame roomFrame = new RoomManagerFrame(roomlist);
		}
		
		else if(btnEmployee == e.getSource()){
			EmployeeManagerFrame employeeFrame = new EmployeeManagerFrame(emplist);
		}
		
		else if(btnCustomer == e.getSource()){
			CustomerManagerFrame customerFrame = new CustomerManagerFrame(cuslist);
		}
		
    }
}