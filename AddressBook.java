
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddressBook extends JFrame implements ActionListener {
	
	JMenu menuItem;
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	File file = new File("contactList.dat");
	
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
			
		String forename = JOptionPane.showInputDialog(null,"Forname: ");
		String surname = JOptionPane.showInputDialog(null,"Surname: ");
		String email = JOptionPane.showInputDialog(null,"E-mail: ");
 		Contact contact = new Contact(forename,surname,email);
 
		contactList.add(contact);
		
		
		
	}	
	//LISTING CONTACTS 
	public void listContact(){
			
			JOptionPane.showMessageDialog(null,"ArrayList"+contactList);
	
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
         		
         		break;
         		
         	case "List of contacts":
         		listContact();
         			
				break;
				
			case "Delete contact":
				JOptionPane.showMessageDialog(null,"Menu Item " + menuName + " is selected.");
				break;
				
			case "Create mail":
				
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