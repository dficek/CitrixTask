package com.citrix.task.rule;

import com.citrix.task.common.ent.TransformWord;

/**
 * Interface for apply one transform rule.
 *
 * @author Ficek Daniel
 */
public interface TransformRule {

    /**
     * Apply rule.
     * @param word The TransformWord entity
     * @return True if continue with next rule, otherwise False
     */
    boolean applyRule(TransformWord word);

}
