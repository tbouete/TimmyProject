package agency;

import java.util.Date;

import property.Property;

public class SalesAgreement {

	private final float ASGENCYS_COMMISION_PERCENTAGE = 7;
	private final float sellingFees;
	private final float priceToPayTotal;
	private float moneyLeftToBePaid;
	private Date saleDate;
	private boolean saleState;
	private final Property propertyToBeSold;
	
	public SalesAgreement(Property propertyToBeSold, Date saleDate, float sellingFees, float priceToPayTotal){
		this.propertyToBeSold = propertyToBeSold;
		this.sellingFees = sellingFees;
		this.priceToPayTotal = priceToPayTotal;
		this.moneyLeftToBePaid = priceToPayTotal;
		this.saleDate = saleDate;
		this.saleState = false;
		
		this.propertyToBeSold.getSaleMandate().setSaleState(true);
	}
	
	public float receiveMoney(float amountOfMoneyToBeReceived) throws IllegalArgumentException{
		if(amountOfMoneyToBeReceived > moneyLeftToBePaid) throw new IllegalArgumentException();
		
		this.moneyLeftToBePaid -= amountOfMoneyToBeReceived;
		return this.moneyLeftToBePaid;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public boolean isSaleState() {
		return saleState;
	}

	public void setSaleState(boolean saleState) {
		this.saleState = saleState;
	}

	public float getASGENCYS_COMMISION_PERCENTAGE() {
		return ASGENCYS_COMMISION_PERCENTAGE;
	}

	public float getSellingFees() {
		return sellingFees;
	}

	public float getPriceToPayTotal() {
		return priceToPayTotal;
	}

	public float getMoneyLeftToBePaid() {
		return moneyLeftToBePaid;
	}

	public Property getPropertyToBeSold() {
		return propertyToBeSold;
	}
	
}
