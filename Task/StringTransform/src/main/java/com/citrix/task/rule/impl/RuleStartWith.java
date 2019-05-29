package com.citrix.task.rule.impl;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformRule;

import java.util.Arrays;
import java.util.List;

/**
 * "StartWith"  (Consonant or Vowel) rule.
 * Always continue with next rule.
 *
 * @author Ficek Daniel
 */
public class RuleStartWith implements TransformRule {

    @Override
    public boolean applyRule(TransformWord word) {
        final String wordRule = word.getTransformed();
        if (wordRule == null || "".equals(wordRule) || !Character.isLetter(wordRule.charAt(0))) {
            return true;
        }

        List<String> vowelList = Arrays.asList("a", "e", "i", "y", "o", "u");
        if (vowelList.stream().anyMatch(vowel -> wordRule.startsWith(vowel))) {
            // Vowel
            word.setTransformed(wordRule + "way");
        } else {
            // Consonant
            word.setTransformed(wordRule.substring(1) + wordRule.substring(0, 1) + "ay");
        }

        return true;
    }

}
