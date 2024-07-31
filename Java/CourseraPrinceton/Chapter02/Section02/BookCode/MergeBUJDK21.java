@SuppressWarnings({"rawtypes"})
public class MergeBUJDK21 {

    

    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i+1], a[i]))
                return false; 
            return true;
        }
    }
    
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] a = {9,8,7,6,5,4,3,2,1,0};
        sort(a); 
        assert isSorted(a); 
        System.out.println("Array is Sorted");
        show(a); 
    }
}