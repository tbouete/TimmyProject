package view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;

public class BaseView {

	private RealEstateAgency REA;
	private boolean quit;

	public BaseView(){ this.REA = new RealEstateAgency(); this.quit = false; }

	public void launchView(){
		System.out.println("Welcome to the Timmo agency !");

		while(!this.quit){

			this.displayAvailableOperations();
			this.selectOperation();
		}
	}

	public void displayAvailableOperations(){
		System.out.println();
		System.out.println("---Main menu---");
		System.out.println("Available operations :");

		System.out.println("0 - Quit");
		System.out.println("1 - View clients");
		System.out.println("2 - View notaries");
		System.out.println("3 - View visits");
		System.out.println("4 - View publicity");
		System.out.println("5 - View properties on sale matching clients wishes");
		System.out.println();

		System.out.print("Please select your operation : ");
	}

	public void selectOperation(){
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
			System.out.println("Bye !");
			this.quit = true;
			sc.close();
			break;
		case 1:
			c = new CommandClients(this.REA);
			c.execute();
			break;

		case 2:
			System.out.println("To be implemented...");
			//TODO
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

	public RealEstateAgency getREA(){ return this.REA; }
}
