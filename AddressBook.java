

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddressBook extends JFrame implements ActionListener {
		 
	JMenu menuItem;
	ArrayList <String> contactList;
	
	// Class
	public AddressBook(){
		
		setTitle("Address Book");
		setSize(600,600);
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createMenu();
		
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menuItem);
	}
	
	// Main
	public static void main(String[] args) {
		AddressBook frame = new AddressBook();
        frame.setVisible(true);
	}
	
	// SAVE
	public void save(){
		File file = new File("contactList.dat");
		try{	
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(contactList);
			
			
			oos.close();	
			JOptionPane.showMessageDialog(null,"Conatcts saved ");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ERROR");
		}   			
    }
    
    // OPEN
	public void open(){
		File file = new File("contactList.dat");
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			for(int i=0;i<contactList.size();i++){
			}
			ois.close();	
		}catch(Exception e){}
					 
	}
	
	//ADDING CONTACT
	public void addContact(){
		String quit;
		
		contactList = new ArrayList<String>();
		
		Contact contact = new Contact();
		
		contact.setForename (JOptionPane.showInputDialog(null,"Forname: "));
		contactList.add("contact");
		
		contact.setSurname (JOptionPane.showInputDialog(null,"Surname: "));
		contactList.add("contact");
		
		contact.setEmail (JOptionPane.showInputDialog(null,"E-mail: "));
		contactList.add("contact");
		
	}
		
	
	
	// LISTENER
	public void actionPerformed(ActionEvent e) {
        String  menuName="";
        menuName = e.getActionCommand(); 

		switch(menuName){
			case "Quit":
				System.exit(0);
				break;
				
			case "New contact":
         		addContact();
         		save();
         		break;
         		
         	case "List of contacts":
         		open();
         	/*	String message = "";
         		for(int i = 0;i<contactList.size();i++){
         			message += (contactList.get(i));
					message += "\n";
					i++;
}  	
         		}*/
         			
				break;
				
			case "Delete contact":
				JOptionPane.showMessageDialog(null,"Menu Item " + menuName + " is selected.");
				break;
				
			case "Create mail":
				JOptionPane.showMessageDialog(null,"Menu item"+menuName+" is selected.");
				break;	
        }
    }
    
    
	
	// CREATE MENU		
	public void createMenu(){
		
		JMenuItem item;
        
        menuItem = new JMenu("File");

		item = new JMenuItem("New contact");    //New Contact
        item.addActionListener( this );
        menuItem.add( item );
        
        item = new JMenuItem("List of contacts");    //List of contacts
        item.addActionListener( this );
        menuItem.add( item );
        
        item = new JMenuItem("Delete contact");    //Delete contact
        item.addActionListener( this );
        menuItem.add( item  );
        
        item = new JMenuItem("Create mail");    //create mail
        item.addActionListener( this );
        menuItem.add( item );
        
        item = new JMenuItem("Quit");    //Quit
        item.addActionListener( this );
        menuItem.add( item );
	}
}