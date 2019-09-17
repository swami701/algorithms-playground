/**
 * KMPSubstring
 */
public class KMPSubstring {

    public static void main(String[] args) {
        System.out.println("KMP Substring");

        String str = "abxabcabcaby";
        String pattern = "abcaby";

        System.out.println("Is '" + pattern + "' substring of '" + str + "' ? Answer: "
                + isSubstring(str.toCharArray(), pattern.toCharArray()));
    }

    private static int[] tempKmpArray(char[] str) {
        int[] res = new int[str.length];
        int j = 0;
        for (int i = 1; i < str.length;) {
            if (str[i] == str[j]) {
                res[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = res[j - 1];
                } else {
                    res[i] = 0;
                    i++;
                }
            }
        }
        if (res.length > 0)
            res[0] = 0;
        return res;
    }

    private static boolean isSubstring(char[] str, char[] pattern) {
        if (str.length < pattern.length)
            return false;
        int[] tempKmpArray = tempKmpArray(pattern);
        int j = 0;
        for (int i = 0; i < str.length && j < pattern.length;) {
            if (str.length - i < pattern.length - j)
                return false;

            if (str[i] == pattern[j]) {
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = tempKmpArray[j-1];
                } else {
                    i++;
                }
            }
        }

        return j >= pattern.length;
    }
}

/**
 * 012345
 * 000120
 * 
 * 012345678901
 * abxabcabcaby
 *         i
 * 012345
 * abcaby
 *      j
 */
