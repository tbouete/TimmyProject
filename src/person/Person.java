package person;

import java.util.ArrayList;
import java.util.List;

import agency.Notary;
import agency.SalesAgreement;
import agency.SalesMandate;
import agency.Wish;

public class Person {

	private List<SalesAgreement> listSalesAgreement;
	private List<SalesMandate> 	 listSalesMandate;
	private List<Wish> 			 listWhishes;
	
	private Notary associatedNotary;
	
	public Person(String addressNotary){
		this.associatedNotary = new Notary(addressNotary, this);
		
		this.listSalesAgreement = new ArrayList<>();
		this.listSalesMandate 	= new ArrayList<>();
		this.listWhishes 		= new ArrayList<>();
		
	}

	public List<SalesAgreement> getListSalesAgreement() {
		return listSalesAgreement;
	}

	public List<SalesMandate> getListSalesMandate() {
		return listSalesMandate;
	}

	public List<Wish> getListWhishes() {
		return listWhishes;
	}

	public Notary getAssociatedNotary() {
		return associatedNotary;
	}

	public void setAssociatedNotary(Notary associatedNotary) {
		this.associatedNotary = associatedNotary;
	}
	
	
}
