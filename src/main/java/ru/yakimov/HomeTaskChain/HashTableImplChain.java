package ru.yakimov.HomeTaskChain;

import ru.yakimov.Lesson.HashTable;

public class HashTableImplChain<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node<K,V> nextNode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private Node<K, V>[] data;
    private int size;
    private int countOfCells;


    @SuppressWarnings("unchecked")
    public HashTableImplChain(int countOfCells) {
        this.countOfCells = countOfCells;
        this.data = new Node[countOfCells * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }


    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Node<K,V> newNode = new Node<>(key, value);

        if(data[index] == null) {
            data[index] = newNode;
        }else{
            newNode.setNextNode(data[index]);
            data[index] = newNode;
        }
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Node<K, V> myNode = data[index];
        while(myNode != null) {
            if (myNode.getKey().equals(key))
                return myNode.getValue();
            myNode = myNode.getNextNode();
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        Node<K,V> myNode = data[index];

        if(myNode == null) {
            return null;
        }

        if(myNode.getKey().equals(key)) {
            data[index] = myNode.getNextNode();
            size--;
            return myNode.getValue();
        }

        Node<K, V> resNode;
        while(myNode.getNextNode() != null){
            if(myNode.getNextNode().getKey().equals(key)){
                resNode = myNode.nextNode;
                myNode.setNextNode(resNode.nextNode);
                size--;
                return resNode.getValue();
            }
            myNode = myNode.nextNode;
        }
        return null;
    }


    @Override
    public void display() {

        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            printNodeList(i);
        }
        System.out.println("-----------");
    }

    private void printNodeList(int i) {

        Node<K,V> myNode = data[i];
        System.out.printf("%d = [%s]", i,myNode);
        while (myNode != null && myNode.nextNode != null){
            myNode = myNode.getNextNode();
            System.out.print(" --> "+ myNode);
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}