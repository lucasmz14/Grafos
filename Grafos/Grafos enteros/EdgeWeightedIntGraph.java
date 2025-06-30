import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedIntGraph  implements EdgeGraph{
    private final int V;
    private int E;
    private List<Edge>[] adj;


    public EdgeWeightedIntGraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V ; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }
    @Override
    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    @Override
    public void addEdge(Edge e){
        if(e.from < 0 || e.from >= V){
            throw new IllegalArgumentException();
        }
        if(e.to < 0 || e.to >= V){
            throw new IllegalArgumentException();
        }
        adj[e.from].add(e);
        adj[e.to].add(e);
        E++;
    }

    @Override
    public List<Edge> adj(int v){
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        return adj[v];
    }
}

