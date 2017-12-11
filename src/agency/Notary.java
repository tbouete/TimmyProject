package agency;

import person.Person;

public class Notary {

	private String address;
	private Person associatedClient;
	private NotaryMoneyStates moneyState;
	
	public Notary(String address, Person associatedClient){
		this.address = address;
		this.associatedClient = associatedClient;
		this.moneyState = NotaryMoneyStates.noMoneyReceived;
	}
}
