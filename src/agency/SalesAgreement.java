package agency;

import java.util.Date;

import property.Property;

public class SalesAgreement {

	private final float PERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN = new Float(0.1);
	private final float AGENCYS_COMMISION_PERCENTAGE = new Float(0.07);
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
	
	
	
	@Override
	public String toString() {
		String ret = "";
		
		ret += "**SalesAgreement** " + "\n";
		
		if(this.saleState) ret += "This deal is complete";
		else{
			ret += "This deal is currently incomplete. Amount left to be paid : " + this.moneyLeftToBePaid + "€\n";
		}
		
		ret += "Date of the transaction : " + this.saleDate + "\n";; 
		ret += "Address of the property concerned by this mandate : " + this.propertyToBeBought.getAddress() + "\n";
		ret += "Initial price : " +this.getInitialPrice() + "\n";;
		ret += "Agency's commision : " + this.AGENCYS_COMMISION_PERCENTAGE + "%\n";
		ret += "Selling fees : " + this.sellingFees + "\n";
		ret += "Total price : " + this.priceToPayTotal + "\n";
		ret += "Percentage of the total price paid when signing this agreement : " + this.PERCENTAGE_OF_PRICE_TO_PAY_ON_SIGN + "%\n";
		
		return ret;
	}



	public float receiveMoney(float amountOfMoneyToBeReceived) throws IllegalArgumentException{
		if(amountOfMoneyToBeReceived > moneyLeftToBePaid) throw new IllegalArgumentException();
		
		this.moneyLeftToBePaid -= amountOfMoneyToBeReceived;
		if(moneyLeftToBePaid == 0) this.saleState = true;
		return this.moneyLeftToBePaid;
	}
	
	public float getInitialPrice(){
		return this.priceToPayTotal - this.sellingFees - (this.priceToPayTotal * this.AGENCYS_COMMISION_PERCENTAGE);
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
