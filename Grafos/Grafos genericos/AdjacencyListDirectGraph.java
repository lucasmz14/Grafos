import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AdjacencyListDirectGraph <T extends Comparable<? super T>> implements  Graph<T>{
    private TreeMap<T, Integer> map;
    private T[] keys;
    private List<Integer>[] adj;
    private int V;
    private int E;

    public AdjacencyListDirectGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        V = 0;
        map = new TreeMap<>();
        keys = (T[]) new Comparable[v];
        adj = new LinkedList[v];
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
        map.put(v,vid);
        keys[vid] = v;
        adj[vid] = new LinkedList<>();
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
        if(!containsVertex(v)){
            throw new IllegalArgumentException();
        }
        adj[indexOf(v)].add(indexOf(w));
    }
    
    public String toString(){
        String res = "";

        for(int i = 0 ; i < V();i++){
            res += nameOf(i).toString() + ": ";
            for(int e : adj[i]){
                res += nameOf(e).toString() +" ";
            }
            res += '\n';
        }

        return res;
    }

}