package ru.yakimov;


import ru.yakimov.BidirectionalList.BidirectionalListImpl;
import ru.yakimov.LinkedList.LinkedList;
import ru.yakimov.LinkedList.LinkedListImpl;

import java.util.Iterator;

public class LinkedIteratorApp {

    public static void main(String[] args) {
        System.out.println("Check BidirectionalListImpl");
        checkBidirectionalListImplIterator(getBidirectionalListImpl());

        System.out.println("Check LinkedListImpl");
        checkBidirectionalListImplIterator(getLinkedListImpl());
    }

    private static <T extends LinkedList<Integer>> void checkBidirectionalListImplIterator(T collection) {

        System.out.println("Check remove, hasNext and next");

        collection.display();

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            var i = iterator.next();
            if(i.equals(3))
                iterator.remove();
        }

        collection.display();

        System.out.println("Check foreach cycle");

        for (var i : collection) {
            System.out.println(i);
        }

        System.out.println("Check foreach method");

        collection.forEach(System.out::println);

        System.out.println("Check foreachRemaining iterators method");

        collection.iterator().forEachRemaining(System.out::println);
    }

    private static BidirectionalListImpl<Integer> getBidirectionalListImpl() {
        BidirectionalListImpl<Integer> brl = new BidirectionalListImpl<>();
        addTestValues(brl,4,3,2,1);
        return brl;
    }

    private static LinkedListImpl<Integer> getLinkedListImpl() {
        LinkedListImpl<Integer> lli = new LinkedListImpl<>();
        addTestValues(lli,1,2,3,4);
        return lli;
    }

    private static <T extends LinkedList<Integer>> void addTestValues(T collection, int ... numbArr){
        for (var i : numbArr) {
            collection.insertFirst(i);
        }
    }
}
