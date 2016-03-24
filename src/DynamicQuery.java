import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;


public class DynamicQuery {

	/**
	 * @param args
	 * @throws IOException 
	 * 
	 */
     static int count=0;
	
     static String src="C:/apache-tomcat-6.0.36/apache-tomcat-6.0.36/webapps/mondrian/WEB-INF/queries/DynamicQuery.jsp";
     static String dest="C:/apache-tomcat-6.0.36/apache-tomcat-6.0.36/webapps/mondrian/WEB-INF/queries/Temporary.jsp";
     
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String Measure=null,Axis11=null,Axis1_Value=null,Axis22=null,Axis2_Value=null;
		Measure=Myframe.Measure;
		Axis11=Myframe.Axis11;
		Axis1_Value=Myframe.Axis1_Value;
		Axis22=Myframe.Axis22;
		Axis2_Value=Myframe.Axis2_Value;
		
		
		   
		System.out.println("In Dyanmic query..Mesures:"+Measure+" Axis1:"+Axis11+" Axis2:"+Axis22);
		System.out.println("----"+Axis1_Value+"--"+Axis2_Value);
		
		try
		{
		int see=Axis11.compareTo("Creation Time");
		if(see==0)
			Axis11="CreationTime";
		see=1;
		
		see=Axis11.compareTo("Modified Time");
		if(see==0)
			Axis11="LastModifiedTime";
		see=1;
		
		see=Axis11.compareTo("Last Access Time");
		if(see==0)
			Axis11="LastAccessTime";
		see=1;
		
		see=Axis22.compareTo("Creation Time");
		if(see==0)
			Axis22="CreationTime";
		see=1;
		
		see=Axis22.compareTo("Modified Time");
		if(see==0)
			Axis22="LastModifiedTime";
		see=1;
		
		see=Axis22.compareTo("Last Access Time");
		if(see==0)
			Axis22="LastAccessTime";
		}
		catch(NullPointerException e)
		{
			
		}
		
		Date currentdate=new Date();
	    int day=currentdate.getDate();
	
	    String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	    String month=months[currentdate.getMonth()];
	    String PrevMonth=months[currentdate.getMonth()-1];
	    int year=currentdate.getYear()+1900;
	    int PrevYear=year-1;
	    
	    System.out.println("date:"+day+" "+month+year);
		
		
		String query=null;
		//boolean check=false;
		//int check=5;
		//String A=null;
		try
		{
		if(Measure.equals(null))
			return;
		else
		{
			int cmp=5;
			cmp=Measure.compareTo("size");
			if(cmp==0)
			query="SELECT [Measures].size ON COLUMNS,";
			else
			query="SELECT [Measures].CountOfFiles ON COLUMNS,";				
		}
		}
		catch(Exception e)
		{
			
		}
		
		query=query+"\r\n";
		try
		{
		if(Axis11.equals(null))
			return;
		else
		{
			if(Axis11.equals("Folder"))
			{
				 query=query+"["+Axis11+"]"+" ON ROWS"; 
			}
			else
			{
			  query=query+"["+Axis11+"]"; 
			  //System.out.println("\n axis..");
			}
		}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			
			
		
		if(Axis1_Value.equals(null))
		{
			query=query+" ON ROWS";
		}
		else
		{
			//query=query+".["+Axis1_Value+"] ON ROWS";
			if(Axis1_Value.equals("None"))
			{
				query=query+" ON ROWS";
				 // System.out.println("\n none ..value..");
			}
			else
			{
			  if(Axis1_Value.equals("This Year"))
			  {
				  query=query+".["+Integer.toString(year)+"] ON ROWS";
				 // System.out.println("\n value.."+Integer.toString(year));
			  }
			  else
			  {
				  if(Axis1_Value.equals("Last Year"))
				  {
					  query=query+".["+Integer.toString(PrevYear)+"] ON ROWS";
				  }
				  else
				  {
					  if(Axis1_Value.equals("Last Month"))
					  {
						  if(month.equals("Jan"))
						  {
							  query=query+".["+Integer.toString(PrevYear)+"]"+".[Dec] ON ROWS";
						  }
						  else
						  {
							  query=query+".["+Integer.toString(year)+"]"+".["+PrevMonth+"] ON ROWS";
						  }
					  }
					  else
					  {
						  if(Axis1_Value.equals("This Month"))
						  {
							  query=query+".["+Integer.toString(year)+"]"+".["+month+"] ON ROWS";
						  }
					  }
				  }
			  }
			  
			
			  
		    }
			
				if(Axis1_Value.equals("Big"))
				{
			
					  
				}
				else
				{
					if(Axis1_Value.equals("Small"))
					{
						
					}
					else
					{
						if(Axis1_Value.equals("Medium"))
						{
							
						}
						else
						{
							// types of data
						     if(Axis11.equals("Type"))
						     {
						    	   if(!Axis1_Value.equals("None"))
						    	   {
						    		   
						    		   query=query+".["+Axis1_Value+"] ON ROWS";
						    	   }
						     }
						}
					}
				}
				
			
		}
		
		}
		catch(Exception e)
		{
			
		}
		
	
		
		
		query=query+"\r\nFROM [Mycube]";
		query=query+"\r\n";
				try
				{
		if(!Axis22.equals(null))
		{								
			
			query=query+"WHERE ["+Axis22+"]";             
		}
				}
				catch(Exception e)
				{
					
				}
				
		
		
		
		
