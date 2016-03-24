
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;


public class DemoJFileChooser extends JPanel
   implements ActionListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = -8828476330360421898L;

JButton go;
   
   JFileChooser chooser;
   String choosertitle;
   
   static ProgressBarExample spb;
   
  public DemoJFileChooser() {
   /* go = new JButton("You have not selected a folder to scan." +
    		"Please select a folder..");
    go.setLocation(20,20);
    go.addActionListener(this);

    
    add(go);*/
	  
	  int result;
      
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle(choosertitle);
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    //
	    // disable the "All files" option.
	    //
	    chooser.setAcceptAllFileFilterUsed(false);
	    //    
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    /*  System.out.println("getCurrentDirectory(): " 
	         +  chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " 
	         +  chooser.getSelectedFile());*/
	    	
	    	
	    	
	        //----progress bar--
	        
	       spb = new ProgressBarExample();
	        spb.setVisible(true);
	        spb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        spb.setLocation(400,300);
	        
	        //----progress bar--
	        
	        this.setVisible(false);
	        
	       // Start.frame.setVisible(false);
	    	
	    	
	    	
	    	
	    	Find.scanDirectory=chooser.getSelectedFile().toString();  // the directory choosen for scanning..
	    	
	      
	        
	      try {
				Find.main(null);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      //this.setVisible(false);
	      
	   
	      //spb.i=20;
	      
	
	  
	      }
	    else {
	      System.out.println("No Selection ");
	      }
	     }
	   
   

  
   
  public Dimension getPreferredSize(){
    return new Dimension(0,0);
    }
    
  public static void main(String s[]) {
    JFrame frame = new JFrame("");
    DemoJFileChooser panel = new DemoJFileChooser();
    frame.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
    frame.getContentPane().add(panel,"Center");
    frame.setSize(panel.getPreferredSize());
    frame.setBackground(Color.GRAY);
    frame.setVisible(false);
    }
  
  public static void dispatch()
  {
	  
  }





@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
  
  
}


