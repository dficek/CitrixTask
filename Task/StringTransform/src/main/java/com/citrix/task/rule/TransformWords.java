package com.citrix.task.rule;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.impl.RuleCapitalization;
import com.citrix.task.rule.impl.RuleEndWithWay;
import com.citrix.task.rule.impl.RulePunctuation;
import com.citrix.task.rule.impl.RuleStartWith;
import com.citrix.task.rule.impl.RuleToLowerCase;

import java.util.Arrays;
import java.util.List;

/**
 * The transformer (main transform class)
 *
 * @author Ficek Daniel
 */
public class TransformWords {

    private List<TransformRule> transformRules = Arrays.asList(
            new RuleEndWithWay(),
            new RuleToLowerCase(),
            new RuleStartWith(),
            new RulePunctuation(),
            new RuleCapitalization()
    );

    /**
     * Process transformation task.
     *
     * @param words List with words tro transform
     */
    public void processTransform(List<TransformWord> words) {
        words.stream().forEach(
                word -> {
                    for (TransformRule rule : transformRules) {
                        if (!rule.applyRule(word)) {
                            break;
                        }
                    }
                }
        );
    }

}
