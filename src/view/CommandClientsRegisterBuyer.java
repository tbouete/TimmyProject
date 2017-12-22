package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;
import agency.Wish;
import person.Person;

public class CommandClientsRegisterBuyer implements Command{

	private RealEstateAgency REA;
	private final String CANCEL_INPUT = new String("cancel");
	
	public CommandClientsRegisterBuyer(RealEstateAgency REA) { this.REA = REA; }
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println();
		System.out.println("---1.1 Registering new buyer---");
		System.out.println("Enter '"+ this.CANCEL_INPUT +"' to return to the previous menu.");
		
		System.out.println("(1/5)Name of the client : ");
		String name = "PERSON_NAME_PLACEHOLDER";
		try{
			name = sc.nextLine();
			if(name.equals(this.CANCEL_INPUT)) return;
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		System.out.println("(2/5)Address of the client : ");
		String address = "PERSON_ADDRESS_PLACEHOLDER";
		try{
			address = sc.nextLine();
			if(address.equals(this.CANCEL_INPUT)) return;
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		System.out.println("(3/5)Email of the client : ");
		String email = "PERSON_EMAIL_PLACEHOLDER";
		try{
			email = sc.nextLine();
			if(email.equals(this.CANCEL_INPUT)) return;
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		System.out.println("(4/5)Phone number of the client : ");
		String phoneNumber = "PERSON_PHONENUMBER_PLACEHOLDER";
		try{
			phoneNumber = sc.nextLine();
			if(phoneNumber.equals(this.CANCEL_INPUT)) return;
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		System.out.println("(5/5)Address of the notary associated to this client : ");
		String addressNotary = "PERSON_PHONENUMBER_PLACEHOLDER";
		try{
			addressNotary = sc.nextLine();
			if(addressNotary.equals(this.CANCEL_INPUT)) return;
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		Person buyer = new Person(address, email, name, phoneNumber, addressNotary);
		
		Wish[] wishes = {};
		this.REA.registerBuyer(buyer, wishes);
		System.out.println("Client " + name + " succesfully added !");
	}

}
