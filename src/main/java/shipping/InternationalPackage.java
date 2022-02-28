package shipping;



public class InternationalPackage implements Transportable {

    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        int priceBasedOnDistance = distance*10;
        return breakable ? 1200*2 + priceBasedOnDistance : 1200 + priceBasedOnDistance;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

}
