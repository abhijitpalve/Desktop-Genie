import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.*;
import java.sql.Date;

public class Find
	{
//	static public FileDescriptor[] a1=new FileDescriptor[20];
    // public static int i=0;
	static String outFile="D:/Bank1.txt";
	static String scanDirectory;
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		boolean c=false;
		try
		{
			System.out.println("in try");
			System.out.println(outFile);
			File f1 = new File(outFile);
	//		f1.createNewFile();
			FileWriter fw=new FileWriter(f1,false);
			
			fw.close();
			System.out.println(f1);
			c=f1.delete();
				
		}
		catch(Exception E)
		{
			System.out.println("incatvh");
			System.out.println(E);
		}
		System.out.println("\n\n\n\n$%%$%%\n\n\n00000000000file is deleted.."+c);
		
		//System.exit(0);
//		
		//File f1 = new File("E:/bank1.dat");
		Path startingDir = Paths.get(scanDirectory);
	    		
	 //   Find xyz=new Find();
		Files.walkFileTree(startingDir, new FindJavaVisitor());
		db.main(outFile);
	}
	}

	class FindJavaVisitor
		extends SimpleFileVisitor<Path> 
		{
		
		static String str;
	  //   static FileDescriptor[] a1=new FileDescriptor[20];
		static int j;	   
			public FindJavaVisitor() {};
			
			public FileVisitResult
			visitFile(Path file, BasicFileAttributes attrs) throws IOException 
			{
			/*if ((file != null) && (attrs != null))
			{
				if (file.getName().toString().endsWith(".java"))
				{
					System.out.println(file.getName().toString());
				}
			}*/
				
				    System.out.printf("\n\n");
				// BasicFileAttributes basicFileAttributes = Files.readAttributes(start, BasicFileAttributes.class);
                    System.out.println(file.getFileName());
				  /*  System.out.println("Is directory? : " + attrs.isDirectory());
				    System.out.println("Size:" + attrs.size() + " bytes");
				    System.out.println("Is regular file?" + attrs.isRegularFile());
				    System.out.println("Created at:" + attrs.creationTime());
				    System.out.println("Last accessed at:" + attrs.lastAccessTime());
				    System.out.println("Last modified at:" +attrs.lastModifiedTime());
				    System.out.println("isSymbolicLink: " + attrs.isSymbolicLink());
		 */
				//    FileDescriptor a1=new FileDescriptor();
				//   FindJavaVisitor.a1[FindJavaVisitor.j].fileName=file.getFileName();
				  /*  a1[i].creation=attrs.creationTime();
				    a1[i].lastAccess=attrs.lastAccessTime();
				    a1[i].lastModified=attrs.lastModifiedTime();
				    a1[i].size= attrs.size();
				    a1[i].IsDirectory=attrs.isDirectory();
				    a1[i].IsRegular=attrs.isRegularFile();
				    a1[i].IsSymbolicLink=attrs.isSymbolicLink();
				    */
				  //  FindJavaVisitor.j++;
				    
				   // System.out.println("j::::"+j);
				    
				  /* try
				   {
				    FileOutputStream fos = new FileOutputStream("E:/data.txt");
		            ObjectOutputStream oos = new ObjectOutputStream(fos);
		      
				    oos.writeObject(a1);
				    
				    
				     oos.flush();
			         oos.close();
				   }
				   catch (IOException e) {
			            e.printStackTrace();
			        } */
				    
				    
				 /*   FileWriter out = new FileWriter("E:/data", true);
				    out.w
				    out.close();*/
				    
				    
				    
				    
				    
					FileOutputStream fos = new FileOutputStream (Find.outFile, true);
					DataOutputStream dos = new DataOutputStream (fos);
	
				//	dos.writeUTF("FILE-NAME		SIZE	  ISREGULAR		ISDIRECTORY		ISSYMBOLIC		CREATIONTIME	LASTMODIFIED		LASTACCESS\n");
					/*
				    dos.writeUTF(file.getFileName().toString()+"|");
				    
				    dos.writeUTF(String.valueOf(attrs.size())+"|");
				    dos.writeUTF(new Boolean(attrs.isRegularFile()).toString()+"|");
				    dos.writeUTF(new Boolean(attrs.isDirectory()).toString()+"|");
				    dos.writeUTF(new Boolean(attrs.isSymbolicLink()).toString()+"|");
				    dos.writeUTF(attrs.creationTime().toString()+"|");
				    dos.writeUTF(attrs.lastModifiedTime().toString()+"|");
				    dos.writeUTF(attrs.lastAccessTime().toString()); */
				   
					   				
				    str=file.getFileName().toString()+"|";
				    str=str+file.toAbsolutePath()+"|";
				    
				    String folder;
				   
				    int arg0,arg1;
				    arg0=file.toAbsolutePath().toString().lastIndexOf('\\');
				   // arg1=file.toAbsolutePath().toString().indexOf(null);
				 
				   // int indexarray[]=new int[10];
				     char arr[]=new char[file.toAbsolutePath().toString().length()];
				     arr=file.toAbsolutePath().toString().toCharArray();
				    int k,m = 0;
				    
				    for(k=0;k<file.toAbsolutePath().toString().lastIndexOf('\\');k++)
				    {
				    	if(arr[k]=='\\')
				    			m=k;
				    }
				    
				    
				    folder=file.toAbsolutePath().toString().substring(m+1,arg0);
				    
				    
				    
				    System.out.println("----------------------------:::::"+folder);
				    
				    String extension;
				    extension=file.getFileName().toString();
				    
				   
				    int len=extension.length();
				   // int position=extension.indexOf('.');
				    int position=extension.lastIndexOf('.',len);
			        position++;
				    extension=extension.substring(position);
				    
				   // System.out.println("\nthis is #######--"+extension1);
				  
				    
				    String type=null;
				    int check=155,flag=0;
				    check=extension.compareTo("mov"); //movies............
				    System.out.println("****"+check);
				    if(check==0)
				    {
				    	type="Movies";	
				    	flag=1;
				    }	
				    check=extension.compareToIgnoreCase("3gp");		    
				     if(check==0)
				    {
				    	type="Movies";
				    	flag=1;
				    }
				     check=extension.compareToIgnoreCase("mpg");
				     if(check==0)
				    {
				    	type="Movies";
				    	flag=1;
				    }
				     check=extension.compareToIgnoreCase("mpg");
				     if(check==0)
				    {
				    	type="Movies";
                        flag=1;				    
				    }
				     check=extension.compareToIgnoreCase("avi");
				     if(check==0)
				    {
				    	type="Movies";
				    	flag=1;
				    }
				     check=extension.compareToIgnoreCase("wmv");
				     if(check==0)
				    {
				    	type="Movies";
				    	flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("mp3");   // audio..........
				     if(check==0)
				    {
				    type="Audio";
				    flag=1;
				 
				    }
				     check=extension.compareToIgnoreCase("wav");
				     if(check==0)
				    {
				    type="Audio";
				    flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("wma");
				     if(check==0)
				    {
				    type="Audio";
				    flag=1;
				  
				    }
				     check=extension.compareToIgnoreCase("txt");  //text.....
				     if(check==0)
				    {
				    type="Text";
				    flag=1;
				   
				    }
				     check=extension.compareToIgnoreCase("doc");
				     if(check==0)
				    {
				    type="Text";
				    flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("docx");
				     if(check==0)
				    {
				    type="Text";
				    flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("ppt");   //presentation files..
				     if(check==0)
				    {
				    type="Ppts";
				    flag=1;
				    }
				     check=extension.compareToIgnoreCase("pptx");
				     if(check==0)
				    {
				    type="Ppts";
				    flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("html");   //html files
				     if(check==0)
				    {
				    type="Web Pages";
				    flag=1;
				    }
				     check=extension.compareToIgnoreCase("exe");  //executables...
				     if(check==0)
				    {
				    type="Executables";
				    flag=1;
				  
				    }
				     check=extension.compareToIgnoreCase("zip");  //zip files
				     if(check==0)
				    {
				    type="Zip Files";
				    flag=1;
				  
				    }
				     check=extension.compareToIgnoreCase("lnk");  //symbolic link..
				     if(check==0)
				    {
				    type="Links";
				    flag=1;
				    
				    }
				     check=extension.compareToIgnoreCase("JPG");   //images..
				     if(check==0)
				    {
				    type="Images";
				    flag=1;
				    }
					    check=extension.compareToIgnoreCase("jpeg");

				     if(check==0)
				    {
				    type="Images";
				    flag=1;
				   
				    }
				     check=extension.compareToIgnoreCase("png");
				     if(check==0)
				    {
				    type="Images";
				    flag=1;
				   
				    }
				     check=extension.compareToIgnoreCase("pdf");  //pdfs..(text)
				     if(check==0)
				    {
				    type="Text";
				    flag=1;
				    }
				     
				     if(flag==0)
				    	 type="Others";
				     
				
					System.out.println("---type:--"+type);
				    
					str=str+extension+"|";
					str=str+type+"|";
				    str=str+(String.valueOf(attrs.size()))+"|";
				    str=str+(new Boolean(attrs.isDirectory())).toString()+"|";
				    str=str+(new Boolean(attrs.isRegularFile()).toString()+"|");
				    str=str+(new Boolean(attrs.isSymbolicLink()).toString()+"|");
				    str=str+(attrs.creationTime().toString()+"|");
				    str=str+(attrs.lastModifiedTime().toString()+"|");
				    str=str+(attrs.lastAccessTime().toString())+"|";
				    str=str+folder+"\n";
				    
		/*	System.out.println("*****"+file.toAbsolutePath());
			System.out.println(file.toString()+" "+file.toRealPath()+"*****");
			*/
				    dos.writeUTF(str);
				    
				    
				    //dos.writeUTF("\n");
				    
				    dos.close();
					fos.close();
				    
				    
		return FileVisitResult.CONTINUE;
	       }
		}


/*	
class FileDescriptor implements Serializable
{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	public Path fileName;
	public Boolean IsDirectory,IsRegular,IsSymbolicLink;
	public long size;
	FileTime creation, lastAccess,lastModified;
	
	static int i;
	
	public FileDescriptor()
	{
		
	}
}*/