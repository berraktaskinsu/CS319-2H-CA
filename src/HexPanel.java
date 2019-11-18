package guidemover1;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


import javax.swing.*;

public class HexPanel extends SubPanel {
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 1232;
    private final int HEIGHT = 640;

    private Font font = new Font("Arial", Font.BOLD, 18);
    FontMetrics metrics;

    public HexPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
    	//super.paintComponent(g)
    	Image img = new ImageIcon("C:/Users/User/Desktop/2.png").getImage();
	    g.drawImage(img, 0, 0, null);
	    
        Graphics2D g2d = (Graphics2D) g;
        Point origin = new Point(WIDTH / 2, HEIGHT / 2);

        g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();

        drawCircle(g2d, origin, 180, true, true, 0x88EEFB, 0); //this is the sea
        drawHexGridLoop(g2d, origin, 5, 30, 8);
    }

    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * (radius + padding);
        double yOff = Math.sin(ang30) * (radius + padding);
        int half = size / 2;

        for (int row = 0; row < size; row++) {
            int cols = size - java.lang.Math.abs(row - half);

            for (int col = 0; col < cols; col++) {
                int xLbl = row < half ? col - row : col - half;
                int yLbl = row - half;
                int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
                int y = (int) (origin.y + yOff * (row - half) * 3);

                drawHex(g, xLbl, yLbl, x, y, radius);
            }
        }
    }

    private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
        Graphics2D g2d = (Graphics2D) g;

        Hexagon hex = new Hexagon(x, y, r);
        String text = String.format("%s : %s", coord(posX), coord(posY));
        int w = metrics.stringWidth(text);
        int h = metrics.getHeight();

        hex.draw(g2d, x, y, 0, 0x8FC54B, true); //this is the green color
        hex.draw(g2d, x, y, 4, 0xFFDD88, false); //this is the border yellow color

        g.setColor(new Color(0xFFFFFF));
        //g.drawString(text, x - w/2, y + h/2); //this tells us the row col info of the hex
    }

    private String coord(int value) {
        return (value > 0 ? "+" : "") + Integer.toString(value);
    }

    public void drawCircle(Graphics2D g, Point origin, int radius,
            boolean centered, boolean filled, int colorValue, int lineThickness) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        int diameter = radius * 2;
        int x2 = centered ? origin.x - radius : origin.x;
        int y2 = centered ? origin.y - radius : origin.y;

        if (filled)
            g.fillOval(x2, y2, diameter, diameter);
        else
            g.drawOval(x2, y2, diameter, diameter);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }


    public static void main(String[] args) {
        JFrame f = new JFrame();
        HexPanel p = new HexPanel();
        p.setLayout(null);
        
        //f.getContentPane().setLayout(null);
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int x = 503;
        int y = 220;
        int rowNo = 4;
        
        //Buttons for second row city/villages
        for( int j = 0; j <4; j++) {
        	for(int i = 0; i < rowNo; i ++){
            	JButton btn = new JButton("");
        		btn.setBounds(x, y, 18, 12);
        		btn.setOpaque(false);
        		btn.setContentAreaFilled(false);
        		btn.setBorderPainted(false);
        		btn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				btn.setVisible(true);
        				btn.setBorderPainted(true);
        				btn.setContentAreaFilled(true);
        				btn.setBackground(Color.RED);
        		        //System.out.println("x = " + x + "y = " + y);
        		        //drawCircle(x,y);    
        			}
        		});
        		p.add(btn);
        		x = x + 69;
            }
        	y = y + 58;
        	x = 503;
        }
        
        
        //Roads for second row roads
        x = 523;
        y = 230;
        rowNo = 6;
        for ( int j = 0; j < 4; j++) {
        	for(int i = 0; i < rowNo; i ++){
            	JButton btn1 = new JButton("");
        		btn1.setBounds(x, y, 18, 12);
        		btn1.setOpaque(false);
        		btn1.setContentAreaFilled(false);
        		btn1.setBorderPainted(false);
        		btn1.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				btn1.setVisible(true);
        				btn1.setBorderPainted(true);
        				btn1.setContentAreaFilled(true);
        				btn1.setBackground(Color.RED);
        			}
        		});
        		p.add(btn1);
        		x = x + 34;
            }
            y = y +59;
            x = 523;
        }
        
        //Buttons for third row city/villages
        x = 540;
        y = 175;
        rowNo = 3;
        for ( int j = 0; j < 6; j++) {
        	for(int i = 0; i < rowNo; i ++){
            	JButton btn3 = new JButton("");
        		btn3.setBounds(x, y, 18, 12);
        		btn3.setBounds(x, y, 18, 12);
        		btn3.setOpaque(false);
        		btn3.setContentAreaFilled(false);
        		btn3.setBorderPainted(false);
        		btn3.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				btn3.setVisible(true);
        				btn3.setBorderPainted(true);
        				btn3.setContentAreaFilled(true);
        				btn3.setBackground(Color.RED);
        			}
        		});
        		p.add(btn3);
        		x = x + 69;
            }
        	x = 540;
        	y = y + 55;
        }
        
       
        JLabel playerName = new JLabel("Player 1");
		playerName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setBounds(415, 43, 400, 54);
		p.add(playerName);
		
		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setHorizontalAlignment(SwingConstants.CENTER);
		btnAccept.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 22));
		btnAccept.setBounds(766, 538, 230, 54);
		p.add(btnAccept);
		f.getContentPane().add(p);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
