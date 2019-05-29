package com.citrix.task.common;

import com.citrix.task.common.ent.TransformWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The helper
 *
 * @author Ficek Daniel
 */
public class TransformHelper {

    private TransformHelper() {
        // Util class
    }

    /**
     * Split text into words.
     *
     * @param text Text to split
     * @return List with Words
     */
    public static List<TransformWord> splitTextIntoWords(String text) {
        List<TransformWord> words = new ArrayList<>();

        /*BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
        bi.setText(text);

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(new TransformWord(text.substring(firstIndex, lastIndex)));
            }
        }*/

        Arrays.stream(text.split(" ")).forEach(w -> words.add(new TransformWord(w)));

        return words;
    }

}
