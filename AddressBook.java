//AddressBook.java
// johnjoe landers - t00174319
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddressBook extends JFrame implements ActionListener {
	
	JMenu menuItem;
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	File file = new File("message.txt");
	Contact contact = new Contact();
	// Class
	public AddressBook(){
		
		setTitle("Address Book");
		setSize(600,600);
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("Address-Book-icon.png").getImage());
		// http://icons.iconarchive.com/icons/artua/mac/256/Address-Book-icon.png
		
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
			JOptionPane.showMessageDialog(null,"Saved ");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ERROR");
		}   			
    }
    
    // OPEN
	public void open(){
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();	
		}catch(Exception e){}
					 
	}
	
	//ADDING CONTACT
	public void addContact(){	 
			
		String forename = JOptionPane.showInputDialog(null,"Forname: ");
		String surname = JOptionPane.showInputDialog(null,"Surname: ");
		String email = JOptionPane.showInputDialog(null,"E-mail: ");
 		
 
		contactList.add(contact);
		
		
		
	}	
	//LISTING CONTACTS 
	public void listContact(){
		 for(Contact c:contactList) {
           JOptionPane.showMessageDialog(null,"The conatacts are \n"+c);
           //http://stackoverflow.com/questions/2047003/print-arraylist-element
        }
			
			
	
	}	
		
	//DELETE CONTACT
	public void deleteContact(){
		int number = Integer.parseInt( JOptionPane.showInputDialog(null,"Please enter the number you wish to remove "));
		int arraySize = contactList.size();
		if (number > arraySize && number < 1){
			JOptionPane.showMessageDialog(null,"You didn't enter a valid number ");
		}
		else{
			contactList.remove(number-1);
		}
	}
	
	//CREATE MAIL
	public void createMail(){
		
		CreateMail mail = new CreateMail();
		mail.setTitle("Address Book -Create mail");
		mail.setSize(400,400);
		mail.setLocation(200,200);
		mail.setIconImage(new ImageIcon("Address-Book-icon.png").getImage());
		mail.setVisible(true);
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
				deleteContact();
				break;
				
			case "Create mail":
				createMail();
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