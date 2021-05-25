import java.util.GregorianCalendar;

public class Time {
    long time;

    public Time() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        this.time = gregorianCalendar.getTimeInMillis();
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    static Time setCurrentTime(){
        Time time = new Time();
        return time;
    }
}
