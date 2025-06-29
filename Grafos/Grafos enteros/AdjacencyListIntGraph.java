import java.util.LinkedList;
import java.util.List;

public class AdjacencyListIntGraph implements IntGraph{
    private int V;
    private int E;
    private List<Integer>[] adj;


    public AdjacencyListIntGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        this.V = v;
        adj = new LinkedList[v];

        for(int i = 0 ; i < v ; i++){
            adj[i] = new LinkedList<Integer>();
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
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
        if(w < 0 || w >= V){
            throw new IllegalArgumentException();
        }
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    @Override
    public List<Integer> adj(int v) {
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
        return adj[v];
    }

}