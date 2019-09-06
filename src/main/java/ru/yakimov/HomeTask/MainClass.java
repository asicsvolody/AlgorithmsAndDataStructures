package ru.yakimov.HomeTask;

public class MainClass {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(10);
        navigator.addTowns("Moscow"
                , "Saransk"
                , "Voronezh"
                , "Ryazan"
                , "Tambov"
                , "Yaroslavl"
                , "Piter"
                , "Saratov"
                , "Perm"
                , "Kirov"
        );
        navigator.addEdge("Moscow","Piter", 20);
        navigator.addEdge("Moscow","Ryazan", 40);
        navigator.addEdge("Moscow","Perm", 30);
        navigator.addEdge("Yaroslavl","Voronezh", 40);

        navigator.addEdge("Saransk","Voronezh", 80);
        navigator.addEdge("Saratov","Voronezh", 45);
        navigator.addEdge("Ryazan","Saransk", 60);

        navigator.addEdge("Piter","Tambov", 40);
        navigator.addEdge("Tambov","Yaroslavl", 35);
        navigator.addEdge("Perm","Kirov", 70);
        navigator.addEdge("Kirov","Saratov", 10);


        navigator
                .getShortestTrip("Moscow","Voronezh")
                .display();


    }
}
