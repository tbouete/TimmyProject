package property;

public class Flat extends Property {

	private final int FLOOR;
	private float monthlyCharges;
	
	public Flat(String address, Orientation orientation, int areaProperty, int numberOfRooms, int floor, float monthlyCharges) {
		super(address, orientation, areaProperty);
		super.setNumberOfRooms(numberOfRooms);
		this.FLOOR = floor;
		this.monthlyCharges = monthlyCharges;
	}

	public int getFloor(){ return this.FLOOR; }
	
	public float getMonthlyCharges(){ return this.monthlyCharges; }
	
	public void setMonthlyCharges(float monthlyCharges){ this.monthlyCharges = monthlyCharges; }
	
}
