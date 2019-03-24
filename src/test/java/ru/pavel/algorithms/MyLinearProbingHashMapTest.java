package ru.pavel.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinearProbingHashMapTest {
    MyLinearProbingHashMap<Character, Integer> myLinearProbingHashMap;

    @Before
    public void MyLinearProbingHashMap() {
        myLinearProbingHashMap = new MyLinearProbingHashMap<>();
    }

    @Test
    public void putTest() {
        myLinearProbingHashMap.put('a', 2);
        myLinearProbingHashMap.put('x', 5);
        myLinearProbingHashMap.put('r', 7);
        myLinearProbingHashMap.put('c', 11);
        myLinearProbingHashMap.put('d', 15);
        myLinearProbingHashMap.put('u', 19);
        myLinearProbingHashMap.put('t', 21);
        myLinearProbingHashMap.put('p', 24);
    }

    @Test
    public void containsTest() {
        Assert.assertFalse(myLinearProbingHashMap.contains('a'));
        myLinearProbingHashMap.put('a', 1);
        Assert.assertTrue(myLinearProbingHashMap.contains('a'));
    }

    @Test
    public void getTest() {
        myLinearProbingHashMap.put('b', 3);
        Assert.assertEquals((Integer) 3, myLinearProbingHashMap.get('b'));
    }

    @Test
    public void sizeTest() {
        myLinearProbingHashMap.put('a', 2);
        myLinearProbingHashMap.put('x', 5);
        myLinearProbingHashMap.put('r', 7);
        Assert.assertEquals(3, myLinearProbingHashMap.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(myLinearProbingHashMap.isEmpty());
        myLinearProbingHashMap.put('a', 2);
        Assert.assertFalse(myLinearProbingHashMap.isEmpty());
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(null, myLinearProbingHashMap.remove('a'));
        myLinearProbingHashMap.put('a', 2);
        myLinearProbingHashMap.put('x', 5);
        myLinearProbingHashMap.put('r', 7);
        Assert.assertTrue(myLinearProbingHashMap.contains('x'));
        myLinearProbingHashMap.remove('x');
        Assert.assertFalse(myLinearProbingHashMap.contains('x'));
    }
}
