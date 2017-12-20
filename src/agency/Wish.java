package agency;

import property.Property;
import property.PropertyTypes;

public class Wish {

	private float desiredPriceWished;
	private int floorArea;
	private String localisation;
	private int numberRooms;
	private PropertyTypes typeOfProperty;
	
	
	public Wish(float desiredPriceWished, int floorArea, String localisation, int numberRooms, PropertyTypes typeOfProperty){
		this.desiredPriceWished = desiredPriceWished;
		this.floorArea = floorArea;
		this.localisation = localisation;
		this.numberRooms = numberRooms;
		this.typeOfProperty = typeOfProperty;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Wish tmp;
		
		try{
			tmp = (Wish)obj;
		}
		catch(ClassCastException e){
			return false;
		}
		
		boolean ret = tmp.getDesiredPriceWished() == this.getDesiredPriceWished();
		if(ret) ret = tmp.getFloorArea() == (this.getFloorArea());
		if(ret) ret = tmp.getLocalisation().equals(this.getLocalisation());
		if(ret) ret = tmp.getNumberRooms() == this.getNumberRooms();
		if(ret) ret = tmp.getTypeOfProperty() == this.getTypeOfProperty();
		
		return ret;
	}

	public boolean compareToProperty(SalesMandate sM){
		boolean ret = false;
		
		ret = Boolean.logicalAnd(ret, sM.getDesiredPrice() <= this.desiredPriceWished * 1.1); //The price of the property should be at max 110% of the requested value
		ret = Boolean.logicalAnd(ret, sM.getProperty().getAreaProperty() >= this.floorArea * 0.9); //The area of the property should be at least 90% of the requested value
		ret = Boolean.logicalAnd(ret, sM.getProperty().getAddress().equals(this.getLocalisation()));
		ret = Boolean.logicalAnd(ret, sM.getProperty().getClass().getName().equals(this.typeOfProperty.toString()));
		if(this.typeOfProperty.equals(PropertyTypes.Flat) || this.typeOfProperty.equals(PropertyTypes.House)){
			ret = Boolean.logicalAnd(ret, sM.getProperty().getNumberOfRooms() >= this.numberRooms);
		}
				
		return ret;
	}


	protected float getDesiredPriceWished() {
		return desiredPriceWished;
	}
	protected void setDesiredPriceWished(float desiredPriceWished) {
		this.desiredPriceWished = desiredPriceWished;
	}
	protected int getFloorArea() {
		return floorArea;
	}
	protected void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}
	protected String getLocalisation() {
		return localisation;
	}
	protected void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	protected int getNumberRooms() {
		return numberRooms;
	}
	protected void setNumberRooms(int numberRooms) {
		this.numberRooms = numberRooms;
	}
	protected PropertyTypes getTypeOfProperty() {
		return typeOfProperty;
	}
	protected void setTypeOfProperty(PropertyTypes typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}
	
	public static void main(String args[]){
		Wish test = new Wish(0, 0, "", 0, PropertyTypes.Flat);
		Wish tast = new Wish(0, 0, "", 0, PropertyTypes.Flat);
		System.out.println(test.typeOfProperty == tast.typeOfProperty);
	}
	
}
