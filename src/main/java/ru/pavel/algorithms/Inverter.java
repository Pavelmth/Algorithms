package ru.pavel.algorithms;

public class Inverter {
    public String invert(String str) {
        char[] arrayChar = str.toCharArray();
        MyStack myStack = new MyStack();
        for (char o: arrayChar) {
            myStack.push(o);
        }
        StringBuilder strb = new StringBuilder();
        int j = myStack.size();
        for (int i = 0; i < j; i++) {
            strb.append(myStack.pop());
        }
        return strb.toString();
    }
}
