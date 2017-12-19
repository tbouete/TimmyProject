package agency;

import java.util.Date;

import property.Property;

public class SalesAgreement {

	private final float ASGENCYS_COMMISION_PERCENTAGE = 7;
	private float sellingFees;
	private float priceToPay;
	private Date saleDate;
	private boolean saleState;
	private Property propertyToBeSold;
	
	public SalesAgreement(Property propertyToBeSold, Date saleDate, float sellingFees, float priceToPay){
		this.propertyToBeSold = propertyToBeSold;
		this.sellingFees = sellingFees;
		this.priceToPay = priceToPay;
		this.saleDate = saleDate;
		this.saleState = false;
		
		this.propertyToBeSold.getSaleMandate().setSaleState(true);
	}
	
	
	
}
