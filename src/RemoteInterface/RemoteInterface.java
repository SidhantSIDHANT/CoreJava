package RemoteInterface;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;

interface Salary extends Remote {
    double salaryInterestRate(double d) throws RemoteException;
//     double employEmiRate();
}

class Client extends UnicastRemoteObject implements Salary {
    Client() throws RemoteException {
        super();
    }
    public double salaryInterestRate(double d) throws RemoteException {
        return d * 15 / 100;
    }
}

public class RemoteInterface {
    public static void main(String[] arg) {
        try {
            Salary obj = new Client();
            LocateRegistry.createRegistry(1800);
            Naming.rebind("rmi://localhost:1800/server", obj);
            System.out.println("running server data");
        } catch (RemoteException | MalformedURLException re) {
            re.printStackTrace();
        }
    }
}


