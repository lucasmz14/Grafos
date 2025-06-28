import java.util.LinkedList;
import java.util.List;

public class AdjacencyListIntDigraph implements IntGraph{
private int V;
    private int E;
    private List<Integer>[] adj;


    public AdjacencyListIntDigraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }

        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];

        for(int v = 0 ; v < V ; v++){
            adj[v] = new LinkedList<Integer>();
        }

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
        adj[v].add(w);
    }

    @Override
    public List<Integer> adj(int v) {
        if(0 > v ||  v >= V){
            throw new IllegalArgumentException();
        }

        return adj[v];
    }
}
