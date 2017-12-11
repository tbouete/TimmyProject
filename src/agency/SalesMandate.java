package agency;

import java.util.Date;

public class SalesMandate {

	private Date availabilityDate;
	private Date desiredSaleDate;
	private float desiredPrice;
	private boolean saleState;
	
	public SalesMandate(Date availabilityDate, Date desiredSaleDate, float desiredPrice){
		this.availabilityDate = availabilityDate;
		this.desiredSaleDate = desiredSaleDate;
		this.desiredPrice = desiredPrice;
		this.saleState = false;
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
