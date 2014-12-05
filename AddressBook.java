
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AddressBook extends JFrame implements ActionListener {
	
	JMenu menuItem;
	ArrayList <String> contactList;
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
		//TOSTRING
	public String toString(){
	Contact contact = new Contact();	
	return "Forename:" + contact.forename + " "
                + "Surname:" + contact.surname + " "+ "E-mail:" + contact.email +"\n";
}

	
	//ADDING CONTACT
	public void addContact(){	 
			
		//toString();
		
		Contact contact = new Contact();
		String s[]= contacts{
			System.out.println("Forename");
				forename = input.nextLine();
		}
		ArrayList<String> contactList = new ArrayList<String>();
		contactList.add(4);
		
		//Contact contact = new Contact();
		
		/*contact.setForename (JOptionPane.showInputDialog(null,"Forname: "));
		contact.setSurname (JOptionPane.showInputDialog(null,"Surname: "));
		contact.setEmail (JOptionPane.showInputDialog(null,"E-mail: "));
		contactList.add(contact.toString());*/
		save();
	}	
	//LISTING CONTACTS 
	public void listContact(){
		open();	
		ListIterator it = contactList.listIterator();
		while(it.hasNext()){
				String element = String.valueOf(it.next());
         		JOptionPane.showMessageDialog(null,"Contact :"+ element);
         		}
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