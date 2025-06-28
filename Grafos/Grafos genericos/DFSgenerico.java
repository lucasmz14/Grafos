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
        recorrido = new ArrayList<>();
        dfs(G , G.indexOf(s));
    }


    private void dfs(AdjacencyListGraph<T> G,int v){
        marked[v] = true;
        count++;
        recorrido.add(G.nameOf(v));
        for(int i : G.indexVerticesAdjacentes(v)){
            if(!marked[i]){
                edgeTo[i] = v;
                dfs(G , i);
            }
        }
    }

    public boolean isConexo(){
        return (count == G.V());
    }

     public List<T> getRecorrido(){
        return recorrido;
    }

    public static void main(String[] args) {
     // Crear un grafo con 5 vértices
    AdjacencyListGraph<String> grafo = new AdjacencyListGraph<>(5);

    // Agregar vértices
    grafo.addVertex("A");
    grafo.addVertex("B");
    grafo.addVertex("C");
    grafo.addVertex("D");
    grafo.addVertex("E");

    // Agregar aristas
    grafo.addEdge("A", "B");
    grafo.addEdge("B", "D");
    grafo.addEdge("A", "C");
    grafo.addEdge("C", "E");

    // Ejecutar DFS desde "A"
    DFSgenerico<String> dfs = new DFSgenerico<>(grafo, "A");

    // Mostrar recorrido DFS
    System.out.println("Recorrido DFS desde 'A':");
    for (Comparable i : dfs.getRecorrido()) {
        System.out.println(i.toString());
    }

    // Verificar si el grafo es conexo
    System.out.println("¿Es conexo? " + dfs.isConexo());
    }
}
