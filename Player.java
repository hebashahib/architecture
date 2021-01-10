package architecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class Player 
{

	public void Create(String p) throws IOException
	{
		Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\Players.txt");
		Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
		Files.write(path,  p.getBytes(), StandardOpenOption.APPEND);
	}
	public void Retrieve(String t) throws IOException 
	{
		
		BufferedReader read = new BufferedReader(new FileReader ("C:\\Users\\Hadeel\\Desktop\\Players.txt"));
		String q = read.readLine();
		LinkedList<String> list=new LinkedList<String>();
		LinkedList<String> lista=new LinkedList<String>();
		lista.add(q);
		while(q!=null)
			{
			
				String[] qw = q.split(" ");
				String lastname = qw[1];
				list.add(lastname);
				q = read.readLine();
			}
		
		for(int i = 0; i<list.size(); i++)
			{
				if(t.equals(list.get(i)))
				{
					System.out.println(lista.get(i));
				}
			}
		read.close();
	}

}