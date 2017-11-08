package v1;

import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David Yeager and Keenan McElwee
 * @version 2016.06.26
 */
public abstract class Animal extends Organism
{

    // A shared random number generator to control breeding.
    protected static final Random rand = Randomizer.getRandom();   
    // The animal's age.
    protected int age;
    // The animal's breeding age.
    protected int breedingAge;
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        super(field,location);
    	super.setAlive(true);
    }
    
    public int getAge() {
		return age;
	}
    public void setAge(int age) {
		this.age = age;
	}
    public int getBreedingAge() {
		return breedingAge;
	}
	public void setBreedingAge(int breedingAge) {
		this.breedingAge = breedingAge;
	}
	protected abstract int getMaxAge();
	 /**
     * Increase the age. This could result in the animal's death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }
        
   /**
    * Generate a number representing the number of births,
    * if it can breed.
    * @return The number of births (may be zero).
    */
   protected int breed()
   {
       int births = 0;
       if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
           births = rand.nextInt(getMaxLitterSize()) + 1;
       }
       return births;
   }
   	protected abstract int getMaxLitterSize();
	protected abstract double getBreedingProbability();
	



    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * An animal can breed if it has reached the breeding age.
     */
    protected boolean canBreed()
    {
        return age >= getBreedingAge();
    }

    /**
     * Check whether or not this animal is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newAnimal A list to return newly born animals.
     */
    protected void giveBirth(List<Organism> newOrganisms)
    {
        
    	// New animals are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = AnimalFactory.createNewAnimal(this.getClass().getSimpleName(), field, loc);
            newOrganisms.add(young);
        }
    }
    
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
