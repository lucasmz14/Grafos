import java.util.LinkedList;
import java.util.List;

public class DFSdirectGraph {
    private boolean[] marked;
    private boolean[] marked2;
    private Boolean isConexo;
    private int count;
    private int count2;
    private int[] edgeTo;
    private AdjacencyListIntDigraph G;
    private AdjacencyListIntDigraph invertido;
    private int s;

    public DFSdirectGraph(AdjacencyListIntDigraph G, int s){
        this.G = G;
        this.s = s;
        invertido = new AdjacencyListIntDigraph(G.V());
        marked = new boolean[G.V()];
        marked2 = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G , s);
    }


    private void dfs(AdjacencyListIntDigraph G,int s){
        marked[s] = true;
        count++;
        for(int i : G.adj(s)){
            if(!marked[i]){
                edgeTo[i] = s;
                dfs(G , i);
            }
        }
    }

    public boolean isConexo(){
        for(int i = 0 ; i < G.V(); i++){
            for(int w : G.adj(i)){
                invertido.addEdge(w, i);
            }
        }

        dfs2(invertido, s);
        return count == count2;
    }
    
    private void dfs2(AdjacencyListIntDigraph G,int s){
        marked2[s] = true;
        count2++;
        for(int i : invertido.adj(s)){
            if(!marked2[i]){
                dfs2(invertido , i);
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
        // Crear un grafo dirigido con 4 nodos (0, 1, 2, 3)
        AdjacencyListIntDigraph grafo = new AdjacencyListIntDigraph(4);

// Crea un ciclo fuerte entre todos los nodos:
    grafo.addEdge(0, 1);
    grafo.addEdge(1, 2);
    grafo.addEdge(2, 3);
    grafo.addEdge(3, 0); // Cierra el ciclo

        // Crear el DFS
        DFSdirectGraph dfs = new DFSdirectGraph(grafo, 0);

        // Imprimir si el grafo es conexo (fuertemente conexo en tu lógica)
        System.out.println("¿Es fuertemente conexo desde 0?: " + dfs.isConexo());

        // Ver camino desde 0 a 3
        System.out.println("Camino de 0 a 3:");
        List<Integer> camino = dfs.pathTo(3);
        if (camino != null) {
            for (int nodo : camino) {
                System.out.print(nodo + " ");
            }
        } else {
            System.out.println("No hay camino.");
        }
    }

}
