package factory;
import model.Container;
import model.Task;

public class StackContainer extends AbstractSuperclass {
    public StackContainer(){
        super();
    }

    @Override
    public Task remove() {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return lista.removeFirst();
    }
}
