package ru.yakimov.Lesson;

public class Vertex {

    private final String label;
    private boolean visited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return visited;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertex)
            return this.label.equals((((Vertex) obj).label));
        return false;
    }
}
