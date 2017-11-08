package v1;

import java.util.Iterator;
import java.util.List;

public class PoisonPlant extends Organism
{
	private static boolean alive = true; 
	
	public PoisonPlant(Field field, Location location)
    {
        super(field, location);
    }
	
	
	
	@Override
	public void act(List<Organism> newOrganism) 
	{
		poison();
	}
	
	private void poison() {
		Field field = getField();
		List<Location> adjacent = field.adjacentLocations(getLocation());
		boolean found = false;
		Iterator<Location> it = adjacent.iterator();
		while (!found && it.hasNext()) {
			Location where = it.next();
			Object animal = field.getObjectAt(where);
			if (animal instanceof Rabbit) {
				Rabbit rabbit = (Rabbit) animal;
				rabbit.poisoned();
				if (rabbit.getAge() < rabbit.getMaxAge() - 10) {
					rabbit.setAge(rabbit.getMaxAge()-10);
					found = true;
				}
				else if(rabbit.getAge() > rabbit.getMaxAge() - 10 && rabbit.getAge() < rabbit.getMaxAge() - 5 ) {
					rabbit.setAge(rabbit.getMaxAge() - 2);
					found = true;
				}
				else {
					rabbit.setDead();
					found = true;
				}
					
			}
		}
	}
	
	
	
	
	
}
