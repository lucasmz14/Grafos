import java.util.LinkedList;
import java.util.List;

public class AdjacentMatrixIntGraph implements IntGraph{
    private int V;
    private int E;
    private int[][] matriz;


    public AdjacentMatrixIntGraph(int V){
        this.V = V;
        E = 0;
        matriz = new int[V][V];
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
        if(0 > v ||  v >= V){
            throw new IllegalArgumentException();
        }

        if(0 > w ||  w >= V){
            throw new IllegalArgumentException();
        }
        E++;
        matriz[v][w] = 1;
        matriz[w][v] = 1;
    }

    @Override
    public List<Integer> adj(int v) {
        if(0 > v ||  v >= V){
            throw new IllegalArgumentException();
        }
        List<Integer> aux = new LinkedList<>();

        for(int i = 0 ; i < V ; i++){
           if(matriz[v][i] == 1){
            aux.add(matriz[v][i]);
            }
        }
        return aux;
    }
    
}
