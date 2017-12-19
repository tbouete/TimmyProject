package person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import agency.Notary;
import agency.SalesAgreement;
import agency.SalesMandate;
import agency.Wish;
import property.Property;



public class Person 
{

	private String address;
	private String email;
	private String name;
	private String phoneNumber;

	private List<SalesAgreement> listSalesAgreement;
	private List<SalesMandate> 	 listSalesMandate;
	private List<Wish> 			 listWhishes;
	private boolean PropertySimilirarToWishAvailable;

	private Notary associatedNotary;

	
	
	//Seller
	public Person(String address, String email, String name, String phoneNumber, String addressNotary)
	{
		this.address = address;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.associatedNotary = new Notary(addressNotary, this);

		this.listSalesAgreement = new ArrayList<>();
		this.listSalesMandate 	= new ArrayList<>();
		this.listWhishes 		= new ArrayList<>();

	}

	//Buyer
	public Person(String address, String email, String name, String phoneNumber)
	{
		this.address = address;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.listSalesAgreement = new ArrayList<>();
		this.listSalesMandate 	= new ArrayList<>();
		this.listWhishes 		= new ArrayList<>();
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
		for(Wish w : this.listWhishes)
			if(w.equals(wish)) this.listWhishes.add(wish);
		//TODO : si propri�t� similaire en vente, changer this.PropertySimilirarToWishAvailable � true
	}

	public void putPropertyOnSale(Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice) throws Exception
	{
		if(this.associatedNotary == null) throw new Exception("Cannot use putPropertyOnSale because there is no notary(not a seller)");
		
		SalesMandate sMand = new SalesMandate(prop, availabilityDate, desiredSaleDate, desiredPrice);
		prop.setSaleMandate(sMand);
		this.listSalesMandate.add(sMand);
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


	public float payMoneyForSalesAgreement(float amount, int salesAgreementID){ return this.listSalesAgreement.get(salesAgreementID).receiveMoney(amount); }

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

	public List<Wish> getListWhishes() 
	{
		return listWhishes;
	}

	public Notary getAssociatedNotary() 
	{
		return associatedNotary;
	}

	public void setAssociatedNotary(Notary associatedNotary) 
	{
		this.associatedNotary = associatedNotary;
	}


}
