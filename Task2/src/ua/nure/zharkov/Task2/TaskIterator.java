package ua.nure.zharkov.Task2;

public interface TaskIterator extends java.util.Iterator<Object> {
    boolean hasNext();
    Object next();
    void remove();
}
