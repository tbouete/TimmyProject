package person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import agency.Notary;
import agency.NotaryMoneyStates;
import agency.SalesAgreement;
import agency.SalesMandate;
import agency.Wish;
import property.Property;



public class Person extends Observable{

	private String address;
	private String email;
	private String name;
	private String phoneNumber;

	private List<SalesAgreement> listSalesAgreement;
	private List<SalesMandate> 	 listSalesMandate;
	private List<Wish> 			 listWishes;
	private boolean PropertySimilirarToWishAvailable;

	private Notary associatedNotary;

	
	public Person(String address, String email, String name, String phoneNumber, String addressNotary)
	{
		this.address = address;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.associatedNotary = new Notary(addressNotary, this);

		this.listSalesAgreement = new ArrayList<>();
		this.listSalesMandate 	= new ArrayList<>();
		this.listWishes 		= new ArrayList<>();

	}



	@Override
	public String toString() {
		String ret = "";

		ret += "**Client**\n";
		ret += "Client " + this.name + "\n";
		ret += "Address : " + this.address +"\n";
		ret += "Email : " + this.email  + "\n";
		ret += "Phone number : " + this.phoneNumber + "\n";
		ret += "Address of the notary associated to this client : " + this.associatedNotary.getAddress() + "\n";

		if(this.listSalesAgreement.size() < 1) ret += "No property bought or being bought." + "\n";
		else{
			ret += "\n" + "Properties bought or being bought : \n";
			for(SalesAgreement sA : this.listSalesAgreement) ret += sA.toString() + "\n";
		}

		if(this.listSalesMandate.size() < 1) ret += "No property sold or being sold." + "\n";
		else{
			ret += "\n" + "Properties sold or being sold : \n";
			for(SalesMandate sM : this.listSalesMandate) ret += sM.toString();
		}

		if(this.listWishes.size() < 1) ret += "No buying wishes known.." + "\n";
		else{
			ret += "\n" + "Buying wishes : \n";
			for(Wish w : this.listWishes) ret += w.toString() + "\n";
		}
		
		ret += "\n";
		return ret;
	}



	@Override
	public boolean equals(Object obj) 
	{
		Person tmp;

		try
		{
			tmp = (Person)obj;
		}
		catch(ClassCastException e)
		{
			return false;
		}

		
		boolean ret = tmp.getAddress().equals(this.getAddress());
		if(ret) ret = tmp.getEmail().equals(this.getEmail());
		if(ret) ret = tmp.getName().equals(this.getName());
		if(ret) ret = tmp.getPhoneNumber().equals(this.getPhoneNumber());

		return ret;
	}



	public void addWish(Wish wish)
	{
		this.listWishes.add(wish);
		this.notifyObservers();
	}

	public void putPropertyOnSale(Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice){	
		SalesMandate sMand = new SalesMandate(prop, availabilityDate, desiredSaleDate, desiredPrice);
		prop.setSaleMandate(sMand);
		this.listSalesMandate.add(sMand);
		this.notifyObservers();
	}




	public boolean removePropertyFromSale(Property prop)
	{
		int rankSaleAgreement = -1;
		boolean isPropertyStillOnSale = false;

		for(int i = 0; i < this.listSalesMandate.size(); i++)
		{
			if(this.listSalesMandate.get(i).getProperty().equals(prop)) rankSaleAgreement = i;
		}

		if(rankSaleAgreement != -1)
		{
			isPropertyStillOnSale = true;
			if(!this.listSalesMandate.get(rankSaleAgreement).isSaleState())
			{
				this.listSalesMandate.remove(rankSaleAgreement);
				isPropertyStillOnSale = false;
			}
		}

		return isPropertyStillOnSale;
	}

	public void signSellAgreement(Property propertyToBeBought, Date saleDate, float sellingFees, float priceToPayTotal){
		SalesAgreement sA = new SalesAgreement(propertyToBeBought, saleDate, sellingFees, priceToPayTotal);
		this.listSalesAgreement.add(sA);
		this.payMoneyForSalesAgreement(priceToPayTotal * sA.getPERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN(), this.listSalesAgreement.indexOf(sA));
	}

	public float payMoneyForSalesAgreement(float amount, int salesAgreementID) throws IllegalArgumentException{
		if(salesAgreementID > this.listSalesAgreement.size()) throw new IllegalArgumentException();
		if(amount > 0) this.associatedNotary.setMoneyStat(NotaryMoneyStates.partialPaymentReceived);
		return this.listSalesAgreement.get(salesAgreementID).receiveMoney(amount);
	}
	
	

	public String getAddress() 
	{
		return address;
	}

	public String getEmail() 
	{
		return email;
	}

	public String getName() 
	{
		return name;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public List<SalesAgreement> getListSalesAgreement() 
	{
		return listSalesAgreement;
	}

	public List<SalesMandate> getListSalesMandate() 
	{
		return listSalesMandate;
	}

	public List<Wish> getListWishes() 
	{
		return listWishes;
	}

	public Notary getAssociatedNotary() 
	{
		return associatedNotary;
	}

	public void setAssociatedNotary(Notary associatedNotary) 
	{
		this.associatedNotary = associatedNotary;
	}

	public boolean isPropertySimilirarToWishAvailable() {
		return PropertySimilirarToWishAvailable;
	}

	public void setPropertySimilirarToWishAvailable(boolean propertySimilirarToWishAvailable) {
		PropertySimilirarToWishAvailable = propertySimilirarToWishAvailable;
	}

	

}
