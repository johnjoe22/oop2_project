import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AddressBook extends JFrame implements ActionListener {
		 
	JMenu menuItem;
	Contact[] contactList = new Contact[2]; 
		Contact contact;
	
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
			//int i = 0;
			//while(!contactList[i].getForename().equals("")){
			//	oos.writeObject(contactList[i]);
			//	i++;
				oos.writeObject(contactList);
			//}
			
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
			for(int i=0;i<contactList.length;i++){
				contactList[i].setForename((String)ois.readObject());
				contactList[i].setSurname((String)ois.readObject());
				contactList[i].setEmail((String)ois.readObject());
			}
			ois.close();	
		}catch(Exception e){}
					 
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
				for (int i = 0;i<contactList.length;i++){ 
					contact =new Contact();
		        	
		        	
		        	contact.setForename (JOptionPane.showInputDialog(null,"Forname: "));
	         		contact.setSurname (JOptionPane.showInputDialog(null,"Surname: "));
	        		contact.setEmail (JOptionPane.showInputDialog(null,"E-mail: "));
	        		contactList[i]=contact;
         		}
         		save();
         		break;
         		
         	case "List of contacts":
         		open();
         		int i = 0;
         		String message = "";
				while(!contactList[i].getForename().equals("")){
					message += contactList[i].getForename();
					message += contactList[i].getSurname();
					message += contactList[i].getEmail();
					message += "\n";
					i++;
				}
					
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