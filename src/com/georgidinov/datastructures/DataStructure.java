package com.georgidinov.datastructures;

import com.georgidinov.datastructures.iterator.Iterator;

public interface DataStructure<T> {

    Iterator<T> iterator();

}