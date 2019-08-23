package BackpackTask;

import java.util.ArrayList;

public class Backpack{

    private final int MAX_WEIGHT = 15;
    private final int PRICE_IF_FREE = 0;
    private int weight;
    private int totalPrice;
    private ArrayList <Thing> thingsIncite;

    public Backpack() {
        this.weight = MAX_WEIGHT;
        this.totalPrice = PRICE_IF_FREE;
        thingsIncite = new ArrayList<>();
    }

    public boolean addToBackpack(Thing thing){
        if(this.weight - thing.getWeight() < 0)
            return false;
        this.weight -= thing.getWeight();
        this.totalPrice += thing.getPrice();
        this.thingsIncite.add(thing);
        return true;
    }

    public void display(){
        System.out.println("Things in backpack:");
        System.out.println();
        for (Thing thing : thingsIncite) {
            System.out.println(thing.getName());
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
