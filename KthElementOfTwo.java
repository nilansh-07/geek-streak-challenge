public class KthElementOfTwo {
    static long kthElement(int K, int arr1[], int arr2[]) {
        int i = 0, j = 0, k = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                newArr[k] = arr1[i];
                i++;
            } else {
                newArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            newArr[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length) {
            newArr[k] = arr2[j];
            k++;
            j++;
        }

        return newArr[K - 1];
    }

    public static void main(String[] args) {
        int k = 5, arr1[] = { 2, 3, 6, 7, 9 }, arr2[] = { 1, 4, 8, 10 };
        System.out.print("The K-th element of two arrays is: " + kthElement(k, arr1, arr2));
    }
}
