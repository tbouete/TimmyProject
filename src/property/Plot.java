package property;

public class Plot extends Property {

	private int areaPlot;
	
	public Plot(String address, Orientation orientation, int areaProperty, int areaPlot) {
		super(address, orientation, areaProperty);
		this.areaPlot = areaPlot;
	}

}
