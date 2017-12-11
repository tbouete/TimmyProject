package property;

public class Flat extends Property {

	private int numberOfRooms;
	private final int FLOOR;
	private float monthlyCharges;
	
	public Flat(String address, Orientation orientation, int areaProperty, int numberOfRooms, int floor, float monthlyCharges) {
		super(address, orientation, areaProperty);
		this.numberOfRooms = numberOfRooms;
		this.FLOOR = floor;
		this.monthlyCharges = monthlyCharges;
	}
	
	public int getNumberOfRooms(){ return this.numberOfRooms; }
	
	public void setNumberOfRooms(int nb){ this.numberOfRooms = nb; }

	public int getFloor(){ return this.FLOOR; }
	
	public float getMonthlyCharges(){ return this.monthlyCharges; }
	
	public void setMonthlyCharges(float monthlyCharges){ this.monthlyCharges = monthlyCharges; }
	
}
