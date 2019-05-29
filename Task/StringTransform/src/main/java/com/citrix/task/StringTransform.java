package com.citrix.task;

import com.citrix.task.common.TransformHelper;
import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformWords;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The main class with main().
 * Transform string apply rule(s) implemented as separated classes.
 * Simple console solution ;)
 *
 * Sentence to transform is first command line argument
 *
 * @author Ficek Daniel
 */
public class StringTransform {

    /**
     * The java main().
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println(String.format("App started at %s", LocalDateTime.now()));

        if (args.length == 1) {
            // Split text
            List<TransformWord> words = TransformHelper.splitTextIntoWords(args[0]);

            // Transform words
            TransformWords transformWords = new TransformWords();
            transformWords.processTransform(words);

            // Print result (and original text)
            printOriginText(args[0]);
            printResultWords(words);
        } else {
            System.out.println("ERROR: Only one argument (text to transform) is allowed.");
        }

        System.out.println(String.format("App finished at %s", LocalDateTime.now()));
    }

    private static void printOriginText(String text) {
        System.out.println("");
        System.out.println("Origin text:");
        System.out.println(text);
        System.out.println("");
    }

    private static void printResultWords(List<TransformWord> words) {
        System.out.println("");
        System.out.println("Words:");
        words.stream().forEach(word -> System.out.println(word.toResultText()));
        System.out.println("");
    }

}
