//CreateMail.java
//johnjoe landers t00174319

import javax.swing.*;
import java.awt.*;

public class CreateMail extends JFrame{
		
		JLabel item1;
		JLabel item2;
		JButton button;
		JTextField textField1;
		JTextField textField2;
		
		public void CreateMail(){
			
			JLabel label1 = new JLabel("To: ");
			add(label1);
			
			JTextField textField1 =new JTextField(20);
			add(textField1);
				
			JLabel label2 = new JLabel("Enter message here: ");
			add(label1);
			
			JTextField textField2 =new JTextField(40);
			add(textField2);
				
			JButton button = new JButton("Enter");
			add(button);
			
			
		
		}
}