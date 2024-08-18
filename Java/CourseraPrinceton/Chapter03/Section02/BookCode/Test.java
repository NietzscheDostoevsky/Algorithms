import java.util.Queue;

public class Test<Key extends Comparable<Key>, Value> {

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException(("second argument to keys() is null"));

        Queue<Key> queue = new Queue<Key>() {
        }

}
