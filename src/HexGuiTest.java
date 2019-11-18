package guidemover1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class HexGuiTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HexGuiTest window = new HexGuiTest();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HexGuiTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1250, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(180, 176, 102, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(525, 252, 25, 15);
		frame.getContentPane().add(button);
		
		JLabel playerName = new JLabel("TEXT");
		playerName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setBounds(415, 43, 359, 54);
		frame.getContentPane().add(playerName);
		
		JLabel lblAccept = new JLabel("ACCEPT");
		lblAccept.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccept.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		lblAccept.setBounds(966, 538, 230, 54);
		frame.getContentPane().add(lblAccept);
		
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
