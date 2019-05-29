package com.citrix.task.rule.impl;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformRule;

/**
 * "EndWithWay" rule.
 *
 * @author Ficek Daniel
 */
public class RuleEndWithWay implements TransformRule {

    @Override
    public boolean applyRule(TransformWord word) {
        String wordRule = word.getTransformed();
        if (wordRule == null || "".equals(wordRule)) {
            return true;
        }

        return !wordRule.toLowerCase().endsWith("way");
    }

}
