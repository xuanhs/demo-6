package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Factory {

    private Queue<String> products;

    private Integer max;

    public Factory(Queue<String> products, Integer max) {
        this.products = products;
        this.max = max;
    }


    public void product(String product) throws InterruptedException {
        synchronized (products) {
            Thread.sleep(1000);
            if (products == null) {
                products = new LinkedList<>();
            }
            if (product == null) {
                throw new NullPointerException();
            }
            if (products.size() >= max) {
                products.wait();
            }
            products.add(product);
            products.notify();
        }

    }

    public String customer() throws InterruptedException {
        synchronized (products) {
            Thread.sleep(1000);
            if (products == null || products.size() <= 0) {
                products.wait();
            }

            String result = products.poll();
            products.notify();
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Factory factory = new Factory(new LinkedList<>(),5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.nextLine();
            if ("exit".equals(next)) {
                System.out.println("结束");
                break;
            }
            if ("in".equals(next)) {
                String product = scanner.nextLine();
                factory.product(product);
            } else if ("out".equals(next)) {
                System.out.println(factory.customer());
            }

        }
    }
}
