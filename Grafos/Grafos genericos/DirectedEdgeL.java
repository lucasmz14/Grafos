public class DirectedEdgeL<T> {
    private final T from;
    private final T to;
    private final double weight;

    public DirectedEdgeL(T from, T to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

}

