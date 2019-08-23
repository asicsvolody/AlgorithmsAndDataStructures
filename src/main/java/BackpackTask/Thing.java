package BackpackTask;

public class Thing {
    private String thingName;
    private int weight;
    private int price;

    public Thing(String thingName, int weight, int price) {
        this.thingName = thingName;
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return thingName;
    }
}
