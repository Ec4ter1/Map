package model;

public class BubbleSort<E extends Comparable<E>> extends AbstractSorter<E>{
    @Override
    public void sort(E[] a) {
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    E temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
