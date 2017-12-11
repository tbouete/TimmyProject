package agency;

import java.util.Date;

import person.Person;

public class Visit {

	private Person client;
	private Date dateOfVisit;
	private String description;
	private boolean hasHappened;
	
	public Visit(Person client, Date dateOfVisit, String description){
		this.client = client;
		this.dateOfVisit = dateOfVisit;
		this.description = description;
		this.hasHappened = false;
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
	
	public boolean getHasHappened(){ return this.hasHappened; }
	
	public void setHasHappened(boolean b){ this.hasHappened = b; }
	
}
