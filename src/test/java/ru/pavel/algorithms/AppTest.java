package ru.pavel.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */

public class AppTest {
    MyArrayList myArrayList;
    @Before
    public void setMyArrayList() {
        myArrayList = new MyArrayList();
    }

    @Test
    public void addMyArrayListAdd()
    {
        assertTrue(myArrayList.add(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
        public void delMyArrayListAdd()
    {
        assertTrue(myArrayList.delete(1));
    }

    @Test
    public void massAddMyArrayListAdd()
    {
        assertTrue(myArrayList.add(1));
        assertTrue(myArrayList.add(2));
        assertTrue(myArrayList.add(3));
        assertTrue(myArrayList.add(4));
        assertTrue(myArrayList.add(5));
        assertTrue(myArrayList.add(6));
        assertTrue(myArrayList.add(7));
        assertTrue(myArrayList.add(8));
        assertTrue(myArrayList.add(9));
        assertTrue(myArrayList.add(10));
        assertTrue(myArrayList.add(11));
        assertTrue(myArrayList.add(12));
        Assert.assertEquals(12, myArrayList.length() );
    }

    @Test
    public void massAddDelMyArrayListAdd()
    {
        assertTrue(myArrayList.add(1));
        assertTrue(myArrayList.add(2));
        assertTrue(myArrayList.add(3));
        assertTrue(myArrayList.add(4));
        assertTrue(myArrayList.add(5));
        assertTrue(myArrayList.delete(0));
        Assert.assertEquals(4, myArrayList.length() );
    }

    @Test
    public void getMyArrayListAdd()
    {
        assertTrue(myArrayList.add(10));
        Assert.assertEquals(10, myArrayList.get(0) );
    }

    @Test
    public void setMyArrayListAdd()
    {
        assertTrue(myArrayList.add(10));
        assertTrue(myArrayList.set(0, 5));
        Assert.assertEquals(5, myArrayList.get(0));
    }

    @Test
    public void massAddIndexMyArrayListAdd()
    {
        assertTrue(myArrayList.add(1));
        assertTrue(myArrayList.add(2));
        assertTrue(myArrayList.add(3));
        assertTrue(myArrayList.add(4));
        assertTrue(myArrayList.add(0, 12));
        assertTrue(myArrayList.add(4, 21));
        Assert.assertEquals(12, myArrayList.get(0));
        Assert.assertEquals(1, myArrayList.get(1));
        Assert.assertEquals(2, myArrayList.get(2));
        Assert.assertEquals(3, myArrayList.get(3));
        Assert.assertEquals(21, myArrayList.get(4));
        Assert.assertEquals(4, myArrayList.get(5));
        assertTrue(myArrayList.add(3, 9));
        Assert.assertEquals(9, myArrayList.get(3));
    }

    @Test
    public void sortBubble() {
        System.out.println("Bubble sort:");
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            myArrayList.add(random.nextInt(100_000));
        }
        long start = System.currentTimeMillis();
        myArrayList.sortBubble();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "\n");
    }

    @Test
    public void sortSelect() {
        System.out.println("Select sort:");
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            myArrayList.add(random.nextInt(100_000));
        }
        long start = System.currentTimeMillis();
        myArrayList.sortSelect();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "\n");
    }

    @Test
    public void sortInsert() {
        System.out.println("Insert sort:");
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            myArrayList.add(random.nextInt(100_000));
        }
        long start = System.currentTimeMillis();
        myArrayList.sortInsert();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "\n");
    }
}
