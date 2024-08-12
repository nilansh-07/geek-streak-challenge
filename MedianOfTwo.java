import java.util.Arrays;

public class MedianOfTwo {
    static int sumOfMiddleElements(int[] arr1, int[] arr2) {

        int length = arr1.length + arr2.length;
        int[] newArr = new int[length];

        int indx = 0;
        for (int ele : arr1) {
            newArr[indx++] = ele;
        }
        for (int ele : arr2) {
            newArr[indx++] = ele;
        }

        Arrays.sort(newArr);

        int mid1 = newArr[length / 2];
        int mid2 = newArr[(length / 2) - 1];

        int sum = mid1 + mid2;

        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 6, 10 }, arr2 = { 4, 5, 6, 9, 12 };
        System.out.print("The Sum of middle elements: " + sumOfMiddleElements(arr1, arr2));
    }
}
