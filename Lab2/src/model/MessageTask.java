package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageTask extends Task{
    private String mesaj;
    private String from;
    private String to;
    private LocalDateTime date;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");

    public MessageTask(String desc, String TaskId, String mesaj, String from, String to, LocalDateTime date){
        super(TaskId, desc);
        this.mesaj = mesaj;
        this.from = from;
        this.to = to;
        this.date = date;

    }

    @Override
    public String toString() {
        return "MessageTask{" +
                "mesaj='" + mesaj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
    @Override
    public void execute() {
        System.out.println("Mesaj trimis la data:  " + date + " catre " + from + " " + getDesc());
    }
}
