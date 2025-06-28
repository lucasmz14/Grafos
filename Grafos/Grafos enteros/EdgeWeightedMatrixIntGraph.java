import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedMatrixIntGraph {
    private final int V;
    private int E;
    private DirectedEdge[][] adj;


    public EdgeWeightedMatrixIntGraph(int V){
        if( V < 0){
            throw new IllegalArgumentException();
        }
        this.V = V;
        adj = new DirectedEdge[V][V];
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
        adj[e.from][e.to] = e;
        adj[e.to][e.from] = e;
        E++;
    }

    public List<DirectedEdge> adj(int v){
        if(v < 0 || v > V){
            throw new IllegalArgumentException();
        }

        List<DirectedEdge> aux = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(adj[v][i] != null){
            aux.add(adj[v][i]);
            }
        }

        return aux;
    }
}

