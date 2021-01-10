package architecture;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class User 
{
	public static void main(String[] args) throws IOException {
		Events shoot = new Events();
		shoot.backup();
		boolean y=true;
		while(y==true) 
		{
			System.out.println("Choose your action: ");
			System.out.println("1: Register. ");
			System.out.println("2: Login. ");
			System.out.println("3: Add Player. ");
			System.out.println("4: Add Event ");
			System.out.println("5: New Squad. ");
			System.out.println("6: End Week. ");
			System.out.println("7: Create Player.");
			System.out.println("8: Retrieve data.");
			System.out.println("9: Exit. ");
			Scanner hima = new Scanner (System.in);	
			Scanner hima1 = new Scanner (System.in);
			String X = hima.nextLine();
			Register_login heba = new Register_login();
			Squad mazen = new Squad();
			Player bala7 = new Player();
			
			if(X.equals("1")) 
			{
				System.out.println("enter");
				String Y = hima1.nextLine();
				heba.Register(Y);
			}
			else if(X.equals("2")) 
			{
				System.out.println("enter");
				String Y = hima1.nextLine();
				heba.Login(Y);
			}
			else if(X.equals("3")) 
			{
				for(int p =0; p<20; p++)
				{
					
				System.out.println("enter");
				String Y = hima1.nextLine();
				mazen.addplayer(Y);
						
				}
			}
			else if(X.equals("4")) 
			{
				System.out.println("Enter the last name of the player and the number of the event.");
				System.out.println("1: playing up to 60 minutes.");
				System.out.println("2: playing 60 minutes or more.");
				System.out.println("3: goal scored by a defender or a goalkeeper.");
				System.out.println("4: goal scored by a midfielder.");
				System.out.println("5: goal scored by a forward.");
				System.out.println("6: goal assist.");
				System.out.println("7: clean sheet by a defender or a goalkeeper.");
				System.out.println("8: clean sheet by a midfielder.");
				System.out.println("9: 3 shot saves by a goalkeeper.");
				System.out.println("10: penalty save.");
				System.out.println("11: penalty miss.");
				System.out.println("12: bonus points for best players in the match.");
				System.out.println("13: each yellow card.");
				System.out.println("14: each red card.");
				System.out.println("15: each own goal.");
				System.out.println("enter");
				String Y = hima1.nextLine();
				
				shoot.addevent(Y);
			}
			
			else if(X.equals("5")) 
			{
				mazen.new_squad();
			}
			else if(X.equals("6")) 
			{
				System.out.println("Enter lastname of the player.");
				String Y = hima1.nextLine();
				shoot.endgameweek(Y);
			}
			else if(X.equals("7")) 
			{
				
				System.out.println("enter");
				String Y = hima1.nextLine();
				bala7.Create(Y);
			}
			else if(X.equals("8")) 
			{
				System.out.println("Please enter the last name of the player you want to retrieve the data of: ");
				String Y = hima1.nextLine();
				bala7.Retrieve(Y);
			}
			else if(X.equals("9")) 
			{
				//heba.exit();
				y=false;
			}
			else 
			{
				System.out.println("invalid input");
			}
		}
	}
}