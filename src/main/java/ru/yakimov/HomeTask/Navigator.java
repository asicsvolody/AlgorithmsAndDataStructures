package ru.yakimov.HomeTask;

import ru.yakimov.Lesson.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Navigator {

    private final List<Vertex> vertexList;
    private final Edge[][] adjMat;

    private int size;

    public Navigator(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new Edge[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addTowns(String ...labels) {
        for (String label : labels) {
            vertexList.add(new Vertex(label));
            size++;
        }
    }


    public void addEdge(String startLabel, String finishLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid vertex labels");
        }

        adjMat[startIndex][finishIndex] = new Edge(distance);
        adjMat[finishIndex][startIndex] = new Edge(distance);
    }

    private int indexOf(String startLabel) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(startLabel)) {
                return i;
            }
        }

        return -1;
    }

    public ShortestWay getShortestTrip(String startTown, String finishTown) throws CloneNotSupportedException {
//        int startIndex = indexOf(startTown);
//        int finishIndex = indexOf(finishTown);
//
//        ShortestWay resWay = new ShortestWay();
//
//        if (startIndex == -1  ) {
//            throw new IllegalArgumentException("There is`t town : " + startTown);
//        }
//
//        if (finishIndex == -1 ) {
//            throw new IllegalArgumentException("There is`t town : " + finishTown);
//        }
//
//        Stack<Vertex> vertexStack = new Stack<>();
//        Stack<Edge> edgeStack = new Stack<>();
//
//        Vertex vertex = vertexList.get(startIndex);
//        int indexBefore = startIndex;
//
//        ShortestWay newWay = new ShortestWay();
//
//        visitVertex(vertexStack, vertex);
//        newWay.addTown(vertex);
//
//        while (!vertexStack.isEmpty()) {
//            vertex = getNearUnvisitedVertex(vertexStack.peek());
//
//            if (vertex != null) {
//                goTrip(indexBefore,vertex,edgeStack);
//                newWay.addTrip(edgeStack.peek());
//                visitVertex(vertexStack, vertex);
//                newWay.addTown(vertexStack.peek());
//
//                if(indexBefore == startIndex)
//                    vertexList.get(finishIndex).setVisited(false);
//
//                if(indexOf(vertex.getLabel()) == finishIndex){
//                    resWay = (resWay.getDistance() < newWay.getDistance() && resWay.getDistance()!= 0) ? resWay : (ShortestWay) newWay.clone();
//
//                    newWay.removeTrip(edgeStack.pop());
//                    newWay.removeTown(vertexStack.pop());
//                    indexBefore = indexOf(vertexStack.peek().getLabel());
//
//
//                }else{
//                    indexBefore = indexOf(vertex.getLabel());
//
//                }
//            } else {
//                if (indexBefore != startIndex) {
//
//                    newWay.removeTrip(edgeStack.pop());
//                    newWay.removeTown(vertexStack.pop());
//                    indexBefore = indexOf(vertexStack.peek().getLabel());
//
//
//                }else
//                    vertexStack.pop();
//
//            }
//        }
//
//        resetVertexState();
//        return resWay;
    }

    private class TripOptimisator{
        private int startIndex;
        private int finishIndex;
        private ShortestWay resWay;

        Vertex vertex;
        int indexBefore;

        private Stack<Vertex> vertexStack;
        private Stack<Edge> edgeStack ;

        public TripOptimisator(String startTown, String finishTown) {
            this.startIndex = indexOf(startTown);
            this.finishIndex = indexOf(finishTown);
            ShortestWay resWay = new ShortestWay();

            vertexStack = new Stack<>();
            edgeStack = new Stack<>();

            vertex = vertexList.get(startIndex);
            indexBefore = startIndex;

            checkTowns(startTown, finishTown);

            tripAnalysis();

            resetVertexState();

        }

        private void checkTowns(String startTown, String finishTown) {
            if (startIndex == -1  ) {
                throw new IllegalArgumentException("There is`t town : " + startTown);
            }

            if (finishIndex == -1 ) {
                throw new IllegalArgumentException("There is`t town : " + finishTown);
            }
        }

        private void tripAnalysis(){
            ShortestWay newWay = new ShortestWay();

            visitVertex(vertexStack, vertex);
            newWay.addTown(vertex);

            while (!vertexStack.isEmpty()) {
                vertex = getNearUnvisitedVertex(vertexStack.peek());

                if (vertex != null) {

                    stepFront(newWay);

                    if(indexBefore == startIndex)
                        vertexList.get(finishIndex).setVisited(false);

                    if(indexOf(vertex.getLabel()) == finishIndex){
                        compareWays(newWay);

                        stepBack(newWay);


                    }else

                        indexBefore = indexOf(vertex.getLabel());
                } else {
                    if (indexBefore != startIndex)
                        stepBack(newWay);

                    else
                        vertexStack.pop();

                }
            }

        }

        private void stepFront(ShortestWay newWay) {
            goTrip(indexBefore,vertex,edgeStack);
            newWay.addTrip(edgeStack.peek());
            visitVertex(vertexStack, vertex);
            newWay.addTown(vertexStack.peek());
        }

        private void compareWays(ShortestWay newWay) {
            try {
                resWay = (resWay.getDistance() < newWay.getDistance() && resWay.getDistance()!= 0) ? resWay : (ShortestWay) newWay.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        private void stepBack(ShortestWay newWay) {
            newWay.removeTrip(edgeStack.pop());
            newWay.removeTown(vertexStack.pop());
            indexBefore = indexOf(vertexStack.peek().getLabel());
        }

        public ShortestWay getSortestWay() {
            return resWay;
        }
    }


    private void goTrip(int indexBefore, Vertex vertex, Stack<Edge> edgeStack) {
        edgeStack.push(adjMat[indexBefore][indexOf(vertex.getLabel())]);
    }


    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex currentVertex) {
        int currentIndex = vertexList.indexOf(currentVertex);
        for (int i = 0; i < size; i++) {
            if (adjMat[currentIndex][i] != null && !vertexList.get(i).getVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    public class Edge {

        private int distance;

        public Edge(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }

    public class ShortestWay implements Cloneable{
        private int distance;
        private List <Vertex> townList;

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public ShortestWay() {
            this.townList = new LinkedList<>();
        }

        public void addTrip(Edge edge){
            if(edge != null)
                distance += edge.getDistance();
        }

        public void removeTrip(Edge edge){
            if(edge != null)
                distance -= edge.getDistance();

        }

        public void addTown(Vertex town){
            townList.add(town);
        }

        public void removeTown(Vertex town){
            townList.remove(town);
        }


        public int getDistance() {
            return distance;
        }

        public List<Vertex> getTownList() {
            return townList;
        }

        public void display(){
            System.out.println("The shortest trip is:" );
            for (Vertex vertex : townList) {
                System.out.println(vertex.getLabel());
            }
            System.out.println("Distance: "+ distance );
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            ShortestWay cloneWay = new ShortestWay();
            cloneWay.setDistance(distance);
            for (Vertex vertex : townList) {
                cloneWay.addTown(vertex);
            }
            return cloneWay;
        }
    }


}