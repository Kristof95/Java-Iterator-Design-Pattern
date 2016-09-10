package array_process.main;


import array_process.array_iterator.ArrayIterator;
import array_process.array_iterator.FilterIterator;
import array_process.array_iterator.ReverseArrayIterator;
import array_process.interfaces.Iterator;
import array_process.predicate.DummyPredicate;

public class Main
{

    public static void main(String[] args)
    {
        Object[] object = new Object[]{"alma",1,"körte",2};

        Iterator expectedIterator = new ArrayIterator(object);

        Iterator underlyingIterator = new ArrayIterator(object);

        Iterator underlyingIterator_backward = new ReverseArrayIterator(new ArrayIterator(object));

        Iterator filterIterator = new FilterIterator(underlyingIterator_backward, new DummyPredicate(true, expectedIterator));

        for(filterIterator.first(); !filterIterator.isDone(); filterIterator.next())
        {
            Object obj = filterIterator.current();
            System.out.print(obj.toString()+" ");
        }
    }
}
