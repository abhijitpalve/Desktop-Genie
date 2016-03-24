import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
//import java.util.Date;

public class db 
{
	 static Connection con;
	 static PreparedStatement pst;
	 static int max;
	 static String big_result[]=new String[2];
	 static String old_result[]=new String[2];
	 
	/*public static void main(String file[]) throws IOException
	 {
		 isConnected();
		 doWork();
		 display();
	 }*/
	 public static void main(String file) throws IOException
	 {
		
		 System.out.println(isConnected());
		 System.out.println("****************");
		 doWork();
		 System.out.println("****************");
		 DataInsertion.parseFile(file);
		 		 
		 db.Maxsize();
		  
		  
	 }
	 
	 
	
	public static void Maxsize() {
		// TODO Auto-generated method stub
		 Float max = null;
		 Timestamp t1 = null;
		 Date d1 = null;
		 try{
             Statement  stmt = con.createStatement();
             String query = "SELECT MAX(size) FROM metadata";
             ResultSet rs=stmt.executeQuery(query);                  
             //Extact result from ResultSet rs
             while(rs.next()){
            	max=rs.getFloat("MAX(size)");
                 System.out.println("MAX(size)=####"+rs.getInt("MAX(size)"));                              
               }
            // max=rs.getInt("MAX(size)");
             
             ResultSet rs1=stmt.executeQuery("Select filename from metadata where size="+max+"");
             while(rs1.next()){
                 System.out.println(" --filename :#####"+rs1.getString("filename"));
                 big_result[0]=rs1.getString("filename");
                 big_result[1]=max.toString();
             }
             
             
             
             ResultSet rs3=stmt.executeQuery("Select min(lastaccesstime) from metadata ");
             while(rs3.next()){
                 //t1=rs3.getTimestamp("min(lastaccess)");
                //d1=new Date(t1.getTime());
                // System.out.println(" -&&&&&&&&-min_lastaccess :"+t1+" d1:"+d1);
            	 d1=rs3.getDate("min(lastaccesstime)");
            	// System.out.println(" -&&&&&&&d1:"+d1);
             }
             
             ResultSet rs2=stmt.executeQuery("Select filename,size from metadata where lastaccesstime='"+d1+"'");
             while(rs2.next()){
                 //System.out.println("***--- filename :"+rs2.getString("filename")+" size:"+rs2.getInt("size"));
                 old_result[0]=rs2.getString("filename");
                 old_result[1]=String.valueOf(rs2.getInt("size"));
             }
             
             
             
             
             // close ResultSet rs
             rs1.close();
             rs.close();
             rs2.close();
             rs3.close();
             con.close();
             stmt.close();
        } catch(SQLException s){                                             
                     s.printStackTrace();
                     System.out.println("error in queries..max..");
              }
   
     
     }
		
	
	public static boolean isConnected() 
	 {
		 try 
		 { 
			 Class.forName("com.mysql.jdbc.Driver");			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydata","root","tushar");
			 System.out.println("connected sussesfully!!!!!!!!!!!!!1");
		 } 
		 catch( Exception e ) 
		 {
			 System.out.println("Err in driver or username or password");
			 e.printStackTrace();
			 return false;
		 }
		 return true;
	 }
	 public static void doWork()
	 {
		 try
		 {
			Statement stmt=con.createStatement();
			stmt.executeUpdate("truncate metadata");
			System.out.println("deleleted entires..!!");
			pst=con.prepareStatement("insert into metadata values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("err in creating sql stmts..");
			e.printStackTrace();
		 }
	 }
	 public static void insertToDatabase(String[] fields)
	 {
		 
		 String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		 
		 
		 for(int i=0;i<fields.length;i++)
			 System.out.println(fields[i]);
		 try {
			 
			 int len=fields[0].length();
			 if(len<=2)
			 {
				 pst.setString(1,fields[0]);
			 }
			 else	
			 {
			pst.setString(1,fields[0].substring(2));
			 }
			pst.setString(2,fields[1]);
			pst.setString(3,fields[2]);
			pst.setString(4,fields[3]);
			//pst.setLong(5,Long.parseLong(fields[4]));
			if(fields[4].length()>0)
			{
			Float f=Float.parseFloat(fields[4]),f1=0f;
			int check=f.compareTo(f1);
			if(check==0)
			{
				System.out.println("checked!!!!!!!........");
			}
			
			
			System.out.println(fields[4]+"..");
			
			
			pst.setFloat(5,((Float.parseFloat(fields[4]))/(1024*1024)));
		    }
			else
			{
				pst.setFloat(5,0f);
			}
			
			
			pst.setBoolean(6,Boolean.parseBoolean(fields[5]));
			pst.setBoolean(7,Boolean.parseBoolean(fields[6]));
			pst.setBoolean(8,Boolean.parseBoolean(fields[7]));
		/*	pst.setTimestamp(9,Timestamp.valueOf(fields[8]));
			pst.setTimestamp(10,Timestamp.valueOf(fields[9]));
			pst.setTimestamp(11,Timestamp.valueOf(fields[10]));*/
			
			try
			{
			System.out.println("######..timestamp"+Timestamp.valueOf(fields[8]).getTime());
			Date dd1=new Date(Timestamp.valueOf(fields[8]).getTime());
			//Date d=new Date(Timestamp.valueOf(fields[8]).);
			System.out.println("!!!--"+dd1);
			//d=new date9
			Date dd2=new Date(Timestamp.valueOf(fields[9]).getTime());
			Date dd3=new Date(Timestamp.valueOf(fields[10]).getTime());
			pst.setDate(9,dd1);
			pst.setDate(10,dd2);
			pst.setDate(11,dd3);
			pst.setString(12,fields[11]);
			
			pst.setInt(13,dd1.getDate());
			int month=dd1.getMonth();
			pst.setString(14,months[month]);
			pst.setInt(15,dd1.getYear()+1900);
			
			pst.setInt(16,dd2.getDate());
			month=dd2.getMonth();
			pst.setString(17,months[month]);
			pst.setInt(18,dd2.getYear()+1900);
			
			pst.setInt(19,dd3.getDate());
			month=dd3.getMonth();
			pst.setString(20,months[month]);
			pst.setInt(21,dd3.getYear()+1900);
			
			
						
			System.out.println("see this...!!\n\n"+pst.executeUpdate()+"...\n\n");
			}
			catch(Exception e)
			{
				System.out.println("exception is thr..");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("err while inserting in database..");
			e.printStackTrace();
		}
	 }
	 public static void display()
	 {
		 
		 try {
			ResultSet rs=pst.executeQuery("select * from metadata");
			System.out.println("result in database..");
			while(rs.next())
			{
				for(int i=0;i<11;i++)
					System.out.println(rs.getObject(i+1)+",");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }
}	
