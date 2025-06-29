import java.util.List;

public interface IntGraph{

    public int V();


    public int E();

    public void addEdge(int v, int w);

    public List<Integer> adj(int v);

}