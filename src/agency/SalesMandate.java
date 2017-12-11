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
	
	
	
	
}
