package de.mrbuk.webredirect;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class LIFO<T> extends ArrayDeque<T> {
    @Override
    public Iterator<T> iterator() {
        return super.descendingIterator();
    }
}
