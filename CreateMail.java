//CreateMail.java
//johnjoe landers t00174319

import javax.swing.*;
import java.awt.*;

public class CreateMail extends JFrame{
		
		JLabel label1;
		JLabel label2;
		JTextField textField1;
		JTextField textField2;
		JButton button;
		
		public CreateMail(){
			
			
			setTitle("Address Book - Create mail");
			setSize(400,400);
			setLocation(200,200);
			setIconImage(new ImageIcon("Address-Book-icon.png").getImage());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
			Container cPane = new Container();
			cPane.setLayout(new FlowLayout());
			
			JLabel label1 = new JLabel("To:(Enter number of contact) ");
			cPane.add(label1);
			
			JTextField textField1 =new JTextField(20);
			cPane.add(textField1);
				
			JLabel label2 = new JLabel("Enter message here: ");
			cPane.add(label1);
			
			JTextField textField2 =new JTextField(20);
			cPane.add(textField2);
				
			JButton button = new JButton("Enter");
			cPane.add(button);
			
			add(cPane);
			
		
		}
}