import factory.ContainerStrategy;
import model.SortingStrategy;
import model.SortingTask;

import java.util.ArrayList;
import java.time.LocalDateTime;
import model.*;
import decorator.*;

public class Main {
    public static MessageTask[] createMessages() {
        MessageTask msg1 = new MessageTask("1", "feedback lab 2", "Te-ai descurcat bine", "teacher", "student", LocalDateTime.now());
        MessageTask msg2 = new MessageTask("2", "feedback lab 3", "Te-ai descurcat bine", "teacher", "student", LocalDateTime.now());
        MessageTask msg3 = new MessageTask("3", "feedback lab 4", "Te-ai descurcat bine", "teacher", "student", LocalDateTime.now());
        MessageTask msg4 = new MessageTask("4", "feedback lab 5", "Te-ai descurcat bine", "teacher", "student", LocalDateTime.now());
        MessageTask msg5 = new MessageTask("5", "feedback lab 6", "Te-ai descurcat bine", "teacher", "student", LocalDateTime.now());

        return new MessageTask[]{msg1, msg2, msg3, msg4, msg5};
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,5,6,3,2,7,9};
        SortingTask<Integer> sort = new SortingTask<Integer>("1","sort", a, SortingStrategy.BUBBLE);
        sort.execute();

        //tesdtare message task
        MessageTask[] messageTasks = createMessages();
        for (MessageTask messageTask: messageTasks) {
            System.out.println(messageTask);
        }

        TaskRunner strategyTaskRunner = new StrategyTaskRunner(ContainerStrategy.valueOf(args[0]));
        for (MessageTask m : messageTasks) {
            strategyTaskRunner.addTask(m);
        }
        System.out.println("test strategy runner");
        strategyTaskRunner.executeAll();

        System.out.println("test print runner");
        TaskRunner printerTaskRunner = new PrinterTaskRunner(strategyTaskRunner);
        for (MessageTask m : messageTasks) {
            printerTaskRunner.addTask(m);
        }
        printerTaskRunner.executeAll();
        System.out.println("test delay and print runner");
        TaskRunner delayTaskRunner = new DelayTaskRunner(strategyTaskRunner);
        for (MessageTask m : messageTasks) {
            delayTaskRunner.addTask(m);
        }
        delayTaskRunner.executeAll();
    }
}