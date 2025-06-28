import java.util.List;

public interface WeightedDigraph<T extends Comparable<? super T>> {

    public int V();

    public int E();
    
    public void addVertex(T v);

    public boolean containsVertex(T v);
    
    public T nameOf(int v);

    public int indexOf(T v);

    public void addEdge(T from, T to, double weight);

}

