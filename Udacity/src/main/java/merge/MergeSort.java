package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private List<int[]> listOfArrays = new ArrayList<>();
    private List<int[]> sortedList = new ArrayList<>();

    private void spliceToArrays(int[] arr) {
        if(arr.length<2) {
            listOfArrays.add(arr);
            return;
        }
        spliceToArrays(Arrays.copyOfRange(arr, 0, arr.length/2));
        spliceToArrays(Arrays.copyOfRange(arr, arr.length/2, arr.length));

    }
    private int[]sort(int[] list) {
        if (list.length <= 1) {
            return list;
        }

        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        sort(first);
        sort(second);

        return merge(first, second);

    }
    private int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        while (iMerged<result.length-1) {
            if (first[iFirst]<(second[iSecond])) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
        return result;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        System.out.println("_________________");
        int[] merge = mergeSort.sort(new int[]{1, 5,9,-7,7,8,4,6});
        for (int i: merge) {
            System.out.println(i);
        }
    }
}
