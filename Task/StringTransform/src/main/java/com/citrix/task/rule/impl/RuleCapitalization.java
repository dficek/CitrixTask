package com.citrix.task.rule.impl;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformRule;

import java.util.Arrays;
import java.util.List;

/**
 * "Capitalization"  rule.
 * Always continue with next rule.
 *
 * @author Ficek Daniel
 */
public class RuleCapitalization implements TransformRule {

    @Override
    public boolean applyRule(TransformWord word) {
        String wordRule = word.getTransformed();
        if (wordRule == null || "".equals(wordRule)) {
            return true;
        }

        final String wordOrigin = word.getOrigin();

        for(int index = 0; index < wordOrigin.length(); index++) {
            if (Character.isUpperCase(wordOrigin.charAt(index))) {
                wordRule = wordRule.substring(0, index) + wordRule.substring(index, index + 1).toUpperCase() + wordRule.substring(index + 1);
            }
        }
        word.setTransformed(wordRule);

        return true;
    }

}
