package guidemover1;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TestPanel extends SubPanel {
	public TestPanel() throws IOException {initComponents();}
	
	public void initComponents() throws IOException {
		System.out.println("hiiiii");
		
		setBounds(0, 0, 930, 535);
		
		setLayout(null);
		
		btnNewButton = new JButton("START GAME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(353, 123, 186, 69);
		add(btnNewButton);
		
		btnSettngs = new JButton("SETTINGS");
		btnSettngs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSettngs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnSettngs.setBounds(353, 245, 186, 69);
		add(btnSettngs);
		
		btnHowToPlay = new JButton("HOW TO PLAY");
		btnHowToPlay.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnHowToPlay.setBounds(353, 376, 186, 69);
		add(btnHowToPlay);
		
	
		 
		 
		
	}
	  public void paintComponent(Graphics g) {
		  Image img = new ImageIcon("C:/Users/User/Desktop/1.jpg").getImage();
		    g.drawImage(img, -75, 0, null);
		  }
	private JButton btnNewButton;
	private JButton btnSettngs;
	private JButton btnHowToPlay;
	
}
