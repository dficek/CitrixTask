package com.citrix.task.rule.impl;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformRule;

/**
 * "ToLowerCase"  rule.
 * Always continue with next rule.
 *
 * @author Ficek Daniel
 */
public class RuleToLowerCase implements TransformRule {

    @Override
    public boolean applyRule(TransformWord word) {
        String wordRule = word.getTransformed();
        if (wordRule == null) {
            return true;
        }

        word.setTransformed(wordRule.toLowerCase());

        return true;
    }
}
