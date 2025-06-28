import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<Integer> q = new LinkedList<>();
        marked[s] = true;
        q.add(s);
        recorrido.add(G.nameOf(s));

        while(!q.isEmpty()){
             int v = q.remove();

             for(int w : G.indexVerticesAdjacentes(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                    recorrido.add(G.nameOf(w));
                }

             }

        }

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
    grafo.addEdge("B", "C");
    grafo.addEdge("A", "E");

    // Ejecutar DFS desde "A"
    BFSgenerico<String> bfs = new BFSgenerico<>(grafo, "D");

     System.out.println("Recorrido DFS desde 'a':");
         for (Comparable i : bfs.getRecorrido()) {
            System.out.println(i.toString());
        }
    }
}