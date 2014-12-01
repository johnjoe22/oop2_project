import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AddressBook extends JFrame implements ActionListener,Serializable {
		 
		 JMenu menuItem;
		 String[] contactList; //creates array of arrays
		 
	public static void main(String[] args) {
		AddressBook frame = new AddressBook();
        frame.setVisible(true);

	}
	
	public void save(){
         		File file = new File("contactList.dat");
         		try{
         			
         		FileOutputStream fos = new FileOutputStream(file);
         		ObjectOutputStream oos = new ObjectOutputStream(fos);
         			oos.writeObject(contactList);
         			oos.close();	
         				JOptionPane.showMessageDialog(null,"conatct saved ");
         		}catch(Exception e){
         			JOptionPane.showMessageDialog(null,"ERROR");
         			}
         		
         			
         	}
	public void open(){
	
					File file = new File("contactList.dat");
					try{
					FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);
					for(int i=0;i<4;i++){
						contactList[i] = (String)ois.readObject();
					}
					ois.close();	
					}catch(Exception e){}
					 
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
        String answer="y";
       


        if (menuName.equals("Quit")) { //quit option
           System.exit(0);
        } 
        	
         else if (menuName.equals("New contact")) { //new contact
         		contactList = new String[3]; 	
         	
	        	contactList[0] = JOptionPane.showInputDialog(null,"Forname: ");
         		contactList[1] = JOptionPane.showInputDialog(null,"Surname: ");
        		contactList[2] = JOptionPane.showInputDialog(null,"E-mail: ");
        		save();
        		
         	
         	
         
        } 
        	else if (menuName.equals("List of contacts")){ //List of contacts
					
				open();
       		         String b = "";
       		         
       		         
       		         for(int i = 0;i<contactList.length;i++){
       		         	if(i%3==0)
       		         		b+="\n";
       		         	b+=contactList[i]+"\n";
       		         }
       		         
       		         JOptionPane.showMessageDialog(null,b);
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