package array_process.array_iterator;


import array_process.custom_exception.IteratorOutOfBoundsException;
import array_process.interfaces.Iterator;

public class ArrayIterator implements Iterator
{
    private Object[] _array;
    private int _first;
    private int _last;
    private int _current = -1;

    public ArrayIterator(Object[] array, int start, int length)
    {
        assert array != null : "the array cannot be NULL";
        assert start >= 0 : "starting value cannot be negative";
        assert start < array.length : "starting index cannot be greater than array length";
        assert length >= 0 : "length cannot be negative";
        assert _last <= 0 : "end value cannot be negative";

        this._array = array;
        this._first = start;
        this._last = start + length - 1;

        assert _last < array.length : "last element index cannot be greater than array length";
    }

    public ArrayIterator(Object[] _array)
    {
        this._array = _array;
        assert _array != null : "the array cannot be NULL";
        this._first = 0;
        this._last = _array.length - 1;
    }

    public ArrayIterator()
    {

    }

    @Override
    public void first()
    {
        _current = _first;
    }

    @Override
    public void last()
    {
        _current = _last;
    }

    @Override
    public boolean isDone()
    {
        return _current < _first || _current > _last;
    }

    @Override
    public void next()
    {
        ++_current;
    }

    @Override
    public void previous()
    {
        --_current;
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException
    {
        if(isDone())
        {
            throw new IteratorOutOfBoundsException();
        }
        return _array[_current];
    }
}
