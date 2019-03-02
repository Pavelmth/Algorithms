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

    //++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testPushSize() {
        myStack.push('a');
        Assert.assertEquals(1, myStack.size());
        myQueue.push('a');
        Assert.assertEquals(1, myQueue.size());
    }

    //++++++++++++++++++++++++++++++++++++++++++++++
    @Test(expected = NoSuchElementException.class)
    public void testPushPeekException() {
        Assert.assertEquals('a', myStack.peek());
        Assert.assertEquals('a', myQueue.peek());
    }

    //++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testPushPeek() {
        myStack.push('a');
        myStack.push('b');
        Assert.assertEquals('b', myStack.peek());
        myQueue.push('a');
        myQueue.push('b');
        Assert.assertEquals('a', myQueue.peek());
    }

    //++++++++++++++++++++++++++++++++++++++++++++++
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
        Assert.assertEquals(2, myQueue.size());
    }

    //++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void testPushToString() {
        myStack.push('a');
        myStack.push('B');
        Assert.assertEquals("B, a", myStack.toString());
        myQueue.push('A');
        myQueue.push('b');
        myQueue.push('c');
        Assert.assertEquals("A, b, c", myQueue.toString());
    }

    @Test
    public void testInverter() {
        Assert.assertEquals("edcba", inverter.invert("abcde"));
    }
}
