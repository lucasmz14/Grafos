import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedIntDigraph implements EdgeGraph{
    private final int V;
    private int E;
    private List<WeightedEdge>[] adj;


    public EdgeWeightedIntDigraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V ; i++){
            adj[i] = new LinkedList<WeightedEdge>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }


    public void addEdge(WeightedEdge e){
        if(e.from < 0 || e.from >= V){
            throw new IllegalArgumentException();
        }
        if(e.to < 0 || e.to >= V){
            throw new IllegalArgumentException();
        }
        adj[e.from].add(e);
        E++;
    }

    public List<WeightedEdge> adj(int v){
        if(v < 0 || v > V){
            throw new IllegalArgumentException();
        }

        return adj[v];
    }
}
