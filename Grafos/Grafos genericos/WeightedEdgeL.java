public class WeightedEdgeL<T> {
    private final T from;
    private final T to;
    private final double weight;

    public WeightedEdgeL(T from, T to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return "(" + from + "->" + to + ", " + weight + ")";
    }

}

