package property;

public class House extends Plot {

	private int numberOfRooms;
	private int numberOfFloors;
	private HouseHeatingMode heatingMode;
	
	public House(String address, Orientation orientation, int areaProperty, int areaPlot, int numberOfRooms, int numberOfFloors, HouseHeatingMode heatingMode) {
		super(address, orientation, areaProperty, areaPlot);
		this.numberOfRooms = numberOfRooms;
		this.numberOfFloors = numberOfFloors;
		this.heatingMode = heatingMode;
	}

	public int getNumberOfRooms(){ return this.numberOfRooms; }
	
	public void setNumberOfRooms(int nb){ this.numberOfRooms = nb; }
	
	public int getNumberOfFloors(){ return this.numberOfFloors; }
	
	public void setNumberOfFloors(int nb){ this.numberOfFloors = nb; }
	
	public HouseHeatingMode getHeatingMode(){ return this.heatingMode; }
	
	public void setHeatingMode(HouseHeatingMode heatingMode){ this.heatingMode = heatingMode; }
	
}
