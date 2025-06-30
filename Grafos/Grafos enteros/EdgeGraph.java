import java.util.List;

public interface EdgeGraph{

    public int V();


    public int E();

    public void addEdge(Edge e);

    public List<Edge> adj(int v);

}
