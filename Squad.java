package architecture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class Squad{
	int goalkeeper = 0;
	int defender = 0;
	int forward = 0;
	int midfielder = 0;
	float maxvalue = 100;
	float squadvalue = 0;
	int playernumber = 0;
	int linecounter = 0;
	static int numberOfSquads = 0;
	Events object = new Events();
	//File pathway = new File("C:\\Users\\Hadeel\\Desktop\\squad.txt");
	public void addplayer(String x) throws IOException
	{
		String[] zeft = x.split(" ");
		String lastname = zeft[0];
		String value = zeft[1];
		float v = Float.parseFloat(value);
		String position = zeft[2];
		if(position.equals("Goalkeeper") && playernumber<15)
		{
		if(v<=maxvalue-squadvalue )	
		{
			if(goalkeeper<2)
			{
				goalkeeper++;
				playernumber++;
				squadvalue+=v;
				Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
				
				Files.write(path,  x.getBytes(), StandardOpenOption.APPEND);
				Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			}
			else
				System.out.println("Invalid");
		}
		else
			System.out.println("Invalid");
		}
		else if(position.equals("Defender") )
		{
			if(v<=maxvalue-squadvalue)
			{
			if(defender<5)
			{
				defender++;
				playernumber++;
				squadvalue+=v;
				Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
				
				Files.write(path,  x.getBytes(), StandardOpenOption.APPEND);
				Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			}
			else
				System.out.println("Invalid");
			}
			else
				System.out.println("Invalid");
		}
		else if(position.equals("Forward") && playernumber<15)
		{
			if(v<=maxvalue-squadvalue)
			{
			if(forward<3)
			{
				forward++;
				playernumber++;
				squadvalue+=v;
				Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
			
				Files.write(path,  x.getBytes(), StandardOpenOption.APPEND);
				Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			}
			else
				System.out.println("Invalid");
			}
			else
				System.out.println("Invalid");
		}
		else if(position.equals("Midfielder") && playernumber<15)
		{
			if(v<=maxvalue-squadvalue)
			{
			if(midfielder<5)
			{
				midfielder++;
				playernumber++;
				squadvalue+=v;
				//System.out.println(midfielder);
				Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
				
				Files.write(path,  x.getBytes(), StandardOpenOption.APPEND);
				Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			}
			else
				System.out.println("Invalid");
			}
			else
				System.out.println("Invalid");
		}
		
		
	}
	
	public void new_squad() throws IOException
	{	
		numberOfSquads++;
		System.out.println(numberOfSquads);
		String x = "Squad: " +numberOfSquads;
		Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
		
		Files.write(path,  x.getBytes(), StandardOpenOption.APPEND);
		Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
	}
	public void score(String d) throws IOException
	{
		int id = Integer.parseInt(d);
		BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\squad.txt"));
		String awel = read.readLine();
		BufferedReader read2 = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\backup.txt"));
		String tany = read2.readLine();
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<String> line = new LinkedList<String>();
		while(awel!=null)
		{
			String[] array1 = awel.split(" ");
			String lastname = array1[0]; 
			list1.add(lastname);
			awel = read.readLine();
		}
		while(tany!=null)
		{
			String[] array2 = tany.split(" ");
			String last = array2[0];
			list2.add(last);
			line.add(tany);
			tany = read.readLine();
		}
		int totalscore=0;
		for(int i =0; i<line.size(); i++)
		{
			if(list1.get(i).equals(list2.get(i)))
			{
				String[] asem = line.get(i).split(" ");
				String point = asem[id];
				int points = Integer.parseInt(point);
				totalscore+=points;
			}
		}
		System.out.println(totalscore);
	}
	
}
