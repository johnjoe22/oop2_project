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
	
	
	/**
	 *This is setting the title size location and icon in the main jframe
	 *it is also adding the menubar and menu items to the jframe
	 */
	 
	// Class
	
	public AddressBook(){
		
		setTitle("Address Book");
		setSize(600,600);
		setLocation(200,100);
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
	/**
	 *This method Adding contact adds forename surname email to a array
	 *then adds that array to to the arraylist
	 *
	 */
	
	//ADDING CONTACT
	public void addContact(){	 
			
		String forename = JOptionPane.showInputDialog(null,"Forname: ");
		String surname = JOptionPane.showInputDialog(null,"Surname: ");
		String email = JOptionPane.showInputDialog(null,"E-mail: ");
		
 		Contact newContact = new Contact();
 		newContact.setForename(forename);
		newContact.setSurname(surname);
		newContact.setEmail(email);
 		contactList.add(newContact);
	}	
	/**
	 *This method list contact to a JOptionPane 
	 *it goes through a for loop getting forename surname email
	 *it stores it in message and prints it out using JoptionPane
	 *
	 */
	public void listContact(){
		String message="";
		int j = 1;
/*****************************************************
*    Title: printing out arraylist elements
*    Author: mike yaworski
*    Site owner/sponsor: stackoverflow.com
*    Accesed: 06/12/2014
*    Code version: edited Jan 10 '13 at 17:42
*    Availability: http://stackoverflow.com/a/20027334

*****************************************************/
		//Start of [non-original or refactored] code
		 for(Contact c:contactList) {
		 	
           	message += "\n"+j+": "+c.getForename()+", "+c.getSurname()+", "+c.getEmail();
           	j++;
        }
        //end of [non-original or refactored] code
        JOptionPane.showMessageDialog(null,"The conatacts are \n" + message);
	}	
		
	/**
	 *This method delete contact stores a number entered by the user 
	 *checks to see if that number is on the arraylist 
	 *checks to see if the array is populated
	 *and then it removes the contact from the arraylist
	 *
	 */
	 
	//DELETE CONTACT
	public void deleteContact(){
		
		int number = Integer.parseInt( JOptionPane.showInputDialog(null,"Please enter the number you wish to remove "));
		int arraySize = contactList.size();
		if (arraySize==0){
			JOptionPane.showMessageDialog(null,"No contacts please create some");
			
		}
		else if (number > arraySize || number < 1){
			JOptionPane.showMessageDialog(null,"You didn't enter a valid number ");
		}
		else{
			contactList.remove(number-1);
		}
	}
	
	/**
	 *This method Edit contact ask the user for the number of the contact
	 *get the size of the array
	 *checks to see if the array is populated
	 *then it changes the details of that contact
	 *
	 */
	//EDIT CONTACT
	public void editContact(){
		
		
		int newNum = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the number of the contact you wish to Edit"));
		int num = newNum -1;
		int arraySize = contactList.size();
		if (arraySize==0){
			JOptionPane.showMessageDialog(null,"No contacts to edit please Create some");
			
		}
		else if (num > arraySize || num < 0){
			JOptionPane.showMessageDialog(null,"You didn't enter a valid number ");
		}
		else {
			String forename = JOptionPane.showInputDialog(null,"Changed Forname: ");
			String surname = JOptionPane.showInputDialog(null,"Changed Surname: ");
			String email = JOptionPane.showInputDialog(null,"Changed E-mail: ");
 			
			contactList.get(num).setForename(forename);
			contactList.get(num).setSurname(surname);
			contactList.get(num).setEmail(email);
		}
		
	}
/**
	 *This listener listens for events happening 
	 *and if the item is clicked do this 
	 *eg quit will quit when clicked
	 *
	 */
	
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
				
			case "Edit contact":
				editContact();
				break;
			
				
        }
    }
    
    /**
	 *This method createMenu create a jmenuitem and add it to the jmenu
	 *
	 */
	
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
        
        item = new JMenuItem("Edit contact");    //Edit Contact
        item.addActionListener( this );
        menuItem.add( item );
        
        item = new JMenuItem("Quit");    //Quit
        item.addActionListener( this );
        menuItem.add( item );
	}
}