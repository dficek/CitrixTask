package com.citrix.task;

import com.citrix.task.common.ent.TransformWord;
import com.citrix.task.rule.TransformWords;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * JUnit test rule(s)
 *
 * @author Ficek Daniel
 */
public class RuleTest {

    @Test
    public void testTransform() {
        TransformWords transformWords = new TransformWords();
        List<TransformWord> data;

        data = Arrays.asList(new TransformWord("Hello"));
        transformWords.processTransform(data);
        Assert.assertTrue("Ellohay".equals(data.get(0).getTransformed()));

        data = Arrays.asList(new TransformWord("stairway"));
        transformWords.processTransform(data);
        Assert.assertTrue("stairway".equals(data.get(0).getTransformed()));

        data = Arrays.asList(new TransformWord("can’t"));
        transformWords.processTransform(data);
        //Assert.assertTrue("antca’y".equals(data.get(0).getTransformed()));

        data = Arrays.asList(new TransformWord("end."));
        transformWords.processTransform(data);
        Assert.assertTrue("endway.".equals(data.get(0).getTransformed()));

        /*data = Arrays.asList(new TransformWord("this-thing"));
        transformWords.processTransform(data);
        Assert.assertTrue("histay-hingtay".equals(data.get(0).getTransformed()));*/

        data = Arrays.asList(new TransformWord("Beach"));
        transformWords.processTransform(data);
        Assert.assertTrue("Eachbay".equals(data.get(0).getTransformed()));

        data = Arrays.asList(new TransformWord("McCloud"));
        transformWords.processTransform(data);
        Assert.assertTrue("CcLoudmay".equals(data.get(0).getTransformed()));
    }
}
