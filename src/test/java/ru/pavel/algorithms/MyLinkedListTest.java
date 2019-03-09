package ru.pavel.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

@RunWith(Parameterized.class)
public class MyLinkedListTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {0, 0, 'a'},
            {1, 1, 'b'},
            {2, 2, 'c'},
            {3, 3, 'd'},
            {4, 4, 'e'},
            {5, 5, 'f'},
            {6, 6, 'g'}
        });
    }

    private int a;
    private int b;
    private char c;
    public MyLinkedListTest (int a, int b, char c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    MyLinkedList myLinkedList;

    @Before
    public void init() {
        myLinkedList = new MyLinkedList();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(0, myLinkedList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(true, myLinkedList.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testException() {
        myLinkedList.getFirst();
    }

    @Test
    public void testAddFirstGetFirst() {
        myLinkedList.addFirst(a);
        Assert.assertEquals(b, myLinkedList.getFirst());
    }

    @Test
    public void testAddFirstRemoveFirst() {
        myLinkedList.addFirst(a);
        Assert.assertEquals(b, myLinkedList.removeFirst());
    }

    @Test
    public void testAddLastGetLast() {
        myLinkedList.addLast(a);
        Assert.assertEquals(b, myLinkedList.getLast());
    }

    @Test
    public void testAddFirstGetFirstLastRemoveFirstLast() {
        myLinkedList.addFirst('a');
        myLinkedList.addFirst('b');
        myLinkedList.addFirst('c');
        myLinkedList.addFirst('d');
        myLinkedList.addFirst('e');
        Assert.assertEquals('e', myLinkedList.removeFirst());
        Assert.assertEquals('a', myLinkedList.removeLast());
        Assert.assertEquals('d', myLinkedList.getFirst());
        Assert.assertEquals('b', myLinkedList.getLast());
    }

    @Test
    public void testAddLastGetFirstLastRemoveFirstLast() {
        myLinkedList.addLast('a');
        myLinkedList.addLast('b');
        myLinkedList.addLast('c');
        myLinkedList.addLast('d');
        myLinkedList.addLast('e');
        Assert.assertEquals('a', myLinkedList.removeFirst());
        Assert.assertEquals('e', myLinkedList.removeLast());
        Assert.assertEquals('b', myLinkedList.getFirst());
        Assert.assertEquals('d', myLinkedList.getLast());
    }

    @Test
    public void testAddLstGet() {
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        myLinkedList.addLast(c);
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
        Assert.assertEquals(c, myLinkedList.get(a));
    }

    @Test
    public void testAddFirstSetGet() {
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.set(a, c);
        Assert.assertEquals(c, myLinkedList.get(a));
    }

    @Test
    public void testIndexOf() {
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.addFirst('w');
        myLinkedList.set(a, c);
        Assert.assertEquals(a, myLinkedList.indexOf(c));
    }

    @Test
    public void testContains() {
        myLinkedList.addFirst('a');
        myLinkedList.addFirst('b');
        myLinkedList.addFirst('c');
        Assert.assertTrue(myLinkedList.contains('a'));
        Assert.assertTrue(myLinkedList.contains('b'));
        Assert.assertTrue(myLinkedList.contains('c'));
        Assert.assertFalse(myLinkedList.contains('d'));
        Assert.assertFalse(myLinkedList.contains('e'));
    }

    @Test
    public void testRemove() {
        myLinkedList.addFirst('a');
        myLinkedList.addFirst('b');
        myLinkedList.addFirst('c');
        Assert.assertTrue(myLinkedList.remove('b'));
        Assert.assertFalse(myLinkedList.remove('b'));
        Assert.assertEquals(2, myLinkedList.size());
    }

    @Test
    public void testAdd() {
        myLinkedList.addFirst('a');
        myLinkedList.addFirst('b');
        myLinkedList.add(1, 'c');
        Assert.assertEquals('c', myLinkedList.get(1));
    }

    @Test
    public void testToString() {
        myLinkedList.addFirst("I");
        myLinkedList.addLast("like");
        myLinkedList.addLast("coke");
        Assert.assertEquals("I, like, coke", myLinkedList.toString());
    }

    @Test
    public void testIterator() {
        myLinkedList.addLast('a');
        myLinkedList.addLast('b');
        myLinkedList.addLast('c');
        myLinkedList.addLast('d');
        myLinkedList.addLast('e');

        for (Object o: myLinkedList) {
            System.out.print(o + ", ");
        }
    }
}
