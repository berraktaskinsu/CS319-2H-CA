package guidemover1;


import javax.swing.JPanel;
import java.awt.*;
public class SubPanel extends JPanel {

 private MainPanel mainPanel;
 
    public SubPanel() {
    }
    
    public void setMainPanel( MainPanel mainPanel ) {
     
     this.mainPanel = mainPanel;
    }
    
    public MainPanel getMainPanel() {
     
     return mainPanel;
    }

    
}