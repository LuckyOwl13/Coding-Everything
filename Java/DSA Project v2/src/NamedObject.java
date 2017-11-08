
// Caitlin McElwee
public abstract class NamedObject {
	// the name of the object.
	/**
	 * Name of the object
	 */
	protected String name;

	public NamedObject(String name) {
		this.name = name;
	}	// end Constructor
	
	public String getName(){
		return name;
	}	// end getName
}	// end Class
