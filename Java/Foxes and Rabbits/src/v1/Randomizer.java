package v1;

import java.util.Random;

/**
 * Provide control over the randomization of the simulation.
 * 
 * @author David Yeager and Keenan McElwee
 * @version 2016.06.26
 */
public class Randomizer
{
    // The default seed for control of randomization.
    private static int seed;
    // A shared Random object, if required.
    private static Random rand = new Random(seed);
    // Determine whether a shared random generator is to be provided.
    private static final boolean useShared = true;

    /**
     * Constructor for objects of class Randomizer
     */
    public Randomizer(int seed)
    {
    	Randomizer.seed = seed;
    	rand = new Random(seed);
    }

    /**
     * Provide a random generator.
     * @return A random object.
     */
    public static Random getRandom()
    {
        if(useShared) {
            return rand;
        }
        else {
            return new Random();
        }
    }
    
    /**
     * Reset the randomization.
     * This will have no effect if randomization is not through
     * a shared Random generator.
     */
    public static void reset()
    {
        if(useShared) {
            rand.setSeed(seed);
        }
    }
}
