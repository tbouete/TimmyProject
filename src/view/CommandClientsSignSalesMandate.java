package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import agency.RealEstateAgency;
import agency.Visit;
import person.Person;
import property.Orientation;
import property.Property;

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
		
		Property prop = this.parseProperty(sc);

		while(idBuyer < 0 && idBuyer > this.REA.getListClients().size()){
			System.out.println("(2/5)Please enter the number of the client signing this mandate : ");
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
		
		System.out.println("(3/5)Date at wich the property will be available : ");
		Date availabilityDate = Command.parseDate();
		
		System.out.println("(4/5)Date at wich the property should be sold : ");
		Date desiredSaleDate = Command.parseDate();
		
		float desiredPrice = (float) -1.0;
		
		while(desiredPrice < 0.0){
			System.out.println("(5/5)Please enter the number of the client signing this mandate : ");
			try{
				desiredPrice = sc.nextFloat();
				for(Visit v : this.REA.getListVisits()){
					if(v.getClient().equals(this.REA.getListClients().get(idBuyer)) && v.getDescription().contains("signing a sale mandate")){
						vis = v;
					}
				}
			}catch(InputMismatchException e){
				System.out.println("You must enter a float (ex : 123.50, 682.0) !" + "\n");
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}
		}
		
		this.REA.signSalesMandate(vis, prop, availabilityDate, desiredSaleDate, desiredPrice);
		
	}
	
	private Property parseProperty(Scanner sc){
		Property propRet = null;
		
		System.out.println("Registering a new Property :");
		
		int typeOfProperty = -1;
		
		while(typeOfProperty < 0 && typeOfProperty > ){
			
		}
		
		return propRet;
	}

}
