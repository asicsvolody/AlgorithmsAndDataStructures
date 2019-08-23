package BackpackTask;

public class BackpackTask {

    private Thing[] thingsArr;
    private Backpack bestBackpack;



    public BackpackTask() {
        bestBackpack = new Backpack();

        getBestBackpack(new Thing("Book",5, 600),
                new Thing("Binoculars", 4, 5000),
                new Thing("Medicine chest", 4, 1500),
                new Thing("MacBook", 3, 40000),
                new Thing("bowler", 5,500));
        bestBackpack.display();
    }

    private void getBestBackpack(Thing ... things) {
        if(things.length == 1) {
            bestBackpack.addToBackpack(things[things.length-1]);
        }

        thingsArr = things;

        determineBestCombination(things.length);
    }

    private void determineBestCombination(int length) {
        if(length ==1)
            return;
        for (int i = 0; i < length; i++) {
            determineBestCombination(length-1);
            addThingsToBackPack();
            rotate(length);
        }
    }

    private void addThingsToBackPack() {
        Backpack backpack = new Backpack();
        for (Thing thing : thingsArr) {
            if(!backpack.addToBackpack(thing)) {
                comparisonWithBest(backpack);
                return;
            }
        }
    }

    private void comparisonWithBest(Backpack backpack) {
        if(backpack.getTotalPrice() > bestBackpack.getTotalPrice())
            bestBackpack = backpack;
    }

    private void rotate(int length){
        int pos = thingsArr.length - length;
        Thing temp = thingsArr[pos];
        for (int i = pos + 1 ; i < thingsArr.length ; i++) {
            thingsArr[i-1] = thingsArr[i];
        }
        thingsArr[thingsArr.length-1] = temp;
    }

    public static void main(String[] args) {
        new BackpackTask();
    }
}
