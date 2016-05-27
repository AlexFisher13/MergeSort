
public class MergeSort {

     public static void mergeSort (int [] a) {
         int [] tmp = new int[a.length];
         mergeSort(a, tmp, 0, a.length - 1);
     }

    private static void mergeSort (int [] a, int [] tmp, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge (int [] a, int [] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd)
            if(a[leftPos] <= (a[rightPos]))
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];

        while(leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];

        while(rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];

        for(int i = 0; i < numElements; i++, rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];
    }

    public static void main (String[] args) {
        int [] arr = new int[]{4, 6, 7, 1, 8, 3, 2, 5};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
