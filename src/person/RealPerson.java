package person;

public class RealPerson extends Person {

	private String address;
	private String email;
	private String name;
	private String phoneNumber;
	

	public RealPerson(String address, String email, String name, String phoneNumber, String addressNotary) {
		super(addressNotary);
		this.address = address;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}
	
	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
