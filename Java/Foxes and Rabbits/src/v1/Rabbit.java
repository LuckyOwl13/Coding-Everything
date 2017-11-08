package v1;

import java.util.List;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David Yeager and Keenan McElwee
 * @version 2016.06.26
 */
public class Rabbit extends Animal
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    
    // If the rabbit has been poisoned by a PoisonPlants
    private boolean isPoisoned;
    

    /**
     * Create a new Rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        super.setAge(0);
        super.setBreedingAge(BREEDING_AGE);
        if(randomAge) {
        	super.setAge(rand.nextInt(MAX_AGE));
        }
        isPoisoned = false;
    }
    
    public boolean isPoisoned() {
		return isPoisoned;
	}
	public void poisoned() {
		this.isPoisoned = true;
	}

	/**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    @Override
    public void act(List<Organism> newRabbits)
    {
        incrementAge();
        if(isAlive()) {
            super.giveBirth(newRabbits);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Increase the age.
     * This could result in the rabbit's death.
     */
    protected int getMaxAge()
    {
 	   return MAX_AGE;
    }
    protected int getMaxLitterSize()
    {
 	   return MAX_LITTER_SIZE;
    }
    protected double getBreedingProbability()
    {
 	   return BREEDING_PROBABILITY;
    }
   
}
