package com.example.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilLeapYearShould {
    @Test
    public void returnTrueWhenYearIsDivisibleBy400() {
        assertTrue(DateUtil.isLeapYear(1600));
        assertTrue(DateUtil.isLeapYear(2000));
        assertTrue(DateUtil.isLeapYear(2400));
    }

    @Test
    public void returnFalseWhenYearIsDivisibleBy100ButNotBy400() {
        assertFalse(DateUtil.isLeapYear(1700));
        assertFalse(DateUtil.isLeapYear(1800));
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void returnTrueWhenYearIsDivisibleBy4ButNotBy100() {
        assertTrue(DateUtil.isLeapYear(1996));
        assertTrue(DateUtil.isLeapYear(2004));
        assertTrue(DateUtil.isLeapYear(2008));
    }

    @Test
    public void returnFalseWhenYearIsNotDivisibleBy4() {
        assertFalse(DateUtil.isLeapYear(2017));
        assertFalse(DateUtil.isLeapYear(2018));
        assertFalse(DateUtil.isLeapYear(2019));
    }
}