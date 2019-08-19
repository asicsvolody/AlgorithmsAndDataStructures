package ru.yakimov;


import ru.yakimov.BidirectionalList.BidirectionalListImpl;

import java.sql.SQLOutput;
import java.util.Iterator;

public class LinkedIteratorApp {

    public static void main(String[] args) {
        BidirectionalListImpl<Integer> brl = new BidirectionalListImpl<>();
        brl.insertFirst(1);
        brl.insertFirst(2);
        brl.insertFirst(3);
        brl.insertFirst(4);

        System.out.println("Check remove, hasNext, next");

        brl.display();

        Iterator<Integer> iterator = brl.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i == 3)
                iterator.remove();
        }

        brl.display();

        System.out.println("Check foreach");

        for (Integer integer : brl) {
            System.out.println(integer);
        }

        brl.forEach(System.out::println);
    }
}
