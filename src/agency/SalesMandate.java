package agency;

import java.util.Date;

import property.Property;

public class SalesMandate {

	private final Property property;
	private Date availabilityDate;
	private Date desiredSaleDate;
	private float desiredPrice;
	private boolean saleState;
	
	public SalesMandate(Property prop, Date availabilityDate, Date desiredSaleDate, float desiredPrice){
		this.property = prop;
		this.availabilityDate = availabilityDate;
		this.desiredSaleDate = desiredSaleDate;
		this.desiredPrice = desiredPrice;
		this.saleState = false;
	}
	
	
	
	@Override
	public String toString() {
		String ret = "";
		
		ret += "**SalesMandate**\n";
		ret += "Address of the property concerned : " + this.property.getAddress() + "\n";
		ret += "Desired price : " + this.desiredPrice + "\n";
		ret += "Desired sale date : " + this.desiredSaleDate + "\n";
		ret += "Availability date : " +  this.availabilityDate + "\n";
		if(this.saleState) ret += "A sale agreement has been signed on this property, meaning this mandate cannot be canceled." + "\n";
		else ret += "No sale agreement has been signed on this property, meaning this mandate be canceled." + "\n";
		
		ret += "\n";
		return ret;
	}



	public Property getProperty() {
		return property;
	}

	public Date getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(Date availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public Date getDesiredSaleDate() {
		return desiredSaleDate;
	}

	public void setDesiredSaleDate(Date desiredSaleDate) {
		this.desiredSaleDate = desiredSaleDate;
	}

	public float getDesiredPrice() {
		return desiredPrice;
	}

	public void setDesiredPrice(float desiredPrice) {
		this.desiredPrice = desiredPrice;
	}

	public boolean isSaleState() {
		return saleState;
	}
	
	public void setSaleState(boolean state){
		this.saleState = state;
	}
	
	
	
}
