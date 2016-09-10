package array_process.array_iterator;


import array_process.custom_exception.IteratorOutOfBoundsException;
import array_process.interfaces.Iterator;
import array_process.interfaces.Predicate;

public class FilterIterator implements Iterator
{
    private Iterator _iterator;
    private Predicate _predicate;

    public FilterIterator(Iterator _iterator, Predicate _predicate)
    {
        assert _iterator != null : "Iterator cannot be NULL!";
        assert _predicate != null : "Iterator cannot be NULL!";

        this._iterator = _iterator;
        this._predicate = _predicate;
    }

    @Override
    public void first()
    {
        _iterator.first();
        filterForwards();
    }

    @Override
    public void last()
    {
        _iterator.last();
        filterBackwards();
    }

    @Override
    public boolean isDone()
    {
        return _iterator.isDone();
    }

    @Override
    public void next()
    {
        _iterator.next();
        filterForwards();
    }

    private void filterForwards()
    {
        while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current()))
        {
            _iterator.next();
        }
    }

    @Override
    public void previous()
    {
        _iterator.previous();
        filterBackwards();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException
    {
        return _iterator.current();
    }

    private void filterBackwards()
    {
        while(!_iterator.isDone() && !_predicate.evaluate(_iterator.current()))
        {
            _iterator.previous();
        }
    }

}
