package leetcode.nowcoder;

/**
 * 牛客网BM22：比较版本号
 */
public class BM22 {
    public int compare(String version1, String version2) {
        String[] splitVersion1 = version1.split("\\.");
        String[] splitVersion2 = version2.split("\\.");
        int maxLength = Math.max(splitVersion1.length, splitVersion2.length);
        int[] intVersion1 = new int[maxLength];
        int[] intVersion2 = new int[maxLength];
        for (int ptr = 0; ptr < maxLength; ptr++) {
            if (ptr < splitVersion1.length) {
                intVersion1[ptr] = Integer.parseInt(splitVersion1[ptr]);
            } else {
                intVersion1[ptr] = 0;
            }

            if (ptr < splitVersion2.length) {
                intVersion2[ptr] = Integer.parseInt(splitVersion2[ptr]);
            } else {
                intVersion2[ptr] = 0;
            }
        }
        for (int ptr = 0; ptr < maxLength; ptr++) {
            if (intVersion1[ptr] > intVersion2[ptr]) {
                return 1;
            }
            if (intVersion1[ptr] < intVersion2[ptr]) {
                return -1;
            }
        }
        return 0;
    }
}
