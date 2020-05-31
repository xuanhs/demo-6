package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Productor {

    private Queue<String> products;

    public Productor(Queue<String> products) {
        this.products = products;
    }


    public void product(String product) {
        synchronized (products) {
            if (products == null) {
                products = new LinkedList<>();
            }
            if (product == null) {
                new NullPointerException();
            }
            products.add(product);
        }

    }

    public String customer() {
        synchronized (products) {
            if (products == null || products.size() <= 0) {
                return "消费失败，队列为空";
            }
            return products.poll();
        }
    }

    public static void main(String[] args) {
        Productor productor = new Productor(new LinkedList<>());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String next = scanner.nextLine();
            if ("exit".equals(next)) {
                System.out.println("结束");
                break;
            }
            if ("in".equals(next)) {
                String product = scanner.nextLine();
                productor.product(product);
            } else if ("out".equals(next)) {
                System.out.println(productor.customer());
            }

        }
    }
}
