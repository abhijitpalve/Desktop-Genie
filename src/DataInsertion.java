import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DataInsertion
{
	static int datasize=21;
	public static void main(String args[])
	{
		/*split("oabc.txt|9|false|true|false|2012-10-25T07:12:32.025133Z|2012-10-25T07:12:39.413556Z|2012-10-25T07:12:32.025133Z",'|');
		System.out.println();*/
	}
	 public static void parseFile(String file) throws IOException
	 {
		 String fields[]=new String[11];
		 String str;
		 
		 File f=new File(file);
		 FileReader fr=new FileReader(f);
		 BufferedReader br=new BufferedReader(fr);
		 while((str=br.readLine())!=null)
		 {
			// System.out.println(str);
			 fields=split(str,'|');
			 db.insertToDatabase(fields);
		 }
	 }
	 public static String[] split(String str,char ch)
	 {
		 String fields[]=new String[datasize];
		 for(int i=0;i<datasize;i++)
		 {
			 fields[i]="";
		 }
		 StringBuilder sb=new StringBuilder(str);
		 for(int i=0,j=0;i<str.length();i++)
		 {
			 if(sb.charAt(i)==ch)
			 {
				// System.out.println(fields[j]);
				 j++;			
				 continue;
			 }
			 fields[j]=fields[j]+sb.charAt(i);
		 }
		 fields=filter(fields);
		 return fields;
	 }
	 public static String[] filter(String[] fields)
	 {
		// for(int i=datasize-3;i<datasize;i++)
		 for(int i=8;i<11;i++)
		 {
			 StringBuilder sb=new StringBuilder(fields[i]);
			 for(int j=0;j<fields[i].length();j++)
			 {
				 System.out.println(""+i+j+sb.charAt(j));
				 if(sb.charAt(j)=='.')
				 {
					 sb.delete(j,fields[i].length());
					 break;
				 }
				 
			 }
			 fields[i]=sb.toString();
			 fields[i]=fields[i].replace('T',' ');
			 fields[i]=fields[i].replace('Z',' ');
						 
		 }
		 return fields;
	 }
}
