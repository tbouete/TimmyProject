package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;
import agency.Visit;
import person.Person;

public class CommandClientsSignSalesMandate implements Command{
	private RealEstateAgency REA;
	private final String CANCEL_INPUT = new String("cancel");
	private final long DELAY_UNTIL_VISIT = 7 *8640000;
	
	public CommandClientsSignSalesMandate(RealEstateAgency REA) { this.REA = REA; }
	
	@Override
	public void execute() {
		
		System.out.println();
		System.out.println("---1.3 Signing a sales mandate---");
		System.out.println("Enter '"+ this.CANCEL_INPUT +"' to return to the previous menu.");
		
		
		Scanner sc = new Scanner(System.in); 
		int idBuyer = -1;
		Visit vis = new Visit(null,  new Date(), "VISIT_DESC_PLACEHOLDER");

		while(idBuyer < 0 && idBuyer > this.REA.getListClients().size()){
			System.out.println("Please enter the number of the client signing this mandate : ");
			try{
				if(sc.hasNextInt()) idBuyer = sc.nextInt() - 1;
				for(Visit v : this.REA.getListVisits()){
					if(v.getClient().equals(this.REA.getListClients().get(idBuyer)) && v.getDescription().contains("signing a sale mandate")){
						vis = v;
					}
				}
			}catch(InputMismatchException e){
				System.out.println("You must enter an integer !" + "\n");
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}	
		}
		
		System.out.println("Date of the signature :");
		Date availabilityDate = Command.parseDate();
		
		
		//this.REA.signSalesMandate(vis, prop, availabilityDate, desiredSaleDate, desiredPrice);
		
	}

}
