

public abstract class AnimalFactory {
	
	
	public static Animal createNewAnimal(String animalName,Field field,Location loc)
	{
		Animal anim = null;
		if (animalName.equals("Rabbit"))
		{
			anim = new Rabbit(false, field, loc);
		}
		else if (animalName.equals("Fox"))
		{
			anim = new Fox(false, field, loc);
		}
		return anim;
	}
}
