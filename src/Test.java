package guidemover1;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Test {

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub
  // "C:\\Users\\imge\\Desktop\\project\\photos\\photo1.jpg"
  
  JFrame frame = new JFrame();
  MainPanel mainPanel = new MainPanel();
  TestPanel testpanel = new TestPanel();
  //mainPanel.changeSubPanel( new TestPanel() );
  
  
	frame.setTitle("MAIN MENU");
	frame.setBounds(100, 100, 948, 582);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	frame.add( testpanel );
	
	frame.getContentPane().setLayout(null);
	
	
	
	frame.setVisible(true);
 }

}
