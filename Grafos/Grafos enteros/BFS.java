import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private AdjacencyListIntGraph G;

    public BFS(AdjacencyListIntGraph G, int s){
       this.G = G;
       this.s = s;
       edgeTo = new int[G.V()];
       marked = new boolean[G.V()];
       bfs(G,s);
    }


    private void bfs(AdjacencyListIntGraph G,int s){
        Queue<Integer> cola = new LinkedList<>();
        marked[s] = true;
        cola.add(s);
        while(!cola.isEmpty()){
            int v = cola.poll();
            for(int e : G.adj(v)){
                if(!marked[e]){
                    marked[e] = true;
                    edgeTo[e] = v;
                    cola.add(e);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }


    public List<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        List<Integer> aux = new LinkedList<>();

        for(int i = v ; i != s ; i = edgeTo[i]){
            aux.addFirst(i);
        }
        aux.addFirst(s);
        return aux;
    }

    public static void main(String[] args) {
        // Crear un grafo no dirigido con 6 vértices
        AdjacencyListIntGraph grafo = new AdjacencyListIntGraph(6);

        // Agregar aristas
        grafo.addEdge(0, 1);
        grafo.addEdge(0, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);
        grafo.addEdge(4, 5);

        // Crear BFS desde el nodo 0
        BFS bfs = new BFS(grafo, 0);

        // Mostrar caminos desde 0 hacia todos los vértices
        for (int v = 0; v < grafo.V(); v++) {
            System.out.print("Camino más corto desde 0 hasta " + v + ": ");
            if (bfs.hasPathTo(v)) {
                List<Integer> camino = bfs.pathTo(v);
                for (int nodo : camino) {
                    System.out.print(nodo + " ");
                }
                System.out.println();
            } else {
                System.out.println("No hay camino.");
            }
        }
    }
    
}

