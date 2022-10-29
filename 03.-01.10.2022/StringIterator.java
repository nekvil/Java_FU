import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class StringIterator implements Iterator<String> {

    private final Stack<Iterator<?>> iterators;
    private String next;
    private boolean hasNext;

    public StringIterator(Iterator<?> iterator) {
        this.iterators = new Stack<>();
        iterators.push(iterator);
        updateNext();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    private void updateNext(){

        if(iterators.empty()){
            next = null;
            hasNext = false;
            return;
        }

        Iterator<?> current = iterators.peek();

        if (current.hasNext()) {
            Object o = current.next();
            if (o instanceof String) {
                next = (String) o;
                hasNext = true;
            } else if (o instanceof Iterator<?> iterator) {
                iterators.push(iterator);
                updateNext();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            iterators.pop();
            updateNext();
        }
    }

    @Override
    public String next() throws NoSuchElementException {

        if(!hasNext){
            throw new NoSuchElementException();
        }

        String nextToReturn = next;
        updateNext();
        return nextToReturn;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}