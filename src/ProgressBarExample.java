import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.html.*;

public class ProgressBarExample extends JFrame{
    int i=0;
    Timer timer,timer1;
    final JProgressBar pb;
    public ProgressBarExample() {

    final JLabel label=new JLabel();
    final JButton button = new JButton("Proceed!!");
     pb = new JProgressBar(0,22);
        pb.setValue(0);
        pb.setStringPainted(true);
        JPanel panel = new JPanel();
       panel.add(button);
       button.setEnabled(false);
       
       
        panel.add(pb);
        JPanel panel1 = new JPanel();
        panel1.add(panel, BorderLayout.NORTH);
        panel1.add(label, BorderLayout.CENTER);
        add(panel1);
        setSize(300,100);
        setVisible(true);
        setTitle("Desktop Genie");
        
       
        timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        if (i == 22){
          Toolkit.getDefaultToolkit().beep();
          timer.stop();
          button.setEnabled(true);
          pb.setValue(0);
          String str = "<html><font color=red>" + "<b>" + "Scan is completed!!" + "</b>" + "</font>" + "</html>";
          label.setText(str);
        }
        i = i + 1;
        try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                pb.setValue(i);

            }
        });
        
        
        
        
        String str = "<html><font color=green><b>Scaning is in process.......</b></font></html>";
        label.setText(str);
        timer.start();

       button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			DemoJFileChooser.spb.setVisible(false);
			// Page1 p=new Page1();
		  	  //p.setVisible(true);
		      
		     MultipleFrames.main(null);
		}
	});
   
    }
   public static void main(String[] args) {
        ProgressBarExample spb = new ProgressBarExample();
    }
}