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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Events {
	
	public void backup() throws IOException
	{
		
		LinkedList<String> lista=new LinkedList<String>();
		BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\heb.txt"));
		String a = read.readLine();
		while(a!=null)
		{
			String[] array = a.split(" ");
			String last = array[1];
			lista.add(last);
			a = read.readLine();	
		}
		String ty="";
		String li="";
		String[] hima = new String[38];
		String[] heba = new String[45];
		for(int i=0; i<lista.size(); i++)
		{
			heba[i] = lista.get(i);
			for(int j=0; j<=37; j++)
			{
				hima[j] = "0";	
				li =String.join(" ",hima);	
			}
			ty = String.join(" ",heba[i],li);
			Path path=Paths.get("C:\\Users\\Hadeel\\Desktop\\backup.txt");
			Files.write(path,  ty.getBytes(), StandardOpenOption.APPEND);
			Files.write(path,  "\n".getBytes(), StandardOpenOption.APPEND);
	 	}	
	}
	public void addevent(String number) throws IOException
	{
		int w=0;
		String last = "";
		String[] arr = new String[7];
		String[] input = number.split(" ");
		String action = input[0];
		String lastname = input[1];
		String gameweek = input[2];
		LinkedList<String> list=new LinkedList<String>();
		LinkedList<String> lines=new LinkedList<String>();
		LinkedList<String> lasts=new LinkedList<String>();
		LinkedList<String> position = new LinkedList<String>();
		BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\heb.txt"));
		String a = read.readLine();
		BufferedReader readss = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\backup.txt"));
		String k = readss.readLine();
		LinkedList<String> list4 = new LinkedList<String>();
		while(a!=null)
		{
			arr = a.split(" ");
			last = arr[1];
			list.add(last);
			position.add(arr[4]);
			lines.add(a);
			a = read.readLine();
			//System.out.println(lines);
		}
		while(k!=null)
		{
			String[] hadeel = k.split(" ");
			last = hadeel[0];
			lasts.add(last);
			list4.add(k);
			//System.out.println(lasts);
			k=readss.readLine();
		}
		//System.out.println("f");
		for(int i=0; i<list.size(); i++)
		{
			if(lastname.equals(list.get(i)))
			{
				if(action.equals("1"))
					w++;
				else if(action.equals("2"))
					w+=2;
				else if(action.equals("3"))
					if(position.get(i).equals("Goalkeeper") || position.get(i).equals("Defender"))
						w+=6;
					else
						System.out.println("Invalid.");
				else if(action.equals("4"))
					if(position.get(i).equals("Midfielder"))
						w+=5;
					else
						System.out.println("Invalid.");
				else if(action.equals("5"))
					if(position.get(i).equals("Forward"))
						w+=4;
					else
						System.out.println("Invalid.");
				else if(action.equals("6"))
					w+=3;
				else if(action.equals("7"))
					if(position.get(i).equals("Goalkeeper") || position.get(i).equals("Defender"))
						w+=4;
					else
						System.out.println("Invalid.");
				else if(action.equals("8"))
					if(position.get(i).equals("Midfielder"))
						w++;
					else
						System.out.println("Invalid.");
				else if(action.equals("9"))
					if(position.get(i).equals("Forward"))
						w++;
					else
						System.out.println("Invalid.");
				else if(action.equals("10"))
					w+=5;
				else if(action.equals("11"))
					w-=2;
				else if(action.equals("12"))
					w+=2;
				else if(action.equals("13"))
					w--;
				else if(action.equals("14"))
					w-=3;
				else if(action.equals("15"))
				    w-=2;
				//file heb
				String[] nas = lines.get(i).split(" ");
				String ha = nas[6];
				int has = Integer.parseInt(ha);
				has+=w;
				String ty = String.valueOf(has);
				//new String
				String araf = String.join(" ",nas[0],nas[1],nas[2],nas[3],nas[4],nas[5],ty);
				//replace in heb file
				  Scanner sc = new Scanner(new File("C:\\Users\\Hadeel\\Desktop\\heb.txt"));
			      StringBuffer buffer = new StringBuffer();
			      while (sc.hasNextLine()) 
			      {
			         buffer.append(sc.nextLine()+System.lineSeparator());
			      }
			      String fileContents = buffer.toString();
			      sc.close();
			      String oldLine = lines.get(i);
			      String newLine = araf;
			      fileContents = fileContents.replaceAll(oldLine, newLine);
			      FileWriter writer = new FileWriter("C:\\Users\\Hadeel\\Desktop\\heb.txt");
			      writer.append(fileContents);
			      writer.flush();
			      
			      
			      //
		           String delimiter1 =" ";
		           String result1 = String.join(delimiter1,list4.get(i));
		        //   System.out.println(list4);
		           int s = Integer.parseInt(gameweek);
		           //System.out.println(line2.get(1));
		           String[] habal = result1.split(" ");
		           String g = habal[s];
		           
		           int f =Integer.parseInt(g);
		           f+=w;
		           String x=String.valueOf(f);
		           list4.set(s,x);
		           //System.out.println(list4);
		           String delimiter = " ";
		           String result = String.join(delimiter,list4.get(i));
		           System.out.println(result);
		           System.out.println("\n");	   
		           Scanner sc1 = new Scanner(new File("C:\\Users\\Hadeel\\Desktop\\backup.txt"));
				   StringBuffer buffer1 = new StringBuffer();
				     while (sc1.hasNextLine()) 
				      {
				         buffer1.append(sc1.nextLine()+System.lineSeparator());
				      }
				      String Contents1 = buffer1.toString();
				      sc1.close();
				      String oldLine1 = result1;
				      String newLine1 = result;
				      Contents1 =Contents1.replaceAll(oldLine1, newLine1);
				      FileWriter writer1 = new FileWriter("C:\\Users\\Hadeel\\Desktop\\backup.txt");
				      writer1.write(Contents1);
				      writer1.flush();
			}
			
		}		
	} 
	public void endgameweek(String lastname) throws IOException
	{
		int g=0;
		int k=0;
		//String total = "";
		//String weeks = "";
		String[] ta2seema = new String[7];
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> list1 = new LinkedList<String>();
		BufferedReader read2 = new BufferedReader(new FileReader("C:\\Users\\Hadeel\\Desktop\\heb.txt"));
		String heb = read2.readLine();
		while(heb!=null)
		{
			ta2seema = heb.split(" ");
			String lasth = ta2seema[1];
			list.add(heb);
			list1.add(lasth);
			heb = read2.readLine();
		}
		//System.out.println("araf");
		for(int i =0; i<list.size(); i++)
		{
			//System.out.println("araf");
			if(lastname.equals(list1.get(i)))
			{
			//	System.out.println("araf");
				String[] araf = list.get(i).split(" ");
				String week = araf[6];
				String total = araf[5];
				k = Integer.parseInt(total);
				g = Integer.parseInt(week);
				k+=g;
				g=0;
				System.out.println(week);
				System.out.println(k);
				String weekb = String.valueOf(g);
				String totalb = String.valueOf(k);
				//replace in heb file
				
				 Scanner sc = new Scanner(new File("C:\\Users\\Hadeel\\Desktop\\heb.txt"));
			      StringBuffer buffer = new StringBuffer();
			      while (sc.hasNextLine()) 
			      {
			         buffer.append(sc.nextLine()+System.lineSeparator());
			      }
			      String fileContents = buffer.toString();
			      sc.close();
			      String oldLine =total +" " + week;
			      String newLine = totalb + " " + weekb;
			      fileContents = fileContents.replaceAll(oldLine, newLine);
			      FileWriter writer = new FileWriter("C:\\Users\\Hadeel\\Desktop\\heb.txt");
			      writer.append(fileContents);
			      System.out.println(fileContents);
			      writer.flush();
		}
	}
	}
}
