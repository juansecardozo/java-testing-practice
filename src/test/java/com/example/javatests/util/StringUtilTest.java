package com.example.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeatStringThrice() {
        Assert.assertEquals("HelloHelloHello", StringUtil.repeat("Hello", 3));
    }

    @Test
    public void repeatStringOnce() {
        Assert.assertEquals("Hello", StringUtil.repeat("Hello", 1));
    }

    @Test
    public void repeatStringZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("Hello", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes() {
        StringUtil.repeat("Hello", -1);
    }

    @Test
    public void anyTextIsNotEmpty() {
        Assert.assertFalse(StringUtil.isEmpty("bla bla bla"));
    }

    @Test
    public void doubleQuotedStringIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void nullIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void stringOnlySpacesIsEmpty() {
        Assert.assertTrue(StringUtil.isEmpty("   "));
    }
}