package lintcode.difficulty;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：WangJunwu
 * @date ：Created in 2020/4/11 15:52
 */
public class _俄罗斯套娃信封 {

    public static void main(String[] args) {
        int[][] ints = {{2, 3}, {3, 5}, {3, 4}, {5, 5}, {6, 6}};
        System.out.println(maxEnvelopes(ints));
    }


    /**
     * 最长递增子序列的OLogN方法
     *
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;


        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0]?o2[1]-o1[1]:o1[0] - o2[0]);
        int[] ends = new int[envelopes.length];
        ends[0] = envelopes[0][1];
        int len = 1;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > ends[len - 1]) {
                ends[len] = envelopes[i][1];
                len++;
            } else if (envelopes[i][1] < ends[len - 1]) {
                int j = binarySerch(envelopes[i][1], ends, 0, len - 1);
                ends[j] = envelopes[i][1];
            }
        }
        return len;
    }

    public static int binarySerch(int key, int[] a, int low, int high) {
        while (low <= high) {
            int mid = (high + low) / 2;
            if (key > a[mid] && key <= a[mid + 1]) {
                return mid + 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }


}
