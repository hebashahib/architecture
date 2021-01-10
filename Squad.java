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
	//File pathway = new File("C:\\Users\\Hadeel\\Desktop\\squad.txt");
	public void addplayer(String x) throws IOException
	{
		String[] zeft = x.split(" ");
		String lastname = zeft[1];
		String value = zeft[2];
		float v = Float.parseFloat(value);
		String position = zeft[3];
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
				System.out.println("kteer");
		}
		else
			System.out.println("kteer");
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
				System.out.println("kteer");
			}
			else
				System.out.println("kteer");
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
				System.out.println("kteer");
			}
			else
				System.out.println("kteer");
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
				System.out.println("kteer");
			}
			else
				System.out.println("kteer");
		}
		
		
	}
	public void new_squad() throws IOException
	{
		BufferedReader read = new BufferedReader(new FileReader ("C:\\Users\\Hadeel\\Desktop\\squad.txt"));
		String q = read.readLine();
		while(q!=null)
		{
			linecounter++;
			q = read.readLine();
		}
		System.out.println(linecounter);
		//linecounter+=19;
		if(linecounter==15 || linecounter==34 || linecounter==53)
		{
			Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\squad.txt");
			Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
			Files.write(path,  "Next squad".getBytes(), StandardOpenOption.APPEND);
			Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
		}
	}
	
}