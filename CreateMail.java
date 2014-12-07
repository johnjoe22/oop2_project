import javax.swing.*;
import java.awt.*;

public class CreateMail extends JFrame{
		
		JLabel item1;
		JLabel item2;
		JButton button;
		
		public void CreateMail(){
			
			item1 = new JLabel("To: ");
			item1.setSize(30,30);
			add(item1);
				
			item2 = new JLabel("Enter message here: ");
			item1.setSize(30,30);
			add(item2);
				
			button = new JButton("Enter");
			item1.setSize(30,30);
			add(button);
			
			
		
		}
}