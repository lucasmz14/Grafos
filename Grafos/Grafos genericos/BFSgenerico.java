import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.border.LineBorder;

public class BFSgenerico<T extends Comparable<? super T>> {
    private boolean[] marked;
    private int[] edgeTo;
    private T s;
    private AdjacencyListGraph G;
    private List<T> recorrido;

    public BFSgenerico(AdjacencyListGraph<T> G, T s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        this.G = G;
        recorrido = new ArrayList<>();
        bfs(G,G.indexOf(s));
    }


    private void bfs(AdjacencyListGraph<T> G,int s){
        Queue<Integer> cola = new LinkedList<>();
        marked[s] = true;
        cola.add(s);
        while(!cola.isEmpty()){
            int v = cola.poll();
            for(int e : G.indexVerticesAdjacentes(v)){
                if(!marked[e]){
                    marked[e] = true;
                    edgeTo[e] = v;
                    cola.add(e);
                }
            }

        }
    }

    public boolean hashTo(T v){
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

        // Agregar aristas
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "E");

        // Crear BFS desde A
        BFSgenerico<String> bfs = new BFSgenerico<>(grafo, "A");

        // Mostrar si hay camino y cuál es el camino desde A hasta E
        System.out.println("¿Hay camino desde A hasta E? " + bfs.hashTo("E"));

        System.out.print("Camino más corto desde A hasta E: ");
        List<Comparable> camino = bfs.pathTo("E");
        for (Comparable nodo : camino) {
            System.out.print(nodo + " ");
        }
    }
    
}