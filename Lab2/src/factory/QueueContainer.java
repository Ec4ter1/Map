package factory;

import model.Container;
import model.Task;

public class QueueContainer extends AbstractSuperclass {
    public QueueContainer(){
        super();
    }

    @Override
    public Task remove() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return lista.removeLast();
    }


}
