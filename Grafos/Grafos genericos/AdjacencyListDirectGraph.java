import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AdjacencyListDirectGraph <T extends Comparable<? super T>> implements  Graph<T>{
    private int V;
    private int E;
    private TreeMap<T, Integer> map;
    private T[] keys;
    private List<Integer>[] adj;


    public AdjacencyListDirectGraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.E = 0;
        this.V = 0;
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

    public T nameOf(int v) {
        return keys[v];
    }

    public int indexOf(T s){
        return map.get(s);
    }

    @Override
    public void addVertex(T v) {
        if(containsVertex(v)){
            throw new IllegalArgumentException();
        }
        int vid = V++;
        map.put(v, vid);
        keys[vid] = v;
        adj[vid] = new LinkedList<>(); 
    }

    @Override
    public boolean containsVertex(T v) {
        return map.containsKey(v);
    }

    public List<Integer> indexVerticesAdjacentes(int s){
        List<Integer> l = new LinkedList<>();
        l.addAll(adj[s]);
        return l;
    }


    @Override
    public void addEdge(T v, T w) {
       if(!containsVertex(v)){
            throw new IllegalArgumentException();
        }
        if(!containsVertex(w)){
            throw new IllegalArgumentException();
        }
        E++;
        int aux = map.get(v);
        adj[aux].add(indexOf(w));
    }

    
    public String toString(){
        String res = "";

        for(int i = 0 ; i < V; i++){
            res += nameOf(i).toString()+ ": ";
            for(int t : adj[i]){
                res += nameOf(t).toString() + " ";
            }

            res += '\n';
        }
        return res;
    }

}
