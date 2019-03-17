package ru.pavel.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyTreeMapTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {0, 0, 's'},
            {1, 1, 'e'},
            {2, 2, 'a'},
            {3, 5, 'r'},
            {4, 2, 'c'},
            {5, 3, 'h'},
            {6, 2, 'x'},
            {7, 5, 'm'},
            });
        }
    private int a;
    private int b;
    private char c;
    public MyTreeMapTest(int a, int b, char c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    MyTreeMap myTreeMap;

    @Before
    public void init() {
        myTreeMap = new MyTreeMap();
    }

    @Test
    public void putTest() {
        myTreeMap.put(c, b);
    }

    @Test
    public void removeTest() {
        myTreeMap.remove('e');
    }

    @Test
    public void sizeTest() {
        myTreeMap.put(1, 1);
        Assert.assertEquals(1, myTreeMap.size());
        myTreeMap.put(3, 1);
        Assert.assertEquals(2, myTreeMap.size());
        myTreeMap.put(2, 1);
        Assert.assertEquals(3, myTreeMap.size());
        myTreeMap.put(4, 1);
        Assert.assertEquals(4, myTreeMap.size());
        myTreeMap.remove(4);
        Assert.assertEquals(3, myTreeMap.size());
    }

    @Test
    public void heightTest() {
        myTreeMap.put(1, 1);
        Assert.assertEquals(0, myTreeMap.height());
        myTreeMap.put(3, 1);
        Assert.assertEquals(1, myTreeMap.height());
        myTreeMap.put(2, 1);
        Assert.assertEquals(2, myTreeMap.height());
        myTreeMap.put(4, 1);
        Assert.assertEquals(2, myTreeMap.height());
        myTreeMap.remove(4);
        Assert.assertEquals(2, myTreeMap.height());
        myTreeMap.remove(2);
        Assert.assertEquals(1, myTreeMap.height());
    }

    //@Ignore
    @Test
    public void isBalancedTest() {
        myTreeMap.put(1, 1);
        Assert.assertTrue(myTreeMap.isBalanced());
        myTreeMap.put(2, 1);
        Assert.assertTrue(myTreeMap.isBalanced());
        myTreeMap.put(3, 1);
        Assert.assertTrue(myTreeMap.isBalanced());
        myTreeMap.put(4, 1);
        Assert.assertFalse(myTreeMap.isBalanced());
    }
}