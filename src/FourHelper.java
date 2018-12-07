import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FourHelper implements Comparable<FourHelper>{

    private LocalDateTime time;

    private String rest;


    public  FourHelper(String s) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String[] split = s.split("]");

        String timeString = "20" + split[0].replace("[", "").substring(2);

        this.time = LocalDateTime.parse(timeString, formatter);

        this.rest = split[1];

    }

    public  LocalDateTime getTime() {
        return  this.time;
    }

    public  String getRest() {
        return  this.rest;
    }

    public String toString() {
        return "Date: " + time.toString() + " , rest: " + rest;
    }

    @Override
    public int compareTo(FourHelper o) {
        return  this.time.compareTo(o.time);
    }
}
