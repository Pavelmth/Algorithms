package ru.pavel.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyChainingHashMapTest {
    MyChainingHashMap<Character, Integer> myChainingHashMap;

    @Before
    public void MyChainingHashMapTest() {
        myChainingHashMap = new MyChainingHashMap<>();
    }

    @Test
    public void putTest() {
        myChainingHashMap.put('a', 2);
        myChainingHashMap.put('x', 5);
        myChainingHashMap.put('r', 7);
        myChainingHashMap.put('c', 11);
        myChainingHashMap.put('d', 15);
        myChainingHashMap.put('u', 19);
        myChainingHashMap.put('t', 21);
        myChainingHashMap.put('p', 24);
    }

    @Test
    public void containsTest() {
        Assert.assertFalse(myChainingHashMap.contains('a'));
        myChainingHashMap.put('a', 1);
        Assert.assertTrue(myChainingHashMap.contains('a'));
    }

    @Test
    public void getTest() {
        myChainingHashMap.put('b', 3);
        Assert.assertEquals((Integer) 3, myChainingHashMap.get('b'));
    }

    @Test
    public void sizeTest() {
        myChainingHashMap.put('a', 2);
        myChainingHashMap.put('x', 5);
        myChainingHashMap.put('r', 7);
        Assert.assertEquals(3, myChainingHashMap.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(myChainingHashMap.isEmpty());
        myChainingHashMap.put('a', 2);
        Assert.assertFalse(myChainingHashMap.isEmpty());
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(null, myChainingHashMap.remove('a'));
        myChainingHashMap.put('a', 2);
        myChainingHashMap.put('x', 5);
        myChainingHashMap.put('r', 7);
        Assert.assertTrue(myChainingHashMap.contains('x'));
        myChainingHashMap.remove('x');
        Assert.assertFalse(myChainingHashMap.contains('x'));
    }
}
