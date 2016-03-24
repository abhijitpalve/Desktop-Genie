
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Delete extends JFrame
   {
   //JButton go;
   
   JFileChooser chooser;
   String choosertitle;
   
  public Delete() {
   
    int result;
        
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("Delete");
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    chooser.setApproveButtonText("Delete");

    chooser.setAcceptAllFileFilterUsed(false);    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  chooser.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  chooser.getSelectedFile());
      
       File fw=new File(chooser.getSelectedFile().getAbsolutePath());      
    
        
    	
    	 if(fw.delete())
    	 {
         JOptionPane.showMessageDialog(null,"File successfully deleted!!...","Deletion",1);  
    	 }
    	 else
    	 {
    		 JOptionPane.showMessageDialog(null,"File not deleted!!...","Deletion",1); 
    	 }
          this.setVisible(false);
          
    	
    }
      
    else if(chooser.showOpenDialog(this)==JFileChooser.CANCEL_OPTION)
    {
    	System.out.println("********closing....");
    	this.setVisible(false);
    	JOptionPane.showMessageDialog(null,"exiting!!...","Deletion",1); 
    	System.exit(1);
    	
    }
    
    else {
      System.out.println("No Selection ");
      }
     }
   
  /*public Dimension getPreferredSize(){
    return new Dimension(600,600);
    }*/
    
  public static void main(String s[]) {
  //  JFrame frame = new JFrame("");
    Delete frame = new Delete();
    /*frame.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );*/
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
//    frame.getContentPane().add(panel,"Center");
  //  frame.setSize(panel.getPreferredSize());
    frame.setBackground(Color.GRAY);
    frame.setVisible(true);
    }
     public void close(Delete frame)
     {
    	   frame.dispose();
     }
}

