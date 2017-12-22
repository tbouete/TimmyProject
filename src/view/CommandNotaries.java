package view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;
import person.Person;

public class CommandNotaries  implements Command, CommandMenu
{
	private RealEstateAgency REA;
	private boolean quit;
	
	public CommandNotaries(RealEstateAgency REA) { this.REA = REA;  this.quit = false; }
	
	@Override
	public void execute() 
	{
		System.out.println();
		System.out.println("Registered Notaries : " + REA.getListClients().size() + "\n");
		
		int notaryCounter = 1;
			
		for(Person p : REA.getListClients())
		{
			System.out.println(notaryCounter + p.getAssociatedNotary().toString());
			notaryCounter++;
		}
		
		while(!this.quit){
			this.displayAvailableOperations();
			this.selectOperation();
		}
	}
		
		@Override
		public void selectOperation()
		{
			Scanner sc = new Scanner(System.in); 
			int usersChoice = -1;

			try
			{
				if(sc.hasNextInt()) usersChoice = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("You must enter an integer !" + "\n");
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
			catch(IllegalStateException e)
			{
				e.printStackTrace();
			}

			Command c;
			
			
			switch (usersChoice) 
			{
			case 0:
				this.quit = true;
				break;
			case 1:
				c = new CommandClientsRegisterBuyer(this.REA);
				c.execute();
			
			default:
					System.out.println("You can only select on of the available operations ! " + "\n");
					break;
			}
		}
		
		
		
		@Override
		public void displayAvailableOperations() 
		
		{
			System.out.println();
			System.out.println("---2 : Notaries ---");
			System.out.println("Available operations :");

			System.out.println("0 - Back");
			System.out.println();

			System.out.print("Please select your operation : ");
		}
		
	}


