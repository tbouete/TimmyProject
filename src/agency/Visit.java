package agency;

import java.util.Date;

import person.Person;

public class Visit {

	private Person client;
	private Date dateOfVisit;
	private String description;
	private boolean hasHappened;
	private int idSalesAgreement; //if = -1, it means this visit does not concern a transaction.
	
	public Visit(Person client, Date dateOfVisit, String description, int idSalesAgreement){
		this.client = client;
		this.dateOfVisit = dateOfVisit;
		this.description = description;
		this.idSalesAgreement = idSalesAgreement;
		this.hasHappened = false;
	}
	
	public Visit(Person client, Date dateOfVisit, String description){
		this(client, dateOfVisit, description, -1);
	}
	
	
	
	@Override
	public String toString() {
		String ret = "";
		
		ret += "**Visit**" + "\n";
		
		if(this.hasHappened) ret += "This visit had yet to happen." + "\n";
		else ret+= "This visit already happened."  + "\n";
		
		ret += "Date of the visit : " + this.dateOfVisit + "\n";
		ret += "Subject of the visit : " + this.description + "\n";
		
		ret += "\n";
		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		Visit tmp;
		
		try{
			tmp = (Visit)obj;
		}
		catch(ClassCastException e){
			return false;
		}
		boolean ret = tmp.getClient().equals(this.getClient());
		if(ret) ret = tmp.getDate().equals(this.getDate());
		if(ret) ret = tmp.getDescription().equals(this.getDescription());
		return ret;
	}



	public Person getClient(){ return this.client; }
	
	public Notary getNotary(){ return this.client.getAssociatedNotary(); }
	
	public Date getDate(){ return this.dateOfVisit; }
	
	public String getDescription(){ return this.description; }
	
	public int getIdSalesAgreement(){ return this.idSalesAgreement; }
	
	public boolean getHasHappened(){ return this.hasHappened; }
	
	public void setHasHappened(boolean b){ this.hasHappened = b; }
	
}
