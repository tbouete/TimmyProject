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

	
	
	@Override
	public String toString() {
		String ret = "";
		
		ret += "**Notary :**\n";
		ret += "Address : " + this.address + "\n";
		ret += "Name of the client this notary is associated to : " + this.associatedClient.getName() + "\n";
		ret += "State of the notary : " + this.moneyState + "\n"; 
		
		ret += "\n";
		return ret;				
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
