import java.rmi.Remote;

public interface TimeServerClock extends Remote {
    public Time setupClock(String clockName);

}
