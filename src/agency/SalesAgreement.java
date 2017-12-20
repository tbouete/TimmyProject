package agency;

import java.util.Date;

import property.Property;

public class SalesAgreement {

	private final float PERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN = new Float(0.1);
	private final float AGENCYS_COMMISION_PERCENTAGE = new Float(0.7);
	private final float sellingFees;
	private final float priceToPayTotal;
	private float moneyLeftToBePaid;
	private Date saleDate;
	private boolean saleState;
	private final Property propertyToBeBought;
	
	public SalesAgreement(Property propertyToBeBought, Date saleDate, float sellingFees, float priceToPayTotal){
		this.propertyToBeBought = propertyToBeBought;
		this.sellingFees = sellingFees;
		this.priceToPayTotal = priceToPayTotal;
		this.moneyLeftToBePaid = priceToPayTotal;
		this.saleDate = saleDate;
		this.saleState = false;
		
		this.propertyToBeBought.getSaleMandate().setSaleState(true);
	}
	
	public float receiveMoney(float amountOfMoneyToBeReceived) throws IllegalArgumentException{
		if(amountOfMoneyToBeReceived > moneyLeftToBePaid) throw new IllegalArgumentException();
		
		this.moneyLeftToBePaid -= amountOfMoneyToBeReceived;
		if(moneyLeftToBePaid == 0) this.saleState = true;
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
	
	public float getPERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN() {
		return PERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN;
	}

	public float getASGENCYS_COMMISION_PERCENTAGE() {
		return AGENCYS_COMMISION_PERCENTAGE;
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

	public Property getpropertyToBeBought() {
		return propertyToBeBought;
	}
	
}
