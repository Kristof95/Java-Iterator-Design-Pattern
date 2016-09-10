package array_process.array_iterator;

import array_process.custom_exception.IteratorOutOfBoundsException;
import array_process.interfaces.Iterator;

public class ReverseArrayIterator implements Iterator
{
    private Iterator iterator;

    public ReverseArrayIterator(Iterator _iterator)
    {
        assert _iterator != null : "Iterator cannot be NULL";
        this.iterator = _iterator;
    }

    @Override
    public void first()
    {
        iterator.last();
    }

    @Override
    public void last()
    {
        iterator.first();
    }

    @Override
    public boolean isDone()
    {
        return iterator.isDone();
    }

    @Override
    public void next()
    {
        iterator.previous();
    }

    @Override
    public void previous()
    {
        iterator.next();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException
    {
        return iterator.current();
    }
}
