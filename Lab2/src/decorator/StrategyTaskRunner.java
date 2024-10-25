package decorator;

import factory.ContainerStrategy;
import model.Container;
import model.Task;
import factory.TaskContainerFactory;

public class StrategyTaskRunner implements TaskRunner{
    private Container container;

    public StrategyTaskRunner(ContainerStrategy strategie) {
        TaskContainerFactory factory = TaskContainerFactory.getInstance();
        this.container = factory.createContainer(strategie);
    }
    @Override
    public void executeOneTask() {
        Task task = container.remove();
        task.execute();

    }

    @Override
    public void executeAll() {
        while (hasTask()){
            executeOneTask();
        }
    }

    @Override
    public void addTask(Task t) {
        container.add(t);
    }

    @Override
    public boolean hasTask() {
        return !container.isEmpty();
    }
}