		//Axis 2 value..
		
				try
				{
					
			if(!Axis2_Value.equals("None"))
			{
				if(Axis2_Value.equals("This Year"))
				{
					query=query+".["+Integer.toString(year)+"]";
				}
				else
				{
					if(Axis2_Value.equals("Last Year"))
					{
						query=query+".["+Integer.toString(PrevYear)+"]";
					}
					else
					{
						if(Axis2_Value.equals("This Month"))
						{
							query=query+".["+Integer.toString(year)+"]"+".["+month+"]";
						}
						else
						{
							if(Axis2_Value.equals("Last Month"))
							{

								  if(month.equals("Jan"))
								  {
									  query=query+".["+Integer.toString(PrevYear)+"]"+".[Dec]";
								  }
								  else
								  {
									  query=query+".["+Integer.toString(year)+"]"+".["+PrevMonth+"]";
								  }
							}
							else
							{
								if(Axis2_Value.equals("Big"))
								{
									
								}
								else
									if(Axis2_Value.equals("Small"))
									{
										
									}
									else
									{
										if(Axis2_Value.equals("Medium"))
										{
											
										}
										else
										{
											if(Axis22.equals("Type"))
											{
												query=query+".["+Axis2_Value+"]";
											}
										}
									}
							}
						}
					}
				}
			}
			
			 }
			catch(Exception e)
			{
				
			}
			
			
			
			

			
			
			
			
			
			System.out.println("query is ..\r\n"+query);
		
			
		
			PrintWriter writer = null;
			try {
				writer = new PrintWriter("C:/apache-tomcat-6.0.36/apache-tomcat-6.0.36/webapps/mondrian/WEB-INF/queries/DynamicQuery.jsp");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer.print("".toCharArray());
			writer.flush();
			System.out.println("file is deleted..");
			writer.close();
			
			
			File f1=new File("C:/apache-tomcat-6.0.36/apache-tomcat-6.0.36/webapps/mondrian/WEB-INF/queries/DynamicQuery.jsp");
			FileWriter fw=new FileWriter(f1,false);
			
		    
			
			String header="<%@ page session=\"true\" contentType=\"text/html; charset=ISO-8859-1\" %>";
					header=header+"\r\n"+" <%@ taglib uri=\"http://www.tonbeller.com/jpivot\" prefix=\"jp\" %>";
					header=header+"\r\n"+"<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jstl/core\" %>";					
                    header=header+"\r\n"+"<jp:mondrianQuery id=\"query01\" jdbcDriver=\"com.mysql.jdbc.Driver\" jdbcUrl=\"jdbc:mysql://localhost/Mydata\" catalogUri=\"/WEB-INF/queries/MySchema.xml\"";
                    header=header+"jdbcUser=\"root\" jdbcPassword=\"tushar\" connectionPooling=\"false\">";
                    header=header+"\r\n\r\n";
                    
            String footer="\r\n\r\n"+"</jp:mondrianQuery>";

             footer=footer+"\r\n"+"<c:set var=\"title01\" scope=\"session\">Dynamic Queries</c:set>";			
			
			 try {
				 BufferedWriter out = new BufferedWriter(new FileWriter("C:/apache-tomcat-6.0.36/apache-tomcat-6.0.36/webapps/mondrian/WEB-INF/queries/DynamicQuery.jsp",false));
				 if(count!=0)
				 {
					 for(int i=0;i<20;i++)
					 {
					out.write("");
					 }
				 }
				 count++;
				 out.write(header);
				 out.write(query);
				 out.write(footer);
				 System.out.println("file is deleted..**");
				 out.close();
				 }
				 catch (IOException e)
				 {
				 System.out.println("Exception ");
				 }
	
			      Copy(src,dest);
	}




public static  void Copy(String srFile,String dtFile)
{
	 File f1 = new File(srFile);

	  File f2 = new File(dtFile);

	  InputStream in = null;
	try {
		in = new FileInputStream(f1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 

	//For Overwrite the file.
	  OutputStream out = null;
	try {
		out = new FileOutputStream(f2);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	    byte[] buf = new byte[1024];
	  
	  int len;
	 
	 try {
		while ((len = in.read(buf)) > 0){
		  
		  out.write(buf, 0, len);
		 
		 }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		in.close();
		out.close();
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 
	 System.out.println("File copied.");
}


}