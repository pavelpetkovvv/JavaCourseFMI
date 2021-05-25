import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TimeServerInterfaceImpl extends UnicastRemoteObject implements TimeServerClock {

     TimeServerInterfaceImpl() throws RemoteException {
         super();
    }

    @Override
    public Time setupClock(String clockName) {
        return Time.setCurrentTime();
    }
}
