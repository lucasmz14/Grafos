import java.security.Key;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AdjacencyListWeightedGraph <T extends Comparable<? super T>> implements WeightedDigraph<T>{
    private int V;
    private int E;
    private TreeMap<T , Integer> map;
    private T[] keys;
    private List<DirectedEdgeL<T>>[] adj;



    public AdjacencyListWeightedGraph(int V){
        if(V < 0){
            throw new IllegalArgumentException();
        }
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
        DirectedEdgeL<T> aux2 = new DirectedEdgeL<>(to, from, weight);
        adj[indexOf(from)].add(aux);
        adj[indexOf(to)].add(aux2);
    }

    @Override
    public T nameOf(int v) {
        return keys[v];
    }
    @Override
    public int indexOf(T v) {
        return map.get(v);
    }

    public String toString(){
        String res = "";

        for(int i = 0 ; i < V();i++){
            res += nameOf(i).toString() + ": ";
            for(DirectedEdgeL<T> e : adj[i]){
                res += e.toString() +" ";
            }
            res += '\n';
        }

        return res;
    }
    public static void main(String[] args) {
        // Crear grafo con capacidad inicial para 5 vértices
        AdjacencyListWeightedGraph<String> grafo = new AdjacencyListWeightedGraph<>(5);

        // Agregar vértices
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("D");

        // Agregar aristas (no dirigidas con peso)
        grafo.addEdge("A", "B", 2.5);
        grafo.addEdge("A", "C", 1.0);
        grafo.addEdge("B", "D", 3.2);
        grafo.addEdge("C", "D", 4.7);

        // Imprimir el grafo
        System.out.println(grafo.toString());
    }
}

