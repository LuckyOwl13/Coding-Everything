package v1;

import java.util.List;
import java.util.Iterator;

/**
 * A simple model of a fox. Foxes age, move, eat rabbits, and die.
 * 
 * @author David Yeager and Keenan McElwee
 * @version 2016.06.26
 */
public class Fox extends Animal {
	// Characteristics shared by all foxes (class variables).

	// The age at which a fox can start to breed.
	private static final int BREEDING_AGE = 15;
	// The age to which a fox can live.
	private static final int MAX_AGE = 150;
	// The likelihood of a fox breeding.
	private static final double BREEDING_PROBABILITY = 0.08;
	// The maximum number of births.
	private static final int MAX_LITTER_SIZE = 2;
	// The food value of a single rabbit. In effect, this is the
	// number of steps a fox can go before it has to eat again.
	private static final int RABBIT_FOOD_VALUE = 9;
    
    // If the fox has been poisoned by a poisoned rabbit
    private boolean isPoisoned;


	// The fox's food level, which is increased by eating rabbits.
	private int foodLevel;

	/**
	 * Create a fox. A fox can be created as a new born (age zero and not
	 * hungry) or with a random age and food level.
	 * 
	 * @param randomAge
	 *            If true, the fox will have random age and hunger level.
	 * @param field
	 *            The field currently occupied.
	 * @param location
	 *            The location within the field.
	 */
	public Fox(boolean randomAge, Field field, Location location) {
		super(field, location);
		super.setBreedingAge(BREEDING_AGE);
		this.isPoisoned = false;
		if (randomAge) {
			super.setAge(rand.nextInt(MAX_AGE));
			foodLevel = rand.nextInt(RABBIT_FOOD_VALUE);
		} else {
			super.setAge(0);
			foodLevel = RABBIT_FOOD_VALUE;
		}
	}
	
	private void poisoned(){
		this.isPoisoned = true;
	}

	/**
	 * This is what the fox does most of the time: it hunts for rabbits. In the
	 * process, it might breed, die of hunger, or die of old age.
	 * 
	 * @param field
	 *            The field currently occupied.
	 * @param newFoxes
	 *            A list to return newly born foxes.
	 */
	@Override
	public void act(List<Organism> newFoxes) {
		incrementHunger();
		incrementAge();
		if (isAlive()) {
			super.giveBirth(newFoxes);
			// Move towards a source of food if found.
			Location newLocation = findFood();
			if (isAlive()) {
				if (newLocation == null) {
					// No food found - try to move to a free location.
					newLocation = getField().freeAdjacentLocation(getLocation());
				}
				// See if it was possible to move.
				if (newLocation != null) {
					setLocation(newLocation);
				} else {
					// Overcrowding.
					setDead();
				}
			}
		}
	}

	protected int getMaxAge() {
		return MAX_AGE;
	}

	protected int getMaxLitterSize() {
		return MAX_LITTER_SIZE;
	}

	protected double getBreedingProbability() {
		return BREEDING_PROBABILITY;
	}

	/**
	 * Make this fox more hungry. This could result in the fox's death.
	 */
	private void incrementHunger() {
		foodLevel--;
		if (foodLevel <= 0) {
			setDead();
		}
	}

	/**
	 * Look for rabbits adjacent to the current location. Only the first live
	 * rabbit is eaten.
	 * 
	 * @return Where food was found, or null if it wasn't.
	 */
	private Location findFood() {
		Field field = getField();
		List<Location> adjacent = field.adjacentLocations(getLocation());
		Iterator<Location> it = adjacent.iterator();
		while (it.hasNext()) {
			Location where = it.next();
			Object animal = field.getObjectAt(where);
			if (animal instanceof Rabbit) {
				Rabbit rabbit = (Rabbit) animal;
				if (rabbit.isAlive()) {
					if (rabbit.isPoisoned() && !isPoisoned){
						setAge(getMaxAge() - 5);
						isPoisoned = true;
					}
					else if (rabbit.isPoisoned() && isPoisoned){
						setDead();
					}
					rabbit.setDead();
					foodLevel = RABBIT_FOOD_VALUE;
					return where;
				}
			}
		}
		return null;
	}

}
