
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] firstArray = new int[8]; // unsorted
        int[] secondArray = new int[8]; // sorted

        for (int i = 0; i<firstArray.length; i++) {
            System.out.println("Enter number: ");
            firstArray[i] = sc.nextInt();
        }

        System.out.println("The array unsorted is: " + Arrays.toString(firstArray));
        secondArray = bubbleSort(firstArray); // populate secondArray with sorted
        System.out.println("The array sorted is: " + Arrays.toString(secondArray));
    }

    public static int[] bubbleSort(int[] array) {
        for (int pass = 0; pass<(array.length - 1); pass++) {
            for (int i = 0; i<(array.length - 1 - pass); i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}