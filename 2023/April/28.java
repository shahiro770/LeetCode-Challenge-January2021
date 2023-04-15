/*
 * Find the Index of the First Occurrence in a String
 * 
 * Top 100% (0ms)
 * 
 * Simple code solution is 1ms, unfortunately. Java String indexOf is just written better
 * (code at the very bottom)
 * 
 * Time Complexity: O(N*M) 
 */

class Solution {
    public int strStr(Sring haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// class Solution {
//     public int strStr(String haystack, String needle) {
//         if (needle.length() > haystack.length()) {
//             return -1;
//         }

//         for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//             if (haystack.charAt(i) == needle.charAt(0)) {
//                 boolean found = true;
//                 for (int j = 0; j < needle.length(); j++) {
//                     if (haystack.charAt(j + i) != needle.charAt(j)) {
//                         found = false;
//                         break;
//                     }
//                 }
//                 if (found == true) {
//                     return i;
//                 }
//             }
//         }

//         return -1;
//     }
// }

    /**
     * Code shared by String and StringBuffer to do searches. The
     * source is the character array being searched, and the target
     * is the string being searched for.
     *
     * @param   source       the characters being searched.
     * @param   sourceOffset offset of the source string.
     * @param   sourceCount  count of the source string.
     * @param   target       the characters being searched for.
     * @param   targetOffset offset of the target string.
     * @param   targetCount  count of the target string.
     * @param   fromIndex    the index to begin searching from.
     */
    // static int indexOf(char[] source, int sourceOffset, int sourceCount,
    //                    char[] target, int targetOffset, int targetCount,
    //                    int fromIndex) {
    // if (fromIndex >= sourceCount) {
    //         return (targetCount == 0 ? sourceCount : -1);
    // }
    //     if (fromIndex < 0) {
    //         fromIndex = 0;
    //     }
    // if (targetCount == 0) {
    //     return fromIndex;
    // }

    //     char first  = target[targetOffset];
    //     int max = sourceOffset + (sourceCount - targetCount);

    //     for (int i = sourceOffset + fromIndex; i <= max; i++) {
    //         /* Look for first character. */
    //         if (source[i] != first) {
    //             while (++i <= max && source[i] != first);
    //         }

    //         /* Found first character, now look at the rest of v2 */
    //         if (i <= max) {
    //             int j = i + 1;
    //             int end = j + targetCount - 1;
    //             for (int k = targetOffset + 1; j < end && source[j] ==
    //                      target[k]; j++, k++);

    //             if (j == end) {
    //                 /* Found whole string. */
    //                 return i - sourceOffset;
    //             }
    //         }
    //     }
    //     return -1;
    // }