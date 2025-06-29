import java.util.LinkedList;
import java.util.List;

public class AdjacentMatrixIntGraph implements IntGraph{
   private int V;
    private int E;
    private int[][]  adj;


    public AdjacentMatrixIntGraph(int v){
        V = v;
        adj = new int[v][v];
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
    public void addEdge(int v, int w) {
       if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
        if(w < 0 || w >= V){
            throw new IllegalArgumentException();
        }
        if(adj[v][w] != 1 && adj[w][v] != 1){
            adj[v][w] = 1;
            adj[w][v] = 1;
            E++;
        }
    }

    @Override
    public List<Integer> adj(int v) {
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
        List<Integer> aux = new LinkedList<>();

        for(int i  = 0 ; i < V; i++){
            if(adj[v][i] == 1){
                aux.add(i);
            }
        }
        return aux;
    }
    
    public static void main(String[] args) {
        // Crear un grafo con 5 vértices
        AdjacentMatrixIntGraph grafo = new AdjacentMatrixIntGraph(5);

        // Agregar algunas aristas
        grafo.addEdge(0, 1);
        grafo.addEdge(0, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(3, 4);

        // Imprimir las listas de adyacencia
        for (int v = 0; v < grafo.V(); v++) {
            System.out.print("Adyacentes a " + v + ": ");
            for (int w : grafo.adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }

        // Imprimir cantidad de vértices y aristas
        System.out.println("Cantidad de vértices: " + grafo.V());
        System.out.println("Cantidad de aristas: " + grafo.E());
    }
}
