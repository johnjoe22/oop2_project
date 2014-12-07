import javax.swing.*;
import java.awt.*;

public class CreateMail extends JFrame{
		
		JLabel item1;
		JLabel item2;
		JButton button;
		
		public void CreateMail(){
			
			JLabel item1 = new JLabel("To: ");
			add(item1);
				
			JLabel item2 = new JLabel("Enter message here: ");
			add(item2);
				
			JButton button = new JButton("Enter");
			add(button);
			
			
		
		}
}