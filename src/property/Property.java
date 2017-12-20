package property;

import agency.SalesMandate;

public abstract class Property {

	private final String address;
	private final Orientation orientation;
	private int areaProperty;
	private int numberOfRooms;
	
	SalesMandate saleMandate;
	
	public Property(String address, Orientation orientation, int areaProperty){
		this.address = address;
		this.orientation = orientation;
		this.areaProperty = areaProperty;
		this.numberOfRooms = 0;
	}
	
	public SalesMandate getSaleMandate(){ return this.saleMandate; }
	
	public void setSaleMandate(SalesMandate sMand){ this.saleMandate = sMand; }
	
	public String getAddress(){ return this.address; }
	
	public Orientation getOrientation(){ return this.orientation; }
	
	public int getAreaProperty(){ return this.areaProperty; }
	
	public int getNumberOfRooms(){ return this.numberOfRooms; }
	
	public void setNumberOfRooms(int numberOfRooms){ this.numberOfRooms = numberOfRooms; }
}
