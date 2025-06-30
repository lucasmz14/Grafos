import java.util.List;

public interface EdgeGraph{

    public int V();


    public int E();

    public void addEdge(WeightedEdge e);

    public List<WeightedEdge> adj(int v);

}
