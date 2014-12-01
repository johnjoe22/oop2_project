import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AddressBook extends JFrame implements ActionListener,Serializable {
		 
		 JMenu menuItem;
		 
	public static void main(String[] args) {
		AddressBook frame = new AddressBook();
        frame.setVisible(true);

	}
	
	public void save(){
         		File file = new File("contactList.dat");
         		FileOutputStream fos = new FileOutputStream(file);
         		ObjectOutputStream oos = new ObjectOutputStream(fos);
         			oos.WriteObject(file);
         			file.close();
         			JOptionPane.showMessageDialog(null,"Contact saved");
         	}
	public void open(){
					File file = new File("contactList.dat");
					FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);
					listOfContacts=oos.readobject();
					oos.close(); 
				}
		
	//creating jframe
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
	
	//action listener
	public void actionPerformed(ActionEvent e) {
        String  menuName="";
        menuName = e.getActionCommand(); 
        String name="";
		String email="";
		


        if (menuName.equals("Quit")) { //quit option
           System.exit(0);
        } 
        	
         else if (menuName.equals("New contact")) { //new contact
         	
         	String answer="y";
         	String [] Contact;
         	
         	ArrayList <Contact> contactList = new ArrayList <Contact>();
         	while(!answer.equals("y")){+
	`         		 forname = JOptionPane.showInputDialog(null,"Forname: ");
         		 surname = JOptionPane.showInputDialog(null,"Surname: ");
        		 email = JOptionPane.showInputDialog(null,"E-mail: ");
        		 contactList.add(Contact);
        		 answer=JOptionPane.showInputDialog(null,"Would you like to enter another contact? ");
         	}
         	save();
         
        } 
        	else if (menuName.equals("List of contacts")){ //List of contacts
					
				open();
       		         
        	}
        	else if (menuName.equals("Delete contact")){//Delete contact
        	
        		JOptionPane.showMessageDialog(null,"Menu Item " + menuName + " is selected.");

        	}
        	else if (menuName.equals("Edit contact")){ //Edit contact
        	
        		JOptionPane.showMessageDialog(null,"Menu Item " + menuName + " is selected.");
        	}
        	else if (menuName.equals("Create mail")){
        		JOptionPane.showMessageDialog(null,"Menu item"+menuName+" is selected.");
        	}
    } // end actionPerformend
    
    
	
	//create items in the menu bar
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
        
        item = new JMenuItem("Quit");    //Quit
        item.addActionListener( this );
        menuItem.add( item );
        
        item = new JMenuItem("Create mail");    //create mail
        item.addActionListener( this );
        menuItem.add( item );
	}
}