package com.citrix.task.rule.impl;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformRule;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * "Punctuation"  rule.
 * Always continue with next rule.
 *
 * @author Ficek Daniel
 */
public class RulePunctuation implements TransformRule {

    @Override
    public boolean applyRule(TransformWord word) {
        String wordRule = word.getTransformed();
        if (wordRule == null || "".equals(wordRule)) {
            return true;
        }

        final String wordOrigin = word.getOrigin();

        List<String> punctuationList = Arrays.asList("\\.", "\\,", "\\'", "\\:", "\\!", "\\?", "\\;");
        for(int index = 0; index < punctuationList.size(); index++) {
            wordRule = wordRule.replaceAll(punctuationList.get(index), "");
        }

        for(int index = wordOrigin.length() - 1; index >= 0; index--) {
            final String stringIndex = wordOrigin.substring(index, index + 1);
            if (punctuationList.stream().anyMatch(p -> stringIndex.equals(p))) {
                wordRule = wordRule.substring(0, index + 1) + stringIndex + wordRule.substring(index + 2);
            }
        }

        word.setTransformed(wordRule);

        return true;
    }

}
