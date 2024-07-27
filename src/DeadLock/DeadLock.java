package DeadLock;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DeadLockThread extends Thread {
    protected ReentrantLock l = new ReentrantLock();

    public void show() {
        l.lock();
//        this.l.lock();
//      synchronized(DeadLockThread.class){
        System.out.println(l.tryLock());

//        this.l.unlock();
        l.unlock();
    }

    @Override
    public void run() {
        this.show();
    }
}

public class DeadLock {

    public static void printListData(String s) {
        System.out.println(s);
    }

    public static void main(String[] arg) throws InterruptedException {
//        DeadLockThread thread1 = new DeadLockThread();
//        DeadLockThread thread2 = new DeadLockThread();
//        thread1.start();
//        thread2.start();
//         loop();

        List<String> list = Arrays.asList("java", "phython", "css");
//        list.forEach(ele -> {
//            printListData(ele);
//        });

        list.forEach((DeadLock::printListData));
        List list3 = list.stream().map(ele -> {
            printListData(ele);
            return ele;
        }).collect(Collectors.toList());
        System.out.println(list3);
    }
}
