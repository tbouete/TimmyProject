package view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;
import person.Person;

public class CommandClients implements Command, CommandMenu{

	private RealEstateAgency REA;
	private boolean quit;
	
	public CommandClients(RealEstateAgency REA) { this.REA = REA;  this.quit = false; }
	
	@Override
	public void execute() {
		System.out.println();
		System.out.println("Registered clients : " + REA.getListClients().size() + "\n");
		
		int clientCounter = 1;
		for(Person p : REA.getListClients()){
			System.out.println(clientCounter + p.toString());
			clientCounter++;
		}
		
		while(!this.quit){
			this.displayAvailableOperations();
			this.selectOperation();
		}
		
	}

	@Override
	public void selectOperation() {
		Scanner sc = new Scanner(System.in); 
		int usersChoice = -1;

		try{
			if(sc.hasNextInt()) usersChoice = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("You must enter an integer !" + "\n");
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(IllegalStateException e){
			e.printStackTrace();
		}

		Command c;

		switch (usersChoice) {
		case 0:
			this.quit = true;
			break;
		case 1:
			c = new CommandClientsRegisterBuyer(this.REA);
			c.execute();
			break;

		case 2:
			c = new CommandClientsRegisterSeller(this.REA);
			c.execute();
			break;

		case 3:
			System.out.println("To be implemented...");
			//TODO
			break;

		case 4:
			System.out.println("To be implemented...");
			//TODO
			break;
			
		case 5:
			System.out.println("To be implemented...");
			//TODO
			break;

		default:
			System.out.println("You can only select on of the available operations ! " + "\n");
			break;
		}
		
	}

	@Override
	public void displayAvailableOperations() {
		System.out.println();
		System.out.println("---1 : Clients ---");
		System.out.println("Available operations :");

		System.out.println("0 - Back");
		System.out.println("1 - Register new buyer");
		System.out.println("2 - Register new seller");
		System.out.println("3 - Sign a sale mandate");
		System.out.println("4 - Sign a sale agreement");
		System.out.println("5 - Add a buying wish to a client");
		System.out.println();

		System.out.print("Please select your operation : ");
	}

}
