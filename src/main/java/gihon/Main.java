public class Main {

    static void Merge(int[] A, int p, int q, int l) {
        int leftSize = q - p + 1;
        int rightSize = l - q;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            left[i] = A[p + i];
        for (int j = 0; j < rightSize; ++j)
            right[j] = A[q + 1 + j];

        int leftCursor = 0, rightCursor = 0;
        int temp = p;

        while (leftCursor < leftSize && rightCursor < rightSize) {
            if (left[leftCursor] <= right[rightCursor]) {
                A[temp] = left[leftCursor];
                leftCursor++;
            } else {
                A[temp] = right[rightCursor];
                rightCursor++;
            }
            temp++;
        }
        while (leftCursor < leftSize) {
            A[temp] = left[leftCursor];
            leftCursor++;
            temp++;
        }
        while (rightCursor < rightSize) {
            A[temp] = right[rightCursor];
            rightCursor++;
            temp++;
        }
    }
    static void Sort(int A[], int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            Sort(A, p, q);
            Sort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }

    public static void main(String[] args) {
        int[] A = { 5,2,4,6,1,3,2,6};
        Sort(A, 0, A.length-1);
        for (int j : A) System.out.println(j);
    }
}