import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.text.AttributedString;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;


public class Myframe {

	/** 
	 * @param args
	 */
	 private static final String sliceOptions[] = { "Number Of Files", "size" };
	 private static final String Axis1[]={"Size","Creation Time","Modified Time","Last Access Time","Folder","Type"};
	 private static final String SizeArray[]={"None","Big","Small","Medium"};
	 private static final String TimeArray[]={"None","This Year","Last Year","Last Month","This Month"},TypeArray[]={"None","Images","Audio","Text","Ppts","Movies","Zip Files","Web Pages","Executables","Links","Others",};
	 
	 static  JInternalFrame frame4;
	 static  JPanel panel4 = null;
	 static JComboBox combo,combo2;
	 static   ButtonGroup group,group2,group4;
	 static JLabel label3,label5;
	 static int count=0;
	 static Component[] com;
	 static	 String Measure=null,Axis11=null,Axis1_Value=null,Axis22=null,Axis2_Value=null;
	
	 static String radioSelected;
		
		static int flagQ=0;
	 
	 static  final DefaultComboBoxModel model = new DefaultComboBoxModel();
	 static  final DefaultComboBoxModel model2 = new DefaultComboBoxModel();
	 
	 public static HashMap componentMap;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 JFrame frame = new JFrame("Desktop Genie");
       
         JDesktopPane desk = new JDesktopPane();
		
		 frame4 = new JInternalFrame("", false,false,false,false);
		 frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame4.setBounds(701,0,320,625);
		 frame4.setVisible(true);
		 ((javax.swing.plaf.basic.BasicInternalFrameUI) 
       	      frame4.getUI()).setNorthPane(null);
       
         frame4.setResizable(false);
		 
		 frame4.setLayout(new FlowLayout());
		 

		 JPanel panel = new JPanel(new GridLayout(3,0,5,5));
		    //   If title set, create titled border
		 
		  JLabel label = new JLabel("Display:");
          label.setFont(new Font("", Font.PLAIN,20));
		    panel.add(label);
		      Border border = BorderFactory.createEtchedBorder();
		      panel.setBorder(border);
		    
		    //   Create group
		  group = new ButtonGroup();
		    JRadioButton aRadioButton11,aRadioButton12;
		    //   For each String passed in:
		    //   Create button, add to panel, and add to group
		    /*for (int i = 0, n = sliceOptions.length; i < n; i++) {*/
		     
		//------*****-------remove this for loop and
		      //-----******manually add radio buttons
		      //
		      int m=0;
		      
		      aRadioButton11 = new JRadioButton(sliceOptions[m]);
              aRadioButton11.setFont(new Font("Serif", Font.PLAIN,15));
		      panel.add(aRadioButton11);
		      group.add(aRadioButton11);
		      aRadioButton11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		      
		      m++;
		      
		      aRadioButton12 = new JRadioButton(sliceOptions[m]);
              aRadioButton12.setFont(new Font("Serif", Font.PLAIN,15));
		      panel.add(aRadioButton12);
		      group.add(aRadioButton12);
		      aRadioButton12.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		      
		      
		      
		
		     
		    
		      
		
	                                                     
		    
		    
		    frame4.add(panel);
		    
		    
		    //-------------------panel 2----------------
		    
		    
		    JPanel panel2 = new JPanel(new GridLayout(9,0,5,5));
		    //   If title set, create titled border
		 
		  JLabel label2 = new JLabel("Across:");
          label2.setFont(new Font("Serif", Font.PLAIN,20));
		    panel2.add(label2);
		    //  Border border2 = BorderFactory.createEtchedBorder();
		      panel2.setBorder(border);
		    
		    //   Create group
		    group2 = new ButtonGroup();
		     
		    //   For each String passed in:
		    //   Create button, add to panel, and add to group
		  //  for (int i = 0, n = Axis1.length; i < n; i++) {
		      int i=0;
		      
		      //1
		      final JRadioButton aRadioButton21 = new JRadioButton(Axis1[i++]);
		
              aRadioButton21.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton21.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              combo.setEnabled(true);
              
              radioSelected=aRadioButton21.getText();
              
