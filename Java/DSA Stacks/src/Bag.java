
public class Bag {
    private StackRAB<BagLayer> layers;
    private int numLayers;
    private double totWeight;

    public Bag() {
        layers = new StackRAB<BagLayer>();
    }	// end constructor


    public void placeLayer(BagLayer bl) {
        layers.push(bl);
        numLayers++;
        totWeight += bl.getWeight() * bl.getNumItems();
    }	//end placeLayer


    public BagLayer removeLayer() {
        BagLayer remov = layers.pop();

        numLayers--;
        totWeight -= remov.getWeight() * remov.getNumItems();

        return remov;
    }	// end removeLayer


    public StackRAB<BagLayer> getLayers() {
        return layers;
    }	// end getLayers


    public Integer getNumLayers() {
        return numLayers;
    }	// end getNumLayers


    public double getTotWeight() {
        return totWeight;
    }	// end getTotWeight

    public String toString() {
        return "Bag with " + numLayers + " layers "
               + "weighting " + totWeight + " lbs: " + layers.toString();
    }	// end toString


}	// end class
