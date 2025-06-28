import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedIntGraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;


    public EdgeWeightedIntGraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V ; i++){
            adj[i] = new LinkedList<DirectedEdge>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }


    public void addEdge(DirectedEdge e){
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

    public List<DirectedEdge> adj(int v){
        if(v < 0 || v > V){
            throw new IllegalArgumentException();
        }

        return adj[v];
    }
}

