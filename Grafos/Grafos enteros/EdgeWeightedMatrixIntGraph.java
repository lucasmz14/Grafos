import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedMatrixIntGraph implements EdgeGraph{
    private int V;
    private int E;
    private WeightedEdge[][] adj;


    public EdgeWeightedMatrixIntGraph(int v){
        if(v < 0){
            throw new IllegalArgumentException();
        }
        V = v;
        adj = new WeightedEdge[v][v]; 
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
    public void addEdge(WeightedEdge e) {
       if(e.from < V || e.from >= V){
            throw new IllegalArgumentException();
       }
       if(e.to < V || e.to >= V){
            throw new IllegalArgumentException();
       }
       adj[e.from][e.to] = e;
       adj[e.to][e.from] = e; 
       E++;
    }

    @Override
    public List<WeightedEdge> adj(int v) {
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        List<WeightedEdge> aux = new LinkedList<>();

        for(int i = 0 ; i < V() ; i++){
            if(adj[v][i] != null){
                aux.add(adj[v][i]);
            }
        }

        return aux;
    }
    
}

