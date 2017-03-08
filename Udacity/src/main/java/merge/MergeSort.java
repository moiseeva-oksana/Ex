package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Work in progress
 */
public class MergeSort {
    private int[] sort(int[] list) {
        if (list.length <= 1) {
            return list;
        }

        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        sort(first);
        sort(second);

        list =merge(first, second);
        return list;

    }

    private int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < (second[iSecond])) {
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
        int[] merge = mergeSort.merge(new int[]{1, 2, 4, 10,}, new int[]{-8, 0, 3, 7, 9, 12});
        for (int i : merge) {
            System.out.println(i);
        }

        int[] sort = mergeSort.sort(new int[]{5,4,6,1,0,7});
        System.out.println("_________________");
        System.out.println(Arrays.toString(sort));
    }
}
