package agency;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import person.Person;
import property.Property;

public class RealEstateAgency implements Observer{
	
	private List<Person> listClients;
	private List<Visit>  listVisits;
	private HashMap<Person, SalesMandate> propertiesSimilarToWishes;
	
	public RealEstateAgency(){
		this.listClients = new ArrayList<>();
		this.listVisits  = new ArrayList<>();
		
	}
	
	public void registerSeller(Person seller, Date dateOfVisit){
		boolean clientAlreadyExists = false;
		for(Person client : this.listClients){
			Boolean.logicalOr(clientAlreadyExists, client.equals(seller));
		}
		if(!clientAlreadyExists){
			seller.addObserver(this);
			this.listClients.add(seller);
		}
		
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
			for(Wish w : wishes)buyer.addWish(w);
			buyer.addObserver(this);
			this.listClients.add(buyer);
		}
		
		//If the client is already registered,parse the existing clients list and the wishes to the right one.
		else for(Person client : this.listClients) if(client.equals(buyer)) for(Wish w : wishes) buyer.addWish(w);
		
	}
	
	
	
	/**
	 * 
	 * @param vis The @Visit at which this mandate has been signed. This @Visit must be known by the @RealEstateAgency this method is being called upon.
	 * @param prop The @Property being put on sale.
	 * @param availabilityDate the @Date at which @prop will be available for sale.
	 * @param desiredSaleDate
	 * @param desiredPrice
	 * @throws IllegalArgumentException if @vis is not known by this @RealEstateAgency.
	 */
	public void signSalesMandate(Visit vis, Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice) throws IllegalArgumentException{
		//Test if the visit is planned by the agency

		int indexOfVis = this.listVisits.indexOf(vis);
		if(indexOfVis == -1) throw new IllegalArgumentException("This visit was not planned by the agency !");


		this.listVisits.get(indexOfVis).getClient().putPropertyOnSale(prop, availabilityDate, desiredSaleDate, desiredPrice);
		this.listVisits.get(indexOfVis).setHasHappened(true);
		
	}
	
	public void signSalesAgreement(Person buyer, Property propertyToBeBought, Date saleDate, float sellingFees, float priceToPayTotal) throws IllegalArgumentException{
		int indexOfBuyer = this.listClients.indexOf(buyer);
		if(indexOfBuyer == -1) throw new IllegalArgumentException("This client is not known by the agency.");
		this.listClients.get(indexOfBuyer).signSellAgreement(propertyToBeBought, saleDate, sellingFees, priceToPayTotal);
		
		String descVis = new String(buyer.getName() + " is buying a property at " + propertyToBeBought.getAddress());
		Visit vis = new Visit(buyer, saleDate, descVis, this.listClients.get(indexOfBuyer).getListSalesAgreement().size()-1);
		
		this.listVisits.add(vis);
	}
	
	public void confirmTransaction(Visit vis) throws IllegalArgumentException{
		int indexOfVis = this.listVisits.indexOf(vis);
		if(indexOfVis == -1) throw new IllegalArgumentException("This visit was not planned by the agency !");
		
		if(vis.getIdSalesAgreement() == -1) throw new IllegalArgumentException("This visit is not about a transaction !");
		SalesAgreement sAOfBuyer = vis.getClient().getListSalesAgreement().get(vis.getIdSalesAgreement());
		this.listVisits.get(indexOfVis).getClient().payMoneyForSalesAgreement(sAOfBuyer.getMoneyLeftToBePaid(), vis.getIdSalesAgreement());
		this.listVisits.get(indexOfVis).getClient().getAssociatedNotary().setMoneyStat(NotaryMoneyStates.fullPaymentReceived);
		this.listVisits.get(indexOfVis).setHasHappened(true);
		
		
	}
	
	public void presentWishToBuyer(Person buyer, SalesMandate sMOfPropertyOnSale,Date dateOfVisit){
		String visDesc = new String("Visit of " + sMOfPropertyOnSale.getProperty().getAddress() +
				" by " + buyer.getName() +
				" because it was similar to one of his/her wishes");

		//Set a visit of the property in a exactly a month
		Visit vis = new Visit(buyer, dateOfVisit, visDesc);
		this.listVisits.add(vis);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.propertiesSimilarToWishes = this.lookForWishesAvailable();
		for(Person p : this.listClients)
			this.listClients.get(this.listClients.indexOf(p)).setPropertySimilirarToWishAvailable(false);
		
		for(Person p : this.propertiesSimilarToWishes.keySet())
			this.listClients.get(this.listClients.indexOf(p)).setPropertySimilirarToWishAvailable(true);
		
	}

	private HashMap<Person, SalesMandate> lookForWishesAvailable(){
		HashMap<Person, SalesMandate> propertiesSimilarToWishes= new HashMap<>();
		for(Person personWithWishes : this.listClients){
			for(Wish wish : personWithWishes.getListWishes()){
				for(Person personWithPropertiesOnSale : this.listClients){
					for(SalesMandate sMOfPropertyOnSale : personWithPropertiesOnSale.getListSalesMandate()){
						if(wish.compareToProperty(sMOfPropertyOnSale)){
							propertiesSimilarToWishes.put(personWithWishes, sMOfPropertyOnSale);
						}
					}
				}
			}
		}
		return propertiesSimilarToWishes;
	}

	public List<Person> getListClients() {
		return listClients;
	}

	public List<Visit> getListVisits() {
		return listVisits;
	}

	public HashMap<Person, SalesMandate> getPropertiesSimilarToWishes() {
		return propertiesSimilarToWishes;
	}
	
	
	
}
