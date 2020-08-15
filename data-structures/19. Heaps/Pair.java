public class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    static <U, V> Pair<U, V> of(U u, V v) {
        return new Pair<>(u, v);
    }
}
