import java.util.Iterator;
import java.util.NoSuchElementException;

class DoubleIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator_1;
    private final Iterator<T> iterator_2;

    public DoubleIterator(Iterator<T> iterator_1, Iterator<T> iterator_2) {
        this.iterator_1 = iterator_1;
        this.iterator_2 = iterator_2;
    }

    @Override
    public boolean hasNext() {
        while (iterator_1.hasNext()) return true;
        while (iterator_2.hasNext()) return true;
        return false;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();

        while (iterator_1.hasNext()) return iterator_1.next();
        while (iterator_2.hasNext()) return iterator_2.next();
        return null;
    }
}