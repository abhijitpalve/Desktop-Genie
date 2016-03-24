import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.StringUtils;

public class Selected_Print_Time {
   
	//static int var1=1,var2=4;
	static String Filename="filename",Size="size",Lastaccess="lastaccesstime";
	//static String t1,t2,t3;
	
	
    public static void main(String[] args) {
        Vector columnNames = new Vector();
        Vector data = new Vector();
       
        JPanel panel = new JPanel();   
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/Mydata","root","tushar");
      //      System.out.println(Filename+" "+Size);
            
         /*   int cnt=0,cnt1=0;;
            for(int i=0;i<t1.length();i++)
            {
            	if(t1.charAt(i)==',')
            		cnt++;
            }
            cnt++;
            String parameters[]=new String[cnt];
                             parameters=t1.split(",");
                             
            for(int i=0;i<cnt;i++)
            {
            	Filename=parameters[i];
            }
                             for(int i=0;i<t3.length();i++)
                             {
                             	if(t3.charAt(i)==',')
                             		cnt1++;
                             }
                             cnt1++;
                             
                             String parameters1[]=new String[cnt1];
                             parameters1=t3.split(",");
                             
                             
            //var1=var1*1024*1024;
            //var2=var2*1024*1024;
                             for(int i=0;i<cnt1;i++)
                             {
                            	 int x=Integer.parseInt(parameters1[i])*1024*1024;
                            	 parameters1[i]=String.valueOf(x);
                             }*/
            String sql = "Select "+Filename+","+Size+","+Lastaccess+" from metadata order by lastaccesstime";
                  
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
        JScrollPane scrollPane = new JScrollPane(table);        panel.add(scrollPane);               
        JFrame frame = new JFrame();
        frame.add(panel);         //adding panel to the frame
        frame.setSize(600, 500); //setting frame size
        frame.setVisible(true);  //setting visibility true
    }
}