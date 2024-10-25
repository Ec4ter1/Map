package factory;

import model.Container;
import model.Task;
import java.util.ArrayList;

public abstract class AbstractSuperclass implements Container {
    protected ArrayList<Task> lista;

    public AbstractSuperclass() {
        this.lista = new ArrayList<>();
    }

    public abstract Task remove();

    @Override
    public void add(Task task) {
        lista.add(task);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
}
