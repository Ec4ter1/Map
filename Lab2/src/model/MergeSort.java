package model;

public class MergeSort<E extends Comparable<E>> extends AbstractSorter<E>{
    @Override
    public void sort(E[] a) {
        if (a.length <= 1) {
            return;
        }

        int mid = a.length / 2;
        E[] left = (E[]) new Comparable[mid];
        E[] right = (E[]) new Comparable[a.length - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);

        sort(left);
        sort(right);

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}
