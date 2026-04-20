package com.example.dsa;

/**
 * Problem 063: Text Justification
 *
 * Format a list of words into fully justified text lines of maxWidth.
 *
 * Solution explanation in code comments.
 */
public class Problem063_TextJustification {
    public static void main(String[] args) {
        System.out.println("Running Problem063_TextJustification");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static java.util.List<String> fullJustify(String[] words, int maxWidth) {
        java.util.List<String> result = new java.util.ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int spaces = (maxWidth - totalChars + gaps) / gaps;
                int extra = (maxWidth - totalChars + gaps) % gaps;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int k = 0; k < spaces + (extra > 0 ? 1 : 0); k++) sb.append(' ');
                        if (extra > 0) extra--;
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
