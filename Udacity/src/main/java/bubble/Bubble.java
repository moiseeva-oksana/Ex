package bubble;

public class Bubble {
    public static void sort(int[] list, int length) {
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            if (list[i] > list[i + 1]) {
                int tmp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = tmp;
            }
        }
        sort(list, length - 1);
    }
}
