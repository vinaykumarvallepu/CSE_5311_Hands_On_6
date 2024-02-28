import java.util.Arrays;
import java.util.Random;

public class quickSortRandomPivot {

    public static void quicksort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        Random rand = new Random();
        int pIndex = rand.nextInt(arr.length);
        int p = arr[pIndex];

        int[] greater = Arrays.stream(arr).filter(x -> x > p).toArray();
        int[] equal = Arrays.stream(arr).filter(x -> x == p).toArray();
        int[] less = Arrays.stream(arr).filter(x -> x < p).toArray();
        
        quicksort(less);
        quicksort(greater);

        System.arraycopy(less, 0, arr, 0, less.length);
        System.arraycopy(equal, 0, arr, less.length, equal.length);
        System.arraycopy(greater, 0, arr, less.length + equal.length, greater.length);
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 2, 5, 10, 2, 6, 5, 3, 8};

        System.out.println("Before Sorting: " + Arrays.toString(arr));
        quicksort(arr);
        System.out.println("After Sorted with Random Pivot: " + Arrays.toString(arr));
    }
}
