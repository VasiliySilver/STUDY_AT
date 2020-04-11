package ru.technoserv.atmaven.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void compareIntegers() {
        int expected = 5;
        int actual = 5;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void compareStrings() {
        String expected = "Hello";
        String actual = "    HEllo  ";
        Assert.assertEquals(actual.toLowerCase().trim(),expected.toLowerCase());
    }

    @Test
    public void compareDouble() {
        double expected = 1.0;
        double actual = 0.999999999999999;
        double eps = 0.0001;
        Assert.assertTrue(Math.abs(expected - actual)<eps);
    }
}