              for(int j = 0; j <SizeArray.length; j++){

              model.addElement(SizeArray[j]);
              }
              label3.setText("Where <"+radioSelected+"> attribute is:");
              }
              }
              );
              		     
              panel2.add(aRadioButton21);
		      group2.add(aRadioButton21);
		
	                                                     
		    //2
		      final JRadioButton aRadioButton22 = new JRadioButton(Axis1[i++]);
				
              aRadioButton22.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton22.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              combo.setEnabled(true);
            
              radioSelected=aRadioButton22.getText();
              

              for(int j = 0; j <TimeArray.length; j++){

              model.addElement(TimeArray[j]);
              }
              label3.setText("Where <Time> attribute is:");
              }
              }
              );
              		     
              panel2.add(aRadioButton22);
		      group2.add(aRadioButton22);
		      
		      //3
		      final JRadioButton aRadioButton23 = new JRadioButton(Axis1[i++]);
				
              aRadioButton23.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton23.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              combo.setEnabled(true);
             
              radioSelected=aRadioButton23.getText();
                            

              for(int j = 0; j <TimeArray.length; j++){

              model.addElement(TimeArray[j]);
              }
              label3.setText("Where <Time> attribute is:");
              }
              }
              );
              		     
              panel2.add(aRadioButton23);
		      group2.add(aRadioButton23);
		      
		      
		      //4
		      final JRadioButton aRadioButton24 = new JRadioButton(Axis1[i++]);
				
              aRadioButton24.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton24.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              combo.setEnabled(true);
            
              radioSelected=aRadioButton24.getText();
              
              

              for(int j = 0; j <TimeArray.length; j++){

              model.addElement(TimeArray[j]);
              }
              label3.setText("Where <Time> attribute is:");
              }
              }
              );
              		     
              panel2.add(aRadioButton24);
		      group2.add(aRadioButton24);
		      
		      //5
		      final JRadioButton aRadioButton25 = new JRadioButton(Axis1[i++]);
				
              aRadioButton25.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton25.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              
              radioSelected=aRadioButton25.getText();
              model.addElement("All Folders");
             
              combo.setEnabled(true);
              label3.setText("Where <"+radioSelected+"> attribute is:");
                 
              }
              }
              );
              		     
              panel2.add(aRadioButton25);
		      group2.add(aRadioButton25);
		      
		      //6
		      final JRadioButton aRadioButton26 = new JRadioButton(Axis1[i++]);
				
              aRadioButton26.setFont(new Font("Serif", Font.PLAIN,15));
              aRadioButton26.addActionListener(new ActionListener()
              {
              public void actionPerformed(ActionEvent e){

              model.removeAllElements();
              
              
              radioSelected=aRadioButton26.getText();
              
              

              for(int j = 0; j <TypeArray.length; j++){

              model.addElement(TypeArray[j]);
              }

              combo.setEnabled(true);
              label3.setText("Where <"+radioSelected+"> attribute is:");
              }
              }
              );
              		     
              panel2.add(aRadioButton26);
		      group2.add(aRadioButton26);
		     // System.out.println("?88**8"+group2.getSelection().toString());
		
		
		
			   		    
	
	
	
	
	
	
	
	
	
			  label3 = new JLabel("Value?");
	          label3.setFont(new Font("Serif", Font.PLAIN,15));
			    panel2.add(label3);
			    
			   combo = new JComboBox(model);
			    
			    combo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						 if(count==0)
						combo.setSelectedIndex(-1);
						  
						 try
					     {
							String str= (String) combo.getSelectedItem();
							Axis1_Value=str;
							 int cmp=str.compareTo("None");
							 if(cmp==0)
							 {

								 for (int a = 0; a < com.length; a++) {  
							         com[a].setEnabled(false);
								 }
								 group4.clearSelection();
								 combo2.setSelectedIndex(-1);
							 }
							 else
							 {
								 for (int a = 0; a < com.length; a++) {  
									 
									// if(!radioSelected.equals(com[a].getName()))
									 {
							         com[a].setEnabled(true);
							        // Component temp;
							        // temp=getComponentName(a);
							        // System.out.println("%%.."+temp.getName());
									 }
								 }
							    
							 }
						     }
						     catch(Exception e)
						     {
						    	 
						     }
							
						 count++;
						// System.out.println("----action--");
						}
				});
			    
			    
			    panel2.add(combo);
			    
			    combo.setEnabled(false);
			    combo.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						// TODO Auto-generated method stub
					
						combo.setSelectedItem(arg0);
				
			
						
 	
						//System.out.println("----item--");
					}
				});
			   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		    frame4.add(panel2);
		    
	/*	    //-----------------panel 3------------------
		    
		    
		    
		    JPanel panel3 = new JPanel(new GridLayout(2,0,5,5));
		 
		  JLabel label3 = new JLabel("Value?");
          label3.setFont(new Font("Serif", Font.PLAIN,20));
		    panel3.add(label3);
		    
		    final JComboBox combo = new JComboBox(model);
		    
		    combo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
						
					
					String t=combo.getSelectedItem().toString();
					int cmp=t.compareTo("None");
					if(cmp!=0)
					{
					
					
					 //-----------------	
						
					}
					else 
					{
						
				   }
					}
			});
		    
		    
		    
		    panel3.add(combo);
		    
		    frame4.add(panel3);
		    */
		    
		    
		    
		    
		    
		    
		    
			// -----display  panel 4--------
		
			 
			   panel4 = new JPanel(new GridLayout(9,0,5,5));
			    //   If title set, create titled border
			 
			  JLabel label4 = new JLabel("And Across:");
	          label4.setFont(new Font("Serif", Font.PLAIN,20));
			    panel4.add(label4);
			      Border border4 = BorderFactory.createEtchedBorder();
			      panel4.setBorder(border4);
			    
			    //   Create group
			     group4 = new ButtonGroup();
		
			       i=0;
			      
			      //1
			      final JRadioButton aRadioButton41 = new JRadioButton(Axis1[i++]);
			
	              aRadioButton41.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton41.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){
	           
	            	  model2.removeAllElements();
	                        
                      String t=aRadioButton41.getText();
	                  for(int j = 0; j <SizeArray.length; j++){

	                  model2.addElement(SizeArray[j]);
	                  }
	                  label5.setText("Where <"+t+"> attribute is:");
	                  }
	            	  
	              }
	              
	              );
	              		     
	              panel4.add(aRadioButton41);
			      group4.add(aRadioButton41);
			      
			      
			      //2--
			      final JRadioButton aRadioButton42 = new JRadioButton(Axis1[i++]);
					
	              aRadioButton42.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton42.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){

	            	  model2.removeAllElements();
	                        

	                  for(int j = 0; j <TimeArray.length; j++){

	                  model2.addElement(TimeArray[j]);
	                  }
	                  
	                  label5.setText("Where <Time> attribute is:");
	              }
	              
	              }
	              
	              );
	              		     
	              panel4.add(aRadioButton42);
			      group4.add(aRadioButton42);
			
			      //3..
			      final JRadioButton aRadioButton43 = new JRadioButton(Axis1[i++]);
					
	              aRadioButton43.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton43.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){
	            	

	            	  model2.removeAllElements();
	                        

	                  for(int j = 0; j <TimeArray.length; j++){

	                  model2.addElement(TimeArray[j]);
	                  }
	                  label5.setText("Where <Time> attribute is:");
	                  }
	            	  
	              }
	              
	              );
	              		     
	              panel4.add(aRadioButton43);
			      group4.add(aRadioButton43);
			      
			      
			      //4...
			      final JRadioButton aRadioButton44 = new JRadioButton(Axis1[i++]);
					
	              aRadioButton44.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton44.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){
	            	  

	            	  model2.removeAllElements();
	                        

	                  for(int j = 0; j <TimeArray.length; j++){

	                  model2.addElement(TimeArray[j]);
	                  }
	                  label5.setText("Where <Time> attribute is:");
	                  }
	            	
	            	  
	              }
	              );
	              		     
	              panel4.add(aRadioButton44);
			      group4.add(aRadioButton44);
			      
			      //5..
			      final JRadioButton aRadioButton45 = new JRadioButton(Axis1[i++]);
					
	              aRadioButton45.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton45.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){

	            	  model2.removeAllElements();
	                  String t=aRadioButton45.getText();      
	            	 // model2.addElement("None");
	            	  model2.addElement("All folders");

		              label5.setText("Where <"+t+"> attribute is:");
		              }
	                  }
	            	  
	              
	              );
	              		     
	              panel4.add(aRadioButton45);
			      group4.add(aRadioButton45);
			      
			      //6..
			      final JRadioButton aRadioButton46 = new JRadioButton(Axis1[i++]);
					
	              aRadioButton46.setFont(new Font("Serif", Font.PLAIN,15));
	              aRadioButton46.addActionListener(new ActionListener()
	              {
	              public void actionPerformed(ActionEvent e){
	            	  model2.removeAllElements();
                      
	            	  model2.removeAllElements();
	                  String t=aRadioButton46.getText();
	                  for(int j = 0; j <TypeArray.length; j++){

	                  model2.addElement(TypeArray[j]);
	                  }

		              label5.setText("Where <"+t+"> attribute is:");
		              }
	            	 
	              }
	              
	              );
	              		     
	              panel4.add(aRadioButton46);
			      group4.add(aRadioButton46);
			      
			      
			      
			      
			      label5 = new JLabel("Value?");
		          label5.setFont(new Font("Serif", Font.PLAIN,15));
				    panel4.add(label5);
				    
				   combo2 = new JComboBox(model2);
				    
				    combo2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
							String str= (String) combo2.getSelectedItem();
							//System.out.println("--2--"+str);
							Axis2_Value=str;
							
							}
					});
			      
				    panel4.add(combo2);
			
			      
				    
				    
				    
				    
				    
				  JButton bUpdateReport=new JButton("Update Report");  
				   // bUpdateReport.setSize(250,100);
				  bUpdateReport.setFont(new Font("", Font.PLAIN,15));
				  bUpdateReport.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//MultipleFrames.desk.remove(MultipleFrames.frame4);
						//MultipleFrames.desk.add(MultipleFrames.frame2);
						//MultipleFrames.desk.remove(MultipleFrames.frame4);
						MultipleFrames.frame4.dispose();
						
						//if()
					      
						  Measure=null;Axis11=null;Axis22=null;
						
						  int flag=0;
						 String text = null;
					      for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
					            AbstractButton button = buttons.nextElement();

					            if (button.isSelected()) {
					               text= button.getText();
					               // System.out.println("--"+text);
					                /*int cmp=text.compareTo("Size");
								      if(cmp==0)
								      {
								    	  MultipleFrames.Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery7";
								      }
								      else
								      {
								    	  MultipleFrames.Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery6";
								      }*/
					                  Measure=text;
					                  flag=1;
					            }
					            
					          if(flag==1)
					        	  break;
					        }
					  

						flag=0;
						String text1=null;
						for (Enumeration<AbstractButton> buttons = group2.getElements(); buttons.hasMoreElements();) {
				            AbstractButton button = buttons.nextElement();

				            if (button.isSelected()) {
				               text1= button.getText();
				               Axis11=text1;
				               flag=1;
				            }
				         if(flag==1)
				        	 break;
						}
						
						
						flag=0;
						String text2=null;
						for (Enumeration<AbstractButton> buttons = group4.getElements(); buttons.hasMoreElements();) {
				            AbstractButton button = buttons.nextElement();

				            if (button.isSelected()) {
				               text2= button.getText();
				               Axis22=text2;
				               flag=1;
				            }
				         if(flag==1)
				        	 break;
						}
						
					      
						System.out.println("Mesures:"+Measure+" Axis1:"+Axis11+" Axis2:"+Axis22);
						System.out.println("----"+Axis1_Value+"--"+Axis2_Value);
						
						try {
							DynamicQuery.main(null);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						if(flagQ==0)
						{
						MultipleFrames.Query="http://localhost:8080/mondrian/testpage.jsp?query=DynamicQuery";	
						flagQ=1;
						System.out.println("Dynamic..");
						}
						else
						{
							if(flagQ==1)
							{
								MultipleFrames.Query="http://localhost:8080/mondrian/testpage.jsp?query=Temporary";	
								flagQ=0;
								System.out.println("Temporary..");
							}
						}
						MultipleFrames.frame.dispose();
						MultipleFrames.main(null);
                        //MultipleFrames.frame4=Myframe.frame4;
                       // MultipleFrames.desk.remove(MultipleFrames.frame2);
						//MultipleFrames.desk.add(frame4);
						//MultipleFrames.desk.add(MultipleFrames.frame2);	
					}
				});
				  
				    frame4.add(bUpdateReport);
				    
				      
				    
			      frame4.add(panel4);
			
			      com = panel4.getComponents();  
			     
			    for (int a = 0; a < com.length; a++) {  
			         com[a].setEnabled(false);  
			    } 
			    
			    
			    
		       
		    
		    
		    
		    
		    
		    
		    
		    //-------------main frame---------------
		    
		    
		    
		    desk.add(frame4);
		    frame.add(desk);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         frame.setBounds(0,0,1030,730);
	         frame.setVisible(false);
	         frame.setResizable(false);
		    

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static  void createComponentMap() {
        componentMap = new HashMap<String,Component>();
        Component[] components = panel4.getComponents();
        for (int i=0; i < components.length; i++) {
                componentMap.put(components[i].getName(), components[i]);
        }
}

public  Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}

public static Component getComponentName(int id) {
    if (componentMap.containsKey(id)) {
    	  return (Component) componentMap.get(id);
    }
    else return null;
}
	
	
}
