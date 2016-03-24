import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class NewCustomPage {

	 static  JInternalFrame frame25;
	 
	  public static void main()
	  {

			 JFrame frame = new JFrame("Desktop Genie");
		       
		         JDesktopPane desk = new JDesktopPane();
				
				 frame25 = new JInternalFrame("", false,false,false,false);
				 frame25.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame25.setBounds(701,0,320,625);
				 frame25.setVisible(true);
				 ((javax.swing.plaf.basic.BasicInternalFrameUI) 
		       	      frame25.getUI()).setNorthPane(null);
				 
		         frame25.setResizable(false);
		         
		         
	  }
	
}
