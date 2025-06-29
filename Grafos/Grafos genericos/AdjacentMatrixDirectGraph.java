import java.util.TreeMap;

public class AdjacentMatrixDirectGraph <T extends Comparable<? super T>> implements Graph<T> {
    private int V;
    private int E;
    private TreeMap<T, Integer> map;
    private T[] keys;
    private int[][] adj;


    public AdjacentMatrixDirectGraph(int V){
        if(V < 0){
            throw new IllegalArgumentException();
        }
        this.V = 0;
        this.E = 0;
        map = new TreeMap<>();
        keys = (T[]) new Comparable[V];
        adj = new int[V][V];
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
    public T nameOf(int v) {
        return keys[v];
    }

    @Override
    public int indexOf(T v) {
        return map.get(v);
    }

    @Override
    public void addVertex(T v) {
        if(containsVertex(v)){
            throw new IllegalArgumentException();
        }
        int vid = V++;
        keys[vid] = v;
        map.put(v, vid);
    }

    @Override
    public boolean containsVertex(T v) {
       return map.containsKey(v);
    }

    @Override
    public void addEdge(T v, T w) {
        if(!containsVertex(v)){
            throw new IllegalArgumentException();
        }
        if(!containsVertex(w)){
            throw new IllegalArgumentException();
        }
        if(adj[indexOf(v)][indexOf(w)] != 1){
            adj[indexOf(v)][indexOf(w)] = 1;
            E++;
        }else{
            System.out.println("La aristas al Nodo " + v + " al nodo " + w + " ya existe");
        }
    }
    
}

