package ru.pavel.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private MyStack myStack;
    private MyQueue myQueue;
    private MyDeque myDeque;
    private Inverter inverter;

    @Before
    public void startTest() {
        myStack = new MyStack();
        myQueue = new MyQueue();
        myDeque = new MyDeque();
        inverter = new Inverter();
    }

    @Test
    public void testSizeZero()
    {
        Assert.assertEquals(0, myStack.size());
        Assert.assertEquals(0, myQueue.size());
        Assert.assertEquals(0, myDeque.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myStack.isEmpty());
        assertTrue(myQueue.isEmpty());
        assertTrue(myDeque.isEmpty());
    }

    @Test
    public void testPushSize() {
        myStack.push('a');
        Assert.assertEquals(1, myStack.size());
        myQueue.push('a');
        Assert.assertEquals(1, myQueue.size());
    }

    @Test
    public void testAddFirstLastSize() {
        myDeque.addFirst('a');
        myDeque.addLast('b');
        Assert.assertEquals(2, myDeque.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPushPeekException() {
        Assert.assertEquals('a', myStack.peek());
        Assert.assertEquals('a', myQueue.peek());
        Assert.assertEquals('a', myDeque.peekFirst());
        Assert.assertEquals('b', myDeque.peekLast());
    }

    @Test
    public void testPushAddPeek() {
        myStack.push('a');
        myStack.push('b');
        Assert.assertEquals('b', myStack.peek());
        myQueue.push('a');
        myQueue.push('b');
        Assert.assertEquals('a', myQueue.peek());
        myDeque.addLast('c');
        myDeque.addLast('b');
        myDeque.addLast('a');
        Assert.assertEquals('a', myDeque.peekLast());
        myDeque.addFirst('d');
        Assert.assertEquals('d', myDeque.peekFirst());
    }

    @Test
    public void testPushPopPollSize() {
        myStack.push('a');
        myStack.push('b');
        myStack.push('c');
        Assert.assertEquals('c', myStack.pop());
        Assert.assertEquals('b', myStack.pop());
        Assert.assertEquals('a', myStack.pop());
        Assert.assertEquals(0, myStack.size());
        myQueue.push('a');
        myQueue.push('b');
        myQueue.push('c');
        Assert.assertEquals('a', myQueue.poll());
        Assert.assertEquals('b', myQueue.poll());
        Assert.assertEquals('c', myQueue.poll());
        Assert.assertEquals(0, myQueue.size());
    }

    @Test
    public void testAddFirstPollFirst() {
        myDeque.addFirst('e');
        myDeque.addFirst('d');
        myDeque.addFirst('c');
        myDeque.addFirst('b');
        myDeque.addFirst('a');
        Assert.assertEquals('a', myDeque.pollFist());
        Assert.assertEquals('b', myDeque.pollFist());
        Assert.assertEquals('c', myDeque.pollFist());
        Assert.assertEquals('d', myDeque.pollFist());
        Assert.assertEquals('e', myDeque.pollFist());
        Assert.assertEquals(0, myDeque.size());
    }

    @Test
    public void testAddLastPollLast() {
        myDeque.addLast('a');
        myDeque.addLast('b');
        myDeque.addLast('c');
        myDeque.addLast('d');
        myDeque.addLast('e');
        Assert.assertEquals('e', myDeque.pollLast());
        Assert.assertEquals('d', myDeque.pollLast());
        Assert.assertEquals('c', myDeque.pollLast());
        Assert.assertEquals('b', myDeque.pollLast());
        Assert.assertEquals('a', myDeque.pollLast());
        Assert.assertEquals(0, myDeque.size());
    }

    @Test
    public void testAddFirstLastPoll() {
        myDeque.addFirst('b');
        myDeque.addFirst('a');
        myDeque.addLast('c');
        myDeque.addLast('d');
        Assert.assertEquals('a', myDeque.pollFist());
        Assert.assertEquals('b', myDeque.pollFist());
        Assert.assertEquals('d', myDeque.pollLast());
        Assert.assertEquals('c', myDeque.pollLast());
        Assert.assertEquals(0, myDeque.size());
    }

    @Test
    public void testPushToString() {
        myStack.push('a');
        myStack.push('B');
        Assert.assertEquals("B, a", myStack.toString());
        myQueue.push('A');
        myQueue.push('b');
        myQueue.push('c');
        Assert.assertEquals("A, b, c", myQueue.toString());
        myDeque.addFirst('A');
        myDeque.addLast('B');
        myDeque.addLast('C');
        myDeque.addFirst('a');
        Assert.assertEquals("a, A, B, C", myDeque.toString());
    }

    @Test
    public void testInverter() {
        Assert.assertEquals("$# Z1edcba", inverter.invert("abcde1Z #$"));
    }
}
