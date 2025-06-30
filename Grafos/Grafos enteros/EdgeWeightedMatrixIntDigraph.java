import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedMatrixIntDigraph implements EdgeGraph{
    private final int V;
    private int E;
    private Edge[][] adj;


    public EdgeWeightedMatrixIntDigraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new Edge[V][V];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }


    public void addEdge(Edge e){
        if(e.from < 0 || e.from >= V){
            throw new IllegalArgumentException();
        }
        if(e.to < 0 || e.to >= V){
            throw new IllegalArgumentException();
        }
        adj[e.from][e.to] = e;
        E++;
    }

    public List<Edge> adj(int v){
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        List<Edge> aux = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(adj[v][i] != null){
            aux.add(adj[v][i]);
            }
        }

        return aux;
    }
}


