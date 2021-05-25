import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class main {

    public static void main(String[] args) {
        try {
            TimeServerInterfaceImpl time = new TimeServerInterfaceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("localhost:1099", time);

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
