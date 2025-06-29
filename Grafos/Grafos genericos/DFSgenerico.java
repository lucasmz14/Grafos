import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.Line;

public class DFSgenerico<T extends Comparable<? super T>> {
    private boolean[] marked;
    private Boolean isConexo;
    private int count;
    private int[] edgeTo;
    private AdjacencyListGraph G;
    private T s;
    private List<T> recorrido;

    public DFSgenerico(AdjacencyListGraph<T> G, T s){
        this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,G.indexOf(s));
    }


    private void dfs(AdjacencyListGraph<T> G,int v){
        marked[v] = true;
        count++;
        for(int e : G.indexVerticesAdjacentes(v)){
            if(!marked[e]){
                edgeTo[e] = v;
                dfs(G, e);
            }
        }
    }

    public boolean isConexo(){
        return (count == G.V());
    }


    public Boolean hashTo(T v){
        return marked[G.indexOf(v)];
    }


    public List<Comparable> pathTo(T v){
        if(!hashTo(v)){
            throw new IllegalArgumentException();
        }

        List<Comparable> aux = new LinkedList<>();

        for(int i = G.indexOf(v) ; i != G.indexOf(s); i = edgeTo[i]){
            aux.addFirst(G.nameOf(i));
        }

        aux.addFirst(s);

        return aux;
    }



public static void main(String[] args) {
        // Crear grafo con vértices tipo String
        AdjacencyListGraph<String> grafo = new AdjacencyListGraph<String>(5);

        // Agregar vértices
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        grafo.addVertex("D");
        grafo.addVertex("E");

        // Agregar aristas (grafo no dirigido)
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "E");

        // Ejecutar DFS desde "A"
        DFSgenerico<String> dfs = new DFSgenerico<>(grafo, "A");

        // Probar conexión y camino a "E"
        System.out.println("¿El grafo es conexo? " + dfs.isConexo());
        System.out.println("¿Hay camino de A a E?: " + dfs.hashTo("E"));
        System.out.print("Camino de A a E (por índices): ");
        System.out.println(dfs.pathTo("E"));
    }
}
