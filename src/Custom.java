
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.Printable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame1 extends JFrame implements ActionListener
{
	
	JButton bSelect,bFrom,bWhere,bGo,bCancel,bBiggest,bLeastdata,bDelete,bListOld;
	public  static JTextField  fSelect,fFrom,fWhere,fResult;
	public static JCheckBox jcbPath,jcbSize,jcbLastm;
	
	
	
    static String choices;
    CheckBoxListener myListener = null;
	JButton bList;
	
	public MyFrame1()
	{
		setTitle("Custom Queries..");
		setSize(700,850);
		setLocation(0,0);
		Mypanel mp=new Mypanel();
		add(mp);
		
		mp.setBorder(BorderFactory.createLineBorder(new Color(0,0,255),25));
		
		mp.setLayout(new GridLayout(7,2,25,25));
		
		
		
		
		
		//---------------------------------
		 myListener = new CheckBoxListener();

	        // Create check boxes with default selection true 


	        jcbPath = new JCheckBox("path");
//	        jcbGlasses.setMnemonic(KeyEvent.VK_G); 	
		//Alt+G Checks/Unchecks the check Box
	        jcbPath.setSelected(false);
	        jcbPath.addItemListener(myListener);

	        jcbSize = new JCheckBox("size");
	 //     jcbHair.setMnemonic(KeyEvent.VK_H); 	
		//Alt+H Checks/Unchecks the check Box
	        jcbSize.setSelected(false);
	        jcbSize.addItemListener(myListener);

	        jcbLastm = new JCheckBox("lastmodifiedtime");
	      //  jcbTeeth.setMnemonic(KeyEvent.VK_T); 		
		//Alt+T Checks/Unchecks the check Box
	        jcbLastm.setSelected(false);
	        jcbLastm.addItemListener(myListener);
	        jcbLastm.addActionListener(this);

	       ButtonGroup bg=new ButtonGroup();
	       bg.add(jcbLastm);
	       bg.add(jcbPath);
	       bg.add(jcbSize);

	        // Put the check boxes in a column in a panel
	        JPanel jplCheckBox = new JPanel();
	        jplCheckBox.setLayout(new GridLayout(1, 0));	//1 rows, 0 Column
	        jplCheckBox.add(jcbPath);
	        jplCheckBox.add(jcbSize);
	        jplCheckBox.add(jcbLastm);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//------------------------------------
		
		
		bSelect=new JButton("WHAT ?");
		bFrom=new JButton("Location ?");
		bWhere=new JButton("Range (in megabytes) ?");
		bGo=new JButton("Go!..");
		bCancel=new JButton("Cancel!..");
		bList=new JButton("List the data");
	    bLeastdata=new JButton("Least recently used data..");
	    bBiggest=new JButton("Biggest file..");
	    bDelete=new JButton("Delete file..");
	    bListOld=new JButton("List least recently used..");
		
		
		fSelect=new JTextField();
		fFrom=new JTextField("default:selected folder:"+Find.scanDirectory);
		fWhere=new JTextField();
		 fResult=new JTextField();
		
		bCancel.addActionListener(this);
		bList.addActionListener(this);
		bGo.addActionListener(this);
		bLeastdata.addActionListener(this);
		bBiggest.addActionListener(this);
		bDelete.addActionListener(this);
		bListOld.addActionListener(this);
		
		mp.add(bSelect);
		//mp.add(fSelect);
		mp.add(jplCheckBox);
		mp.add(bFrom);
		mp.add(fFrom);
		mp.add(bWhere);
		mp.add(fWhere);
		mp.add(bGo);
		mp.add(bCancel);
		mp.add(bList);
		mp.add(bLeastdata);
		mp.add(bBiggest);
		mp.add(fResult);
		mp.add(bDelete);
		mp.add(bListOld);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		  if(e.getSource()==bCancel)
		  {
			  this.setVisible(false);
			 
		  }
		  else if(e.getSource()==bList)
		  {
			  Print.main(null);	
		  }
		  else if(e.getSource()==bGo)
		  {
			  Selected_Print.t1=this.fSelect.getText();
			  Selected_Print.t3=this.fWhere.getText();
			  Selected_Print.main(null);
		  }
		  else if(e.getSource()==bBiggest)
		  {
			  fResult.setText(db.big_result[0]+"  "+db.big_result[1]);
		  }
		  else if(e.getSource()==bLeastdata)
		  {
			  fResult.setText(db.old_result[0]+"  "+db.old_result[1]);
		  }
		  else if(e.getSource()==bDelete)
		  {
			  Delete.main(null);
		  }
		  else if(e.getSource()==bListOld)
		  {
			  Selected_Print_Time.main(null);
		  }
		  else if(e.getSource()==jcbLastm)
		  {
			  //System.out.println(jcbLastm.getText());
		  }
		
	}
}




//Listens to the check boxes events
class CheckBoxListener implements ItemListener {
  
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
	
	        Object source = arg0.getSource();
	        if (source ==MyFrame1.jcbPath) {
	        	Selected_Print.parameters[1]=MyFrame1.jcbPath.getText();
	        	System.out.println(MyFrame1.jcbPath.getText());
	    
	        } else if (source == MyFrame1.jcbSize) {
	        	Selected_Print.parameters[1]= MyFrame1.jcbSize.getText();
	        	System.out.println(MyFrame1.jcbSize.getText());
	        } else if (source ==MyFrame1.jcbLastm) {
	        	Selected_Print.parameters[1]=(MyFrame1.jcbLastm.getText());
	        	System.out.println(MyFrame1.jcbLastm.getText());      	
	        }

	      /*  if (arg0.getStateChange() == ItemEvent.SELECTED)
	        {
	        	Object e=ItemEvent.SELECTED;
	        	System.out.println(e.toString());
	        }*/
		
	}
}








class Mypanel extends JPanel
{
	public Mypanel()
	{
		setBackground(Color.GRAY);
		setForeground(Color.RED);
		setFont(new Font("lucida console",Font.BOLD,30));
		
	}
	
}



public class Custom {

	 public static void main(String arg[])
	 {
		 MyFrame1 mf=new MyFrame1();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}
