package guidemover1;
import java.awt.*;
import javax.swing.JPanel;
public class MainPanel extends JPanel{

 private SubPanel subPanel;
 
    public void changeSubPanel( SubPanel subPanel ) {
     if (this.subPanel != null)
      this.subPanel.setMainPanel(null);
      
  subPanel.setMainPanel( this );
  this.subPanel = subPanel;
  
     removeAll();
     add( subPanel, BorderLayout.CENTER );
     revalidate();
     repaint();
    }
    
    
}