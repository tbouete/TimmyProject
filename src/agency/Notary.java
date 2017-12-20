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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person getAssociatedClient() {
		return associatedClient;
	}

	public void setAssociatedClient(Person associatedClient) {
		this.associatedClient = associatedClient;
	}

	public NotaryMoneyStates getMoneyState() {
		return moneyState;
	}
	
	public void setMoneyStat(NotaryMoneyStates state){
		this.moneyState = state;
	}
	
	
}
