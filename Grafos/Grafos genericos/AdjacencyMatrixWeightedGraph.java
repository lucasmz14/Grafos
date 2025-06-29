import java.util.List;
import java.util.TreeMap;

public class AdjacencyMatrixWeightedGraph <T extends Comparable<? super T>> implements WeightedDigraph<T>{
    private int V;
    private int E;
    private TreeMap<T , Integer> map;
    private T[] keys;
    private DirectedEdgeL[][] adj;

    public AdjacencyMatrixWeightedGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        V = 0;
        E = 0;
        map = new TreeMap<>();
        keys = (T[]) new Comparable[v];
        adj = new DirectedEdgeL[v][v];
    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addVertex(T v) {
        if(containsVertex(v)){
            throw new IllegalArgumentException();
        }
        int vid = V++;
        keys[vid] = v;
        map.put(v,vid);
    }

    @Override
    public boolean containsVertex(T v) {
        return map.containsKey(v);
    }

    @Override
    public T nameOf(int v) {
        return keys[v];
    }

    @Override
    public int indexOf(T v) {
        return map.get(v);
    }

    @Override
    public void addEdge(T from, T to, double weight) {
       if(!containsVertex(from)){
            throw new IllegalArgumentException();
        }
        if(!containsVertex(to)){
            throw new IllegalArgumentException();
        }
        DirectedEdgeL aux = new DirectedEdgeL(from, to, weight);
        DirectedEdgeL aux2 = new DirectedEdgeL(to, from, weight);
        adj[indexOf(from)][indexOf(to)] = aux;
        adj[indexOf(to)][indexOf(from)] = aux2;
        E++;
    }
    
}
