import java.util.Arrays;

public class arrayReverse {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int arr[], int i, int j) {
        if (i < j) {
            swap(arr, i, j);
            reverse(arr, i + 1, j - 1);
        }
        return;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
