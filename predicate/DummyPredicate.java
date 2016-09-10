package array_process.predicate;


import array_process.interfaces.Iterator;
import array_process.interfaces.Predicate;

public final class DummyPredicate implements Predicate
{
    private Iterator _iterator;
    private boolean _result;

    public DummyPredicate(boolean _result, Iterator _iterator)
    {
        this._iterator = _iterator;
        this._result = _result;
        _iterator.first();
    }

    @Override
    public boolean evaluate(Object object)
    {
        if(object instanceof Integer)
        {
            _iterator.next();
            return _result;
        }
        else
        {
            return !_result;
        }
    }
}
