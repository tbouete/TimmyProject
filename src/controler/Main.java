package controler;

import agency.RealEstateAgency;
import agency.Visit;
import agency.Wish;

import java.util.Date;

import agency.Notary;
import person.Person;
import property.Flat;
import property.Orientation;
import property.Property;
import property.PropertyTypes;


public class Main 
{

	public static void main(String[] args) 
	{
		
		
		
		
		 RealEstateAgency krustyKrabAgency = new RealEstateAgency();
		 Person spongeBobSeller = new Person("Bikini Bottom One","spongeBobi@lovekrustypate.com", "SpongeBob","+330631224568","Pacific Ocean");
		 Person starfishPatrickBuyer = new Person("Bikini Bottom Two","starfishTrickPa@lovekrustypate.com", "Patrick Wonderful Starfish","+330604468764", "Pacific Ocean");
		 Property ananas = new Flat("PloufCity", Orientation.NORTH, 50, 5, 6, 1500);
		 
		 krustyKrabAgency.registerSeller(spongeBobSeller,new Date());
		 Wish[] wishes = {new Wish(1500, 45, "PloufCity", 5, PropertyTypes.Flat)};
		 krustyKrabAgency.registerBuyer(starfishPatrickBuyer, wishes);
		 
		 krustyKrabAgency.signSalesMandate(krustyKrabAgency.getListVisits().get(0), ananas, new Date(),
				 						   new Date(System.currentTimeMillis() + 10 * 86400000), 1000);
		 
		 krustyKrabAgency.signSalesAgreement(starfishPatrickBuyer, ananas, new Date(System.currentTimeMillis() + 5 * 86400000),
				 							 50, 1450);
		 
		 
		 
		 
		 
		 
		 //krustyKrabAgency.registerBuyer(,poule);
		 
		 
		// signSaleMandate(Visit vis, Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice)
		
		
		
		
		
		System.out.println("Done");
		

	}

}
