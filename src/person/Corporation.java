package person;

public class Corporation extends Person {

	private String numeroSiren;
	private CorporationLegalForm legalForm;
	
	public Corporation(String address, String email, String name, String phoneNumber, String numeroSiren, CorporationLegalForm legalForm,String addressNotary) {
		super(address, email, name, phoneNumber, addressNotary);
		this.numeroSiren = numeroSiren;
		this.legalForm = legalForm;
	}

	public String getNumeroSiren() {
		return numeroSiren;
	}

	public void setNumeroSiren(String numeroSiren) {
		this.numeroSiren = numeroSiren;
	}

	public CorporationLegalForm getLegalForm() {
		return legalForm;
	}

	public void setLegalForm(CorporationLegalForm legalForm) {
		this.legalForm = legalForm;
	}

	
}
