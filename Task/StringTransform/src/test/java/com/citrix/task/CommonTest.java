package com.citrix.task;

import com.citrix.task.common.TransformHelper;
import com.citrix.task.common.ent.TransformWord;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * JUnit test functions in common package
 *
 * @author Ficek Daniel
 */
public class CommonTest {

    @Test
    public void testSplitTextIntoWords() {
        String text = "Donec quis nibh at felis congue commodo.";
        List<TransformWord> words = TransformHelper.splitTextIntoWords(text);

        Assert.assertTrue(words.size() == 7);
    }

}
