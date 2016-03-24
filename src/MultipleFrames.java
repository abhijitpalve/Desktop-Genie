import javax.swing.*;

import com.teamdev.jxbrowser.Browser;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import com.teamdev.jxbrowser.Browser;
import com.teamdev.jxbrowser.BrowserFactory;
import com.teamdev.jxbrowser.BrowserType;

import java.awt.*;
import java.awt.event.*;



public class MultipleFrames {
        static JDesktopPane desk;
        int query=0;
        static JFrame frame;
        
        static JInternalFrame frame1,frame2,frame3,frame4;
        static Browser browser = BrowserFactory.createBrowser(BrowserType.IE);

        
        //**needs to be done...
        
        static String Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery";
        
        public static void main(String[] args) {
                MultipleFrames d = new MultipleFrames();
        }

        public MultipleFrames() {
                frame = new JFrame("Desktop Genie");
               // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                desk = new JDesktopPane();
                frame1 = new JInternalFrame("",false,false,false,false);
                //frame1.setUndecorated(true);
                frame1.setBounds(0,0,700,705);
                frame1.setVisible(true);
                //frame1.setBackground(Color.GREEN);
                
                frame1.setResizable(false);
              
                
                //Browser browser = (Browser) BrowserFactory.getDefaultBrowserType();
                
                frame1.add(browser.getComponent(), BorderLayout.CENTER);
                
               // frame1.setLocationRelativeTo(null);
              //  frame1.setUndecorated(true);
                frame1.setVisible(true);
             
                browser.refresh();
                browser.navigate(Query);
                
                
                ((javax.swing.plaf.basic.BasicInternalFrameUI) 
                	      frame1.getUI()).setNorthPane(null);
                
                
                
                
                frame2 = new JInternalFrame("", false,false,false,false);
                frame2.setBounds(701,0,320,625);
                frame2.setVisible(true);
                //frame2.setBackground(Color.BLUE);
               
                ((javax.swing.plaf.basic.BasicInternalFrameUI) 
                	      frame2.getUI()).setNorthPane(null);
                
                frame2.setResizable(false);
                
                frame2.setLayout(new FlowLayout());
                
           
                //1)recent data 2) w.r.t size 3) w.r.t type
                JPanel p2=new JPanel();
                p2.setLayout(new FlowLayout());
                
                JLabel label = new JLabel("Custom Queries");
                label.setFont(new Font("Serif", Font.PLAIN,44));
                label.setLocation(5,50);
                //label.setSize(300,300);
                //label.setPreferredSize(new Dimension(300,200));
                p2.add(label);
                
                frame2.add(p2);
                
              //  frame2.setLayout(null);
                JPanel p1=new JPanel();
                
                p1.setLayout(new GridLayout(5,0,0,25));
                
                ButtonGroup bgroup = new ButtonGroup();
                
                JRadioButton first = new JRadioButton("Recent data in my computer?");
                first.setFont(new Font("Serif", Font.PLAIN,24));
                
                JRadioButton second = new JRadioButton("Folders according to size? ");
                second.setFont(new Font("Serif", Font.PLAIN,24));
                
                JRadioButton third = new JRadioButton("Data according to type?");
                third.setFont(new Font("Serif", Font.PLAIN,24));
                
                JRadioButton fourth = new JRadioButton("Data according to size(range)?");
                fourth.setFont(new Font("Serif", Font.PLAIN,24));
                              
                JRadioButton fifth = new JRadioButton("Oldest data in my pc?");
                fifth.setFont(new Font("Serif", Font.PLAIN,24));
                
                ButtonGroup bg=new ButtonGroup();
                bg.add(first);
                bg.add(second);
                bg.add(third);
                bg.add(fourth);
                bg.add(fifth);
                
              
                
                first.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						query=1;
					}
				});
                
                second.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						query=2;
					}
				});
                
                third.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						query=3;
					}
				});
                
                fourth.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						query=4;
					}
				});
                
                fifth.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						query=5;
					}
				});
                
               
                
                
            
              //  bUpdateChart.setPreferredSize(new Dimension(55, 55));
               /* first.setLocation(5,60);
                second.setLocation(5,80);
                third.setLocation(5,90);
                */
               // frame2.add(first,0);
               // frame2.add(second,1);
                //frame2.add(third,2);
               
                p1.add(first,0);
                p1.add(second,1);
                p1.add(third,2);
                p1.add(fourth,3);
                p1.add(fifth,4);
                

                frame2.add(p1);
                
                JPanel p3= new JPanel(new GridLayout(2,3,30,60));
                JButton bUpdateChart=new JButton("Update Chart");
                bUpdateChart.setPreferredSize(new Dimension(100,60));
                
                JButton bReport=new JButton("Customized Report");
                bReport.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						frame2.dispose();
						Myframe.main(null);
						MultipleFrames.frame4=Myframe.frame4;
						
						desk.add(frame4);
						
					}
				});
                
                
                bUpdateChart.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						if(query==1)
						{
							Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery1";
							MultipleFrames.main(null);
						}
						else
						{
							if(query==2)
							{
								Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery2";
								MultipleFrames.main(null);
							}
							else
							{
								if(query==3)
								{
									Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery3";
									MultipleFrames.main(null);
								}
								else
								{
									if(query==4)
									{
										Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery4";
										MultipleFrames.main(null);
									}
									else
									{
										if(query==5)
										{
										Query="http://localhost:8080/mondrian/testpage.jsp?query=Myquery5";
										MultipleFrames.main(null);	
										}
									}
								}
							}
								
					     }
						
				  	}	
				});
                
                p3.add(bUpdateChart);
                p3.add(bReport);
                
               
                
                frame2.add(p3);
                
               
                
              
                
           
                
                
                
             
               
               
            
               // bUpdateChart.setLocation(200,500);
                //bUpdateChart.setSize(100,100);
            
               // frame2.add(bUpdateChart);
               // frame2.setBackground(Color.BLUE);
                
                
                
                
                
                
                
                
                
                
                
               
                //----------------------------------------------------
                frame3 = new JInternalFrame("",false,false,false,false);
                frame3.setBounds(701,626,320,75);
                frame3.setVisible(true);
              //frame3.setBackground(Color.BLUE);
                
                frame3.setResizable(false);
                
               //frame3.setLayout(new FlowLayout());
                frame3.setLayout(null);
                
                JButton bRescan=new JButton("Rescan");
                JButton bHelp=new JButton("Help");
                JButton bStats=new JButton("Stastics");
                
                bRescan.setLocation(10,10);
                bRescan.setSize(90,40);
                bHelp.setLocation(110,10);
                bHelp.setSize(90,40);
                bStats.setLocation(210,10);
                bStats.setSize(90,40);
                
               /* JPanel p1=new JPanel();
                p1.setLayout(null);
                p1.add(bRescan);
                p1.add(bHelp);
                p1.add(bStats);
                p1.setSize(1000,60);
                frame3.add(p1);*/
                
                frame3.add(bRescan);
                frame3.add(bHelp);
                frame3.add(bStats);
                
                //desk.add(p1);
                
                bStats.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Custom.main(null);
						
					}
				});
               
                
                
                ((javax.swing.plaf.basic.BasicInternalFrameUI) 
                	      frame3.getUI()).setNorthPane(null);
                  
                
                
                
                //--------------------------------------------------------

                desk.add(frame1);
                desk.add(frame2);
                desk.add(frame3);
                
                
                //---------------frame 4 later one..
                
            
                frame4 = new JInternalFrame("", false,false,false,false);
                frame4.setBounds(701,0,320,625);
                frame4.setVisible(true);
                frame4.setBackground(Color.green);
               
                ((javax.swing.plaf.basic.BasicInternalFrameUI) 
                	      frame4.getUI()).setNorthPane(null);
                
                frame4.setResizable(false);
                
                
                
               
            
                frame.add(desk);
                frame.setBounds(0,0,1030,730);   
               // frame.setResizable(false);
                //frame.setUndecorated(true);  //
                //REMOVES THE TITLE BAR OF FRAME........................
                
                
                frame.setVisible(true);
                frame.setResizable(false);
               // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //frame.addWindowListener(new MyWndAdapter(frame));
                
        }
}





class MyWndAdapter extends WindowAdapter
{
	
	JFrame p;
  public MyWndAdapter(JFrame frame) {
		// TODO Auto-generated constructor stub
	  this.p=frame;
	}

public void windowClosing(WindowEvent we)
  {
	  p.dispose();
	  System.exit(0);
  }
  
}

