package decorator;

import java.time.LocalDateTime;

public class DelayTaskRunner extends AbstractTaskRunner{
    public DelayTaskRunner(TaskRunner taskRunner) {
        super(taskRunner);
    }

    @Override
    public void executeOneTask() {
        try{
            Thread.sleep(300);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        super.executeOneTask();
    }


}
