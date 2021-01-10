package architecture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.Scanner;
public class Register_login {
	String[] email;
	String[] Password;
	File User_Data=new File("C:\\Users\\Hadeel\\Desktop\\hima.txt");
	public void Register(String X) throws IOException
	{
		String[] arr=X.split(" ");
		String E_mail=arr[0];
		String Password=arr[1];
		String LN=arr[2];
		String UserName=arr[3];
		String FN=arr[4];
		String Country=arr[5];
		String DOB=arr[6];
		String Gender=arr[7];
		String Mobile=arr[8];
		Path z=Paths.get("C:\\Users\\Hadeel\\Desktop\\heba.txt");
		Path p=Paths.get("C:\\Users\\Hadeel\\Desktop\\mazen.txt");
		Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\hima.txt");
		Files.write(path,  X.getBytes(), StandardOpenOption.APPEND);
		Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(p,  arr[0].getBytes(), StandardOpenOption.APPEND);
		Files.write(p,   "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(z,  arr[1].getBytes(), StandardOpenOption.APPEND);
		Files.write(z,   "\n".getBytes(), StandardOpenOption.APPEND);
		
		
	}
	public void Login(String Y)
	{
		String[] arr2=Y.split(" ");
		String Email=arr2[0];
		String Password=arr2[1];
		BufferedReader reader;
		BufferedReader reader2;
		LinkedList<String> list=new LinkedList<String>();
		LinkedList<String> list2=new LinkedList<String>();
		try {
			
			reader = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\mazen.txt"));
			reader2 = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\heba.txt"));
			String line = reader.readLine();
			String line2 = reader2.readLine();
			
			while(line != null)
				{
				list.add(line);
				line = reader.readLine();
				}
			while(line2 != null)
				{
				list2.add(line2);
				line2 = reader2.readLine();
				}
			//System.out.println(list.get(0));
			for(int i=0;i<list.size(); i++)
			{

			if(Email.equals(list.get(i)) && Password.equals(list2.get(i)))
				System.out.println("successful login");
			//else
				//System.out.println("unsuccessful login");
			}			
		
				
			
			reader.close();
			reader2.close();
			
		}
					catch(IOException e)
					{
						e.printStackTrace();
					}
		}
	}
