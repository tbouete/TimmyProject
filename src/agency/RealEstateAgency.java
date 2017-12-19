package agency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import person.Person;
import property.Property;

public class RealEstateAgency {
	
	private List<Person> listClients;
	private List<Visit>  listVisits;
	
	public RealEstateAgency(){
		this.listClients = new ArrayList<>();
		this.listVisits  = new ArrayList<>();
		
	}
	
	public void registerSeller(Person seller, Date dateOfVisit){
		boolean clientAlreadyExists = false;
		for(Person client : this.listClients){
			Boolean.logicalOr(clientAlreadyExists, client.equals(seller));
		}
		if(!clientAlreadyExists) this.listClients.add(seller);
		
		this.listVisits.add(new Visit(seller, dateOfVisit, new String(seller.getName() +
																	  " is signing a sale mandate with " +
																	  seller.getAssociatedNotary().getAddress() +
																	  ".")));
		
	}
	
	public void registerBuyer(Person buyer, Wish[] wishes){
		boolean clientAlreadyExists = false;
		for(Person client : this.listClients){
			Boolean.logicalOr(clientAlreadyExists, client.equals(buyer));
		}
		if(!clientAlreadyExists){
			for(Wish w : wishes) buyer.addWish(w);
			this.listClients.add(buyer);
		}
		
		//Si le client est déjà enregistrer, parcourir la liste des clients existants et ajoutez les voeux au bon client.
		else for(Person client : this.listClients) if(client.equals(buyer)) for(Wish w : wishes) buyer.addWish(w);
		
	}
	
	
	
	/**
	 * 
	 * @param vis The @Visit at which this mandate has been signed. This @Visit must be known by the @RealEstateAgency this method is being called upon.
	 * @param prop The @Property being put on sale.
	 * @param availabilityDate the @Date at which @prop will be available for sale.
	 * @param desiredSaleDate
	 * @param desiredPrice
	 * @throws IllegalArgumentException if @vis is not known by this @RealEstateAgency
	 */
	public void signSaleMandate(Visit vis, Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice) throws IllegalArgumentException{
		//Test if the visit is planned by the agency
		boolean visitIsPlanned = false;
		for(Visit v : this.listVisits){
			Boolean.logicalOr(visitIsPlanned, v.equals(vis));
		}
		if(!visitIsPlanned) throw new IllegalArgumentException();
		
		
		vis.getClient().putPropertyOnSale(prop, availabilityDate, desiredSaleDate, desiredPrice);
		vis.setHasHappened(true);
	}
	
	
	
}
