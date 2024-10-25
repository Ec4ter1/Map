package model;

public class SortingTask<E extends Comparable<E>> extends Task {
    private E[] array;
    private AbstractSorter<E> taskSorter;
    private SortingStrategy strategie;

    public SortingTask(String taskID, String desc, E[] arr, SortingStrategy strategie) {
        super(taskID, desc);
        this.array = arr;
        this.strategie = strategie;
        if(strategie == SortingStrategy.BUBBLE){
            taskSorter = new BubbleSort<E>();
        }
        else{
            taskSorter = new MergeSort<E>();
        }
    }


    @Override
    public void execute() {
        taskSorter.sort(array);
        System.out.println("The array is:");
        for(E x : array)
            System.out.println(x);
    }
}
