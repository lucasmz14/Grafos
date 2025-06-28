import java.security.Key;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AdjacencyListWeightedDigraph <T extends Comparable<? super T>> implements WeightedDigraph<T>{
    private int V;
    private int E;
    private TreeMap<T , Integer> map;
    private T[] keys;
    private List<DirectedEdgeL<T>>[] adj;



    public AdjacencyListWeightedDigraph(int V){
        if(V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        map = new TreeMap<>();
        keys = (T[]) new Comparable[V];
        adj = new LinkedList[V];
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
        adj[vid] = new LinkedList<DirectedEdgeL<T>>();
    }
    @Override
    public boolean containsVertex(T v) {
        return map.containsKey(v);
    }
    @Override
    public void addEdge(T from, T to, double weight) {
        if(!containsVertex(from)){
            throw new IllegalArgumentException();
        }
        if(!containsVertex(to)){
            throw new IllegalArgumentException();
        }
        DirectedEdgeL<T> aux = new DirectedEdgeL<>(from, to, weight);
        adj[indexOf(from)].add(aux);
    }

    @Override
    public T nameOf(int v) {
        return keys[v];
    }
    @Override
    public int indexOf(T v) {
        return map.get(v);
    }

    
    
}
