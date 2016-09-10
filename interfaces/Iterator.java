package array_process.interfaces;


import array_process.custom_exception.IteratorOutOfBoundsException;

public interface Iterator
{
    void first();

    void last();

    boolean isDone();

    void next();

    void previous();

    Object current() throws IteratorOutOfBoundsException;
}
