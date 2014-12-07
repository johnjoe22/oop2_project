import javax.swing.*;
import java.awt.*;

public class CreateMail extends JFrame{
		
		private JLabel item1;
		private JLabel item2;
		private JButton button;
		
		public CreateMail(){
			
			item1 = new JLabel("To: ");
			add(item1);
			item2 = new JLabel("Enter message here: ");
			add(item2);
			
			JButton button = new JButton("Enter");
			add(button);
		}
}