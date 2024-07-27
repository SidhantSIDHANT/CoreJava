package ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

class ProductStockException extends RuntimeException {

    public ProductStockException() {
        super(" Out of order the stock ");
    }

    public ProductStockException(String s) {
        super(s);
    }

}

class CarProduct {
    List<Integer> arrList = new ArrayList<Integer>();

    int capacity = 100;

    public void getProduct() {
        arrList.add(50);
        if (arrList.size() == 0) {
            try {
                wait();
            } catch (InterruptedException ie) {
                throw new ProductStockException("Products is out of stock");
            }
        } else {
            try {
                for (int i = 0; i <= 5; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void sendData() {
        arrList.add(60);
        if (arrList.size() == capacity) {
            throw new ProductStockException("Products is out stock  ");
        } else if (arrList.size() == 0) {
            throw new ProductStockException("Proucts is out of stock");
        } else {
            try {
                for (int i = 0; i <= 5; i++) {
                    Thread.sleep(1000);
                    System.out.println(i);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    CarProduct carProduct;

    public Producer(CarProduct carProduct) {
        this.carProduct = carProduct;
    }

    @Override
    public void run() {
        this.carProduct.sendData();
    }
}

class Consumer extends Thread {
    CarProduct carProduct;

    public Consumer(CarProduct carProduct) {
        this.carProduct = carProduct;
    }

    @Override
    public void run() {
        this.carProduct.getProduct();
    }
}

public class ProducerConsumerProblemDemo {

    public static void main(String[] arg) {
        CarProduct carProduct = new CarProduct();
        Producer producer = new Producer(carProduct);
        Consumer consumer = new Consumer(carProduct);
        producer.start();
        consumer.start();
//        Thread tt1 = new Thread(producer);
//        Thread tt2 = new Thread(consumer);
//        tt1.start();
//        tt2.start();
    }
}
