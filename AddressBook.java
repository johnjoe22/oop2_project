import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddressBook extends JFrame implements ActionListener,Serializable {
		 
		 JMenu menuItem;
		 
	public static void main(String[] args) {
		AddressBook frame = new AddressBook();
        frame.setVisible(true);

	}
	
	public void save(){
         		File file = new File("ListOfContacts.dat");
         		FileOutputStream fos = new FileOutputStrem(file);
         		ObjectOutputStream oos = newObjectOutputStream(fos);
         			oos.WriteObject(t00174319);
         			file.close();
         	}
	public void open(){
					File file = new File("ListOfContacts.dat");
					FileInputStream fis = new FileInputStream(file);
					ObjectOutputStream ois = new ObjectOutputStream(fis);
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
         	
         	Arraylist<contact> listOfContacts = new Arraylist<contact>();
         	while(!answer.equals("y")){
         		 name = JOptionPane.showInputDialog(null,"Name: ");
        		 email = JOptionPane.showInputDialog(null,"E-mail: ");
        		 contact.add(contact);
        		 answer=JOptionPane.showInputDialog(null,"Would you like to enter another contact? ");
         	}
         	save();
         
        } 
        	else if (menuName.equals("List of contacts")){ //List of contacts
					
				
					for (contact c:listOfContacts){
						output.append(c.toString()+"\n");
					}
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