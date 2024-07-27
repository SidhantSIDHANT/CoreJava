package SynchroniziedBlock;

public class SynchronizedBlocks extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("The thread is started " + Thread.currentThread().getName());
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void main(String[] arg) {
        SynchronizedBlocks thread1 = new SynchronizedBlocks();
        SynchronizedBlocks thread2 = new SynchronizedBlocks();
        SynchronizedBlocks thread3 = new SynchronizedBlocks();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}



