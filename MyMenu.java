import javax.swing.*;
import java.awt.event.*;

public class MyMenu extends JFrame implements ActionListener{
	
	private JMenuBar menubar;
	
	public  MyMenu(){
		setTitle("My GUI Menu");
		setSize(300,300);
		setLocation(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    menubar = new JMenuBar();
		setJMenuBar(menubar);
		createFileMenu();
		JMenu character = new JMenu("");
		menubar.add(character);
		createCharacterMenu();
		
		
	}
	public void createFileMenu(){
		JMenu filemenu = new JMenu("file");
		menubar.add(filemenu);
		JMenuItem openItem = new JMenuItem("Open");
		filemenu.add(openItem);
		openItem.addActionListener(this);
		
		JMenuItem closeItem = new JMenuItem("Close");
		filemenu.add(closeItem);
		closeItem.addActionListener(this);
		
		JMenuItem saveItem = new JMenuItem("Save");
		filemenu.add(saveItem);
		saveItem.addActionListener(this);
		
		JMenuItem quitItem = new JMenuItem("Quit");
		filemenu.add(quitItem);
		quitItem.addActionListener(this);
		filemenu.addSeparator();
		
	}
	public void createCharacterMenu(){
		JMenu characterMenu = new JMenu("character");
		menubar.add(characterMenu);
		
		JMenuItem addItem = new JMenuItem("Add character");
		characterMenu.add(addItem);
		addItem.addActionListener(this);
		
		JMenuItem deleteItem = new JMenuItem("Delete character");
		characterMenu.add(deleteItem);
		deleteItem.addActionListener(this);
		
		
	}
	
	
	public static void main(String[] args){
		
	 MyMenu menu = new MyMenu();
	 menu.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Open")){
			JOptionPane.showMessageDialog(null,"YOU CLICKED OPEN","",
			JOptionPane.INFORMATION_MESSAGE);
		}
		
				else if(e.getActionCommand().equals("Close")){
					JOptionPane.showMessageDialog(null,"YOU CLICKED CLOSE","",
					JOptionPane.INFORMATION_MESSAGE);
				}
				
					else if(e.getActionCommand().equals("Save")){
						JOptionPane.showMessageDialog(null,"YOU CLICKED Save","",
						JOptionPane.INFORMATION_MESSAGE);
						}
						
						else if(e.getActionCommand().equals("Quit")){
							JOptionPane.showMessageDialog(null,"YOU CLICKED Quit","",
							JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						  
						  else if(e.getActionCommand().equals("Add character")){
							JOptionPane.showMessageDialog(null,"YOU CLICKED Add character","",
							JOptionPane.INFORMATION_MESSAGE);
						}
						
						else if(e.getActionCommand().equals("Delete character")){
							JOptionPane.showMessageDialog(null,"YOU CLICKED Delete character","",
							JOptionPane.INFORMATION_MESSAGE);
						}
		
			
	}
}