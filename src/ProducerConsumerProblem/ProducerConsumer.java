package ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer extends Thread {
    public static List<Integer> arrList = new ArrayList<Integer>(100);
    public static int capacity = 100;

    public void run() {
        if (arrList.size() == 0) {
            System.out.println("consumer is waiting state ");
        } else if (arrList.size() == capacity) {
            System.out.println("producer is waiting state ");
        } else {
            for (int i = 0; i < arrList.size(); i++) {

                try {
                    synchronized (ProducerConsumer.class) {
                        System.out.println("Buying the Producers");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] arg) throws InterruptedException {
        ProducerConsumer producer = new ProducerConsumer();
        ProducerConsumer consumer = new ProducerConsumer();
        producer.start();
        consumer.start();
        arrList.add(200);
        arrList.add(300);
        arrList.add(4000);
        System.out.println(arrList);
        if (arrList.size() == 100) {
            synchronized (producer) {
                producer.wait();
            }
        } else if (arrList.size() == 0) {
            synchronized (consumer) {
                consumer.wait();
            }
        }
    }
}
