package factory;

import model.Container;

public class TaskContainerFactory implements Factory{

    private static TaskContainerFactory INSTANCE;

    TaskContainerFactory(){}

    public static TaskContainerFactory getInstance(){
        if(INSTANCE == null){
            INSTANCE = new TaskContainerFactory();
        }
        return INSTANCE;
    }

    @Override
    public Container createContainer(ContainerStrategy strategy) {
        if (strategy == ContainerStrategy.FIFO) {
             return new QueueContainer();
        } else {
            return new StackContainer();
        }
    }
}
