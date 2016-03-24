/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;


public class Print {

	
	Connection conn;
	PreparedStatement statement;

	
    public Print(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydata","root","tushar");
            statement = conn.prepareStatement("SELECT * from metadata;");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   

    public void getnPrintAllData(){
    //    String name, supplier, id;
        DefaultTableModel dtm = new DefaultTableModel();
        Window1 gui = new Window1(); //My JPanel class     
        gui.setVisible(true);
        ResultSet res = null;
		try{
            res = statement.executeQuery();
            testResultSet(res);
            ResultSetMetaData meta = (ResultSetMetaData) res.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (res.next())
            {
                Object [] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = res.getObject(i+1);
                }
                dtm.addRow(rowData);
            }
            gui.jtable1.setModel(dtm);
            dtm.fireTableDataChanged();
            //////////////////////////

        }
        catch(Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        finally{
            try{
                res.close();
                statement.close();
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }    

    public void testResultSet(ResultSet res){
        try{
            while(res.next()){
                System.out.println("size "+ res.getInt("size"));
                System.out.println("file name: "+ res.getString("filename"));
                System.out.println("path "+ res.getString("path"));
            }        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String args[]) {
        Print tt = new Print();
        tt.getnPrintAllData();
      }
}
	
	

 class Window1 extends JFrame {

	

	  //QueryTableModel qtm;

	  *//**
	 * 
	 *//*
	public  JTable jtable1;
	

	public Window1() {
	    super("Database Test Frame");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(350, 200);

	    //qtm = new QueryTableModel();
	    jtable1= new JTable();
	    JScrollPane scrollPane = new JScrollPane(jtable1);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setViewportBorder((Border) new LineBorder(Color.RED));
	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(scrollPane, BorderLayout.CENTER);
	
	   
	  }
	
}*/


import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Print {
    public static void main(String[] args) {
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel panel = new JPanel();   //
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Mydata","root","tushar");
            String sql = "Select filename,size,type from metadata order by size asc";
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
                /*	if(i==2)
                	{
                		Float a=(resultSet.getFloat(i)/(1024*1024));
                	a= (Math.round(a*100.0f))/100.0f;   // in mbs....
                	
                	row.addElement(a);	
                	}
                	else */               		
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
        frame.add(panel);   
        //adding panel to the frame
        frame.setLocation(0,0);
        frame.setSize(600,600); //setting frame size
        frame.setTitle("Listing files in incresing order of size(in bytes)..");
        frame.setVisible(true);  //setting visibility true
    }
}
