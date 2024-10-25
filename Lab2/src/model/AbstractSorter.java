package model;

public abstract class AbstractSorter<E extends Comparable<E>> {
    public abstract void sort(E[] a);
}

