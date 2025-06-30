import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedMatrixIntDigraph implements EdgeGraph{
    private final int V;
    private int E;
    private WeightedEdge[][] adj;


    public EdgeWeightedMatrixIntDigraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new WeightedEdge[V][V];
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
        adj[e.from][e.to] = e;
        E++;
    }

    public List<WeightedEdge> adj(int v){
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        List<WeightedEdge> aux = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(adj[v][i] != null){
            aux.add(adj[v][i]);
            }
        }

        return aux;
    }
}


