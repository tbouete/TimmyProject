package property;

public enum PropertyTypes {
	Flat("property.Flat"),
	Plot("property.Plot"),
	House("property.House");
	
	private String name = "";

    PropertyTypes(String name){ this.name = name; }

    public String toString(){ return name; } 
}
