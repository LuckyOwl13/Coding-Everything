
public class BagLayer {
    private int numItems;
    private double weight;

    public BagLayer(int numItems, double weight) {
        this.numItems = numItems;
        this.weight = weight;
    }	// end constructor

    public int getNumItems() {
        return numItems;
    }	// end getNumItems

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }	// end setNumItems

    public double getWeight() {
        return weight;
    }	// end getWeight

    public void setWeight(double weight) {
        this.weight = weight;
    }	// end setWeight

    public String toString() {
        return numItems + " items weighing " + weight + " lbs each";
    }	// end toString
}
