package property;

public abstract class Property {

	private final String address;
	private final Orientation orientation;
	private int areaProperty;
	
	public Property(String address, Orientation orientation, int areaProperty){
		this.address = address;
		this.orientation = orientation;
		this.areaProperty = areaProperty;
	}
	
	public String getAddress(){ return this.address; }
	
	public Orientation getOrientation(){ return this.orientation; }
	
	public int getAreaProperty(){ return this.areaProperty; }
}
