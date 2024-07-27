package Serializable;
import java.io.*;

public class Serializable implements java.io.Serializable {
    static File file = new File("Serializable.ser");
    transient int a = 10;
      int b = 100;
    transient int c = 200;
    transient String name = "hello";

    public String toString() {
        return this.a + " " + this.b + " " + this.c + " " + this.name;
    }

    public static void main(String[] arg) {

        Serializable obj = new Serializable();
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream outStream = new ObjectOutputStream(out);
            outStream.writeObject(obj);
            outStream.close();
            out.close();

            FileInputStream input = new FileInputStream(file);
            ObjectInputStream objStream = new ObjectInputStream(input);
            Serializable readStream = (Serializable) objStream.readObject();
            System.out.println(readStream.file);
            input.close();
            objStream.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}