package agency;

import java.util.ArrayList;
import java.util.List;

import person.Person;

public class RealEstateAgency {
	
	private List<Person> listClients;
	private List<Visit>  listVisits;
	
	public RealEstateAgency(){
		this.listClients = new ArrayList<>();
		this.listVisits  = new ArrayList<>();
		
	}
	
}
