package domain;

import java.util.Objects;

public class Tuple<T, T1> {
    private T1 t1;
    private T1 t2;

    public Tuple(T1 t1, T1 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T1 getT2() {
        return t2;
    }

    public void setT2(T1 t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(t1, tuple.t1) && Objects.equals(t2, tuple.t2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t1, t2);
    }
}
