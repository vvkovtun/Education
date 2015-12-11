package com.vadym.DataStruction; /**
 * Created by vvkovtun on 04/12/2015.
 */
public interface List {
    void add(Object value);

    void add(int index, Object value);

    Object get(int index);

    void set(int index, Object value);

    void remove(int index);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(Object value);

    // if not exist then -1
    int lastIndexOf(Object value);

    boolean contains(Object value);
}
