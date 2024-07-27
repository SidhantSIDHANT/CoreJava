package RemoteInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Server {
    public static void main(String[] arg) {
        try {
            Salary obj = (Salary) Naming.lookup("rmi://localhost:1800/server");
            double interestRate = obj.salaryInterestRate(20000);
            System.out.println(interestRate);
        } catch (MalformedURLException | RemoteException | NotBoundException mf) {
            mf.printStackTrace();
        }
    }
}