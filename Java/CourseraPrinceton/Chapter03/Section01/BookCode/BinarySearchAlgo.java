public class BinarySearchAlgo {
    
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo; // base condition
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]); 
        if (cmp < 0) 
            return rank(key, lo, mid-1)
        else if (cmp > 0)
            return rank(key, mid+1, hi)
        else
            return mid;
    }
}
