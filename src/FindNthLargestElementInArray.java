public class FindNthLargestElementInArray {
    public static void main(String[] args) {
        System.out.println("Find Nth Largest Element in array");
        int[] input = {3, 5, 4, 1, 2};
        int nthLargest = 3;
        System.out.println("Input Array");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();

        int result = getNthLargest(input, nthLargest);
        result = result == -1 ? input[nthLargest - 1] : result; // If result is -1 then it's already sorted.
        System.out.println(nthLargest + "th Largest Item: " + result);
        System.out.println("Array In the end");
        for (int i : input) {
            System.out.print("\t" + i);
        }
        System.out.println();
    }

    private static int getNthLargest(int[] input, int nthLargest) {
        if (nthLargest < 1 || nthLargest > input.length) return -1;

        return performQuickSortPartitioning(input, nthLargest, 0, input.length - 1);
    }

    private static int performQuickSortPartitioning(int[] input, int nthLargest, int start, int end) {
        if (end - start < 1) return -1; // sorting done
        int pivotIdx = getPivotIdx(input, start, end);
        System.out.println("Start: " + start + " end: " + end + " Pivot: " + pivotIdx);
        if (pivotIdx + 1 == nthLargest) return input[pivotIdx];
        else if (pivotIdx + 1 > nthLargest) return performQuickSortPartitioning(input, nthLargest, start, pivotIdx - 1);
        else return performQuickSortPartitioning(input, nthLargest, pivotIdx + 1, end);
    }

    private static int getPivotIdx(int[] input, int start, int end) {
        if (end - start < 1) return -1; // Never happens
        int i = start + 1;
        for (int j = i; j <= end; j++) {
            if (input[j] <= input[start]) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, start, i - 1);

        return i - 1;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
