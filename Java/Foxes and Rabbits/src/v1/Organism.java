package v1;

import java.util.List;

public abstract class Organism {
	
    // The animal's field.
    protected Field field;
    // The animal's position in the field.
    protected Location location;
    // Whether the organism is alive or not.
    protected boolean alive;
    
    public Organism(Field field, Location location)
    {
    	setField(field);
        setLocation(location);
        this.alive = true;
    }
    
	protected Field getField() {
		return field;
	}
	protected void setField(Field field) {
		this.field = field;
	}
	protected Location getLocation() {
		return location;
	}
	protected void setLocation(Location newLocation) {
		if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
	}
	public void setAlive(boolean b) {
		this.alive = alive;
	}
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }
        

	/**
     * Make this organism act - that is: make it do
     * whatever it wants/needs to do.
     * @param newOrganism A list to receive newly born animals.
     */
    abstract public void act(List<Organism> newOrganism);

	
    
}
